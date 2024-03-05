/*
 * Name: Ken Ogihara
 * PID:  A16969236
 */

import java.util.Arrays;
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

    @Override
    public boolean isEmpty() {
        return nelems == 0;
    }

    @Override
    public boolean isFull() {
        return nelems == heap.length;
    }

    @Override
    public T remove() throws NoSuchElementException {
        // TODO
        return null;
    }

    @Override
    public void add(T item) throws NullPointerException {
        if ()
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        // TODO
    }

    @Override
    public T element() throws NoSuchElementException {
        // TODO
        return null;
    }

    private int parent(int index) {
        // TODO
        return 0;
    }

    private void bubbleUp(int index) {
        // TODO
    }

    private void trickleDown(int index) {
        // TODO
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        System.arraycopy(heap, STARTING_POS, heap = (T[]) new Comparable[DEFAULT_CAPACITY],
                STARTING_POS, nelems);
    }

}
