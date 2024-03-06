/*
 * Name: Ken Ogihara
 * PID:  A16969236
 */

import java.util.NoSuchElementException;

/**
 * Title: dHeap Description: This program creates a Heap with d branching factor
 *
 * @author Ken Ogihara
 * @since ${3/5/24}
 *
 * @param <T> the type of elements held in this collection
 */

public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {

    private T[] heap;   // backing array
    private int d;      // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // indicates whether heap is max or min

    /*Declare constants and magic numbers*/
    private static final int DEFAULT_CAPACITY = 10;
    private static final int BRANCHING_FACTOR = 2;
    private static final int STARTING_POS = 0;

    /**
     * Initializes a binary max heap with capacity = 10
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        d = BRANCHING_FACTOR;
        isMaxHeap = true;
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        d = BRANCHING_FACTOR;
        isMaxHeap = true;
        heap = (T[]) new Comparable[heapSize];
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        this.d = d;
        this.isMaxHeap = isMaxHeap;
        heap = (T[]) new Comparable[heapSize];
    }

    @Override
    public int size() {
        return nelems;
    }

    public boolean isEmpty() {
        return nelems == 0;
    }

    public boolean isFull() {
        return nelems == heap.length;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        T root = heap[STARTING_POS];
        heap[STARTING_POS] = heap[nelems - 1];
        heap[nelems - 1] = null;
        trickleDown(STARTING_POS);
        nelems--;
        return root;
    }

    @Override
    public void add(T item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        if (isFull()) {
            resize();
        }
        heap[nelems] = item;
        bubbleUp(nelems);
        nelems++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        nelems = 0;
    }

    @Override
    public T element() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        return heap[STARTING_POS];
    }

    private int parent(int index) {
        return (index - 1) / d;
    }

    private void bubbleUp(int index) {
        while (parent(index) >= 0 && heap[index].compareTo(heap[parent(index)]) > 0) {
            swap(index, parent(index));
        }
    }

    private void swap(int pos1, int pos2) {
        T temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    private void trickleDown(int index) {
        int[] childIndices = new int[d];
        for (int i = 1; i <= d; i++) {
            childIndices[i] = d * index + i;
        }
        int maxChild = index;
        for (int i : childIndices) {
            if (i <= (nelems - 1) && heap[i].compareTo(heap[maxChild]) > 0) {
                maxChild = i;
            }
        }
        if (maxChild != index) {
            swap(maxChild, index);
            trickleDown(maxChild);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        System.arraycopy(heap, STARTING_POS, heap = (T[]) new Comparable[DEFAULT_CAPACITY],
                STARTING_POS, nelems);
    }
}
