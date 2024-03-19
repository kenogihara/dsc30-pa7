/*
 * Name: Ken Ogihara
 * PID:  A16969236
 */

/**
 * Priority Queue Implementation using dHeap.
 *
 * @author Ken Ogihara
 * @since ${3/6/24}
 *
 * @param <T> the type of elements held in this collection
 */

public class MyPriorityQueue<T extends Comparable<? super T>> {

    private dHeap<T> pQueue;
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * Constructor that creates a new priority queue
     *
     * @param initialSize the given size
     */
    public MyPriorityQueue(int initialSize) {
        pQueue = new dHeap<>(DEFAULT_CAPACITY, initialSize, false);
    }

    /**
     * Inserts an element into the Priority Queue. The element received cannot be
     * null.
     *
     * @param element Element to be inserted.
     * @throws NullPointerException if the element received is null.
     * @return returns true
     */
    public boolean offer(T element) throws NullPointerException {
        pQueue.add(element);
        return true;
    }

    /**
     * Returns the number of elements in the Priority Queue.
     *
     * @return an integer.
     * */
    public int size() {
        return pQueue.size();
    }

    /**
     * Retrieve and remove the head of this Priority Queue (smallest element), or null if the
     * queue is empty.
     *
     * @return The head of the queue (smallest element), or null if queue is empty.
     */
    public T poll() {
        if (pQueue.isEmpty()) {
            return null;
        }
        return pQueue.remove();
    }

    /**
     * Clears the contents of the queue
     */
    public void clear() {
        pQueue.clear();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     *
     * @return the head of the queue, null if the queue is empty
     */
    public T peek() {
        if (pQueue.isEmpty()) {
            return null;
        }
        return pQueue.element();
    }

    /**
     * Return true is the queue is empty, false otherwise
     *
     * @return a boolean that shows whether or not the Priority Queue is empty.
     */
    public boolean isEmpty() {
        return pQueue.isEmpty();
    }
}
