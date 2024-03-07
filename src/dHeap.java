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
    private static final int DOUBLE_SIZE = 2;
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

    /**
     * Method that returns the number of nodes in the heap.
     *
     * @return an integer that represents the heapsize.
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * Method that returns if a heap is empty.
     *
     * @return a boolean that shows whether the heap is empty or not.
     */
    public boolean isEmpty() {
        return nelems == 0;
    }

    /**
     * Method that returns if a heap is full.
     *
     * @return a boolean that shows whether the heap is full or not.
     */
    public boolean isFull() {
        return nelems == heap.length;
    }

    /**
     * Method that returns and removes the root element in a heap.
     *
     * @return T the root node.
     * @throws NoSuchElementException if the heap is empty.
     */
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

    /**
     * Method that appends a new node to the heap.
     *
     * @param item generic item that is added to the heap.
     * @throws NullPointerException if the item is null.
     */
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

    /**
     * Method that deletes all elements in a heap.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        nelems = 0;
    }

    /**
     * Method that returns the root element of the heap.
     *
     * @return T root node
     * @throws NoSuchElementException if the heap is empty.
     */
    @Override
    public T element() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        return heap[STARTING_POS];
    }

    /**
     * Helper method that returns the parent index of its child/children.
     *
     * @param index of the child node.
     * @return the index of its parent's position as an integer.
     */
    private int parent(int index) {
        return (index - 1) / d;
    }

    /**
     * Helper method that bubbles up a node to its correction position, so it does not violate
     * any heap property rules.
     *
     * @param index of the child.
     * */
    private void bubbleUp(int index) {
        if (isMaxHeap) {
            while (parent(index) >= 0 && heap[index].compareTo(heap[parent(index)]) > 0) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
        else {
            while (parent(index) >= 0 && heap[index].compareTo(heap[parent(index)]) < 0) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
    }

    /**
     * Helper method that swaps the position of two elements.
     *
     * @param pos1 the index position of the first element.
     * @param pos2 the index position of the second element.
     */
    private void swap(int pos1, int pos2) {
        T temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    /**
     * Helper method that trickles down a node to its correction position, so it does not violate
     * any heap property rules.
     *
     * @param index of the root node.
     * */
    private void trickleDown(int index) {
        if (isMaxHeap) {
            int[] childIndices = new int[d];
            for (int i = 0; i < d; i++) {
                childIndices[i] = d * index + i + 1;
            }
            int maxChild = index;
            for (int i : childIndices) {
                if (i <= (nelems - 1) && heap[i] != null && heap[i].compareTo(heap[maxChild]) > 0) {
                    maxChild = i;
                }
            }
            if (maxChild != index) {
                swap(maxChild, index);
                trickleDown(maxChild);
            }
        } else {
            int[] childIndices = new int[d];
            for (int i = 0; i < d; i++) {
                childIndices[i] = d * index + i + 1;
            }
            int minChild = index;
            for (int i : childIndices) {
                if (i <= (nelems - 1) && heap[i] != null && heap[i].compareTo(heap[minChild]) < 0) {
                    minChild = i;
                }
            }
            if (minChild != index) {
                swap(minChild, index);
                trickleDown(minChild);
            }
        }
    }

    /**
     * Helper method that doubles the size of the heap.
     * */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newHeap = (T[]) new Comparable[heap.length * DOUBLE_SIZE];
        System.arraycopy(heap, STARTING_POS, newHeap, STARTING_POS, nelems);
        heap = newHeap;
    }

    /**
     * Helper method that outputs string representation of a given heap.
     *
     * @return a string representation of a heap.
     * */
    public String toStr() {
        StringBuilder output = new StringBuilder();
        String startBracket = "[";
        String endBracket = "]";
        for (int i = 0; i < nelems; i++) {
            output.append(heap[i]);
            if (i != nelems - 1) {
                output.append(", ");
            }
        }
        return startBracket + "" + output + "" + endBracket;
    }
}
