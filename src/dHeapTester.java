import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class dHeapTest {
    dHeap<Integer> database;
    dHeap<String> patients;
    String[] names = {"aria", "ken", "ricky", "andrew", "arthur", "annie", "dom", "noah", "nacho"};
    dHeap<Integer> priorityQueue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        database = new dHeap<>();
        patients = new dHeap<>();
        priorityQueue = new dHeap<>(3, 7, false);
    }

    @Test
    void constructor1() {
        dHeap<Integer> defaultMaxHeap = new dHeap<>();
        // I'm basically adding 10 elements to check if it's full when there's 10 elements.
        for (int i = 0; i < 10; i++) {
            defaultMaxHeap.add(i);
        }
        assertTrue(defaultMaxHeap.isFull());
        defaultMaxHeap.clear();
        assertTrue(defaultMaxHeap.isEmpty());
        assertThrows(NoSuchElementException.class, () -> defaultMaxHeap.remove());
    }

    @Test
    void constructor2() {
        dHeap<Integer> customMaxHeap = new dHeap<>(1);
        customMaxHeap.add(4);
        assertTrue(customMaxHeap.isFull());
        customMaxHeap.add(5);
        assertTrue(customMaxHeap.isFull());

        customMaxHeap.clear();
        assertEquals(0, customMaxHeap.size());
        assertTrue(customMaxHeap.isEmpty());

        assertThrows(NullPointerException.class, () -> customMaxHeap.add(null));
    }

    @Test
    void constructor3() {
        dHeap<Integer> minHeap = new dHeap<>(3, 7, false);

        for (int i = 0; i < 7; i++) {
            minHeap.add(i);
        }
        assertTrue(minHeap.isFull());
        assertEquals(7, minHeap.size());
        assertEquals(Arrays.toString(new int[]{0, 1, 2, 3, 4, 5, 6}), minHeap.toStr());
        minHeap.clear();
        assertTrue(minHeap.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        database.add(100);
        database.add(50);
        database.add(20);
        database.add(10);
        database.add(30);
        database.add(10);
        assertEquals(6, database.size());
        database.remove();
        assertEquals(5, database.size());
        database.clear();
        assertEquals(0, database.size());

        for (int i = 0; i < 12; i++) {
            database.add(i);
        }
        assertEquals(12, database.size());

        for (int i = 0; i < 12; i++) {
            database.add(i);
            database.remove();
        }
        assertEquals(12, database.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(patients.isEmpty());
        patients.add("andrew");
        patients.add("ken");
        assertFalse(patients.isEmpty());
        patients.clear();
        assertTrue(patients.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isFull() {
        for (int i = 0; i < 10; i++) {
            database.add(10);
        }
        assertTrue(database.isFull());
        database.remove();
        assertFalse(database.isFull());
        database.add(1);
        assertTrue(database.isFull());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        //My test for max heap.
        for (int i = 0; i < 5; i++) {
            database.add(i);
        }
        assertEquals(4, database.remove());
        assertEquals(Arrays.toString(new int[]{3, 2, 1, 0}), database.toStr());
        for (int i = 6; i < 15; i++) {
            database.add(i);
        }
        assertEquals(Arrays.toString(new int[]{14, 11, 13, 8, 10, 12, 6, 0, 3, 2, 9, 1, 7}), database.toStr());
        database.clear();
        assertThrows(NoSuchElementException.class, () -> database.remove());
        database.add(1000000);
        assertEquals(1000000, database.remove());

        //My test for min heap.
        priorityQueue.add(800);
        priorityQueue.add(799);
        assertEquals(799, priorityQueue.element());
        priorityQueue.remove();
        assertEquals(800, priorityQueue.element());
        priorityQueue.remove();
        assertThrows(NoSuchElementException.class, () -> priorityQueue.remove());
    }

    @org.junit.jupiter.api.Test
    void add() {
        //My test for max heap
        assertThrows(NullPointerException.class, () -> database.add(null));
        for (String name : names) {
            patients.add(name);
        }
        assertEquals(Arrays.toString(new String[]{"ricky", "noah", "ken", "nacho", "aria", "annie",
                "dom", "andrew", "arthur"}), patients.toStr());
        patients.add("zane");
        assertEquals(Arrays.toString(new String[]{"zane", "ricky", "ken", "nacho", "noah", "annie",
                "dom", "andrew", "arthur", "aria"}), patients.toStr());

        assertTrue(patients.isFull());
        patients.add("bootise");
        assertEquals(11, patients.size());
        assertFalse(patients.isFull());

        assertThrows(NullPointerException.class, () -> patients.add(null));

        //My test for min Heap with a branching factor of 3
        for (int i = 0; i < 7; i++) {
            priorityQueue.add(i);
        }
        assertEquals(Arrays.toString(new int[]{0, 1, 2, 3, 4, 5, 6}), priorityQueue.toStr());
        priorityQueue.add(1);
        assertEquals(8, priorityQueue.size());
        assertEquals(Arrays.toString(new int[]{0, 1, 1, 3, 4, 5, 6, 2}), priorityQueue.toStr());

        for (int i = 0; i < 7; i++) {
            priorityQueue.remove();
            //System.out.println(priorityQueue.toStr());
        }
        assertEquals(6, priorityQueue.element());
        assertEquals(1, priorityQueue.size());
        assertThrows(NullPointerException.class, () -> priorityQueue.add(null));

    }

    @org.junit.jupiter.api.Test
    void clear() {
        patients.add("patient 1");
        assertEquals(1, patients.size());
        patients.clear();
        assertEquals(0, patients.size());

        for (int i = 0; i < 10000; i++) {
            patients.add("patient " + "" + i);
        }
        assertEquals("patient 9999", patients.element());
        patients.clear();
        assertEquals(0, patients.size());
    }

    @org.junit.jupiter.api.Test
    void element() {
        assertThrows(NoSuchElementException.class, () -> database.element());
        database.add(1);
        assertEquals(1, database.element());

        database.add(2);
        assertEquals(2, database.element());
        database.remove();
        assertEquals(1, database.element());
        database.remove();
        assertThrows(NoSuchElementException.class, () -> database.element());
    }

    @Test
    void toStr() {
        //My test for max heap with capacity 10.
        for (int i = 0; i < 11; i++) {
            if (i % 2 == 0) {
                database.add(i);
            }
        }
        assertEquals(Arrays.toString(new int[]{10, 6, 8, 0, 4, 2}), database.toStr());
        //System.out.println(database.toStr());

        //My test for min Heap with capacity 7.
        for (int i = 0; i < 11; i++) {
            if (i % 2 == 0) {
                priorityQueue.add(i);
            }
        }
        assertEquals(Arrays.toString(new int[]{0, 2, 4, 6, 8, 10}), priorityQueue.toStr());
        priorityQueue.clear();
        for (int i = 11; i > -1; i--) {
            if (i % 2 == 0) {
                priorityQueue.add(i);
            }
        }
        assertEquals(Arrays.toString(new int[]{0, 2, 8, 6, 10, 4}), priorityQueue.toStr());
    }
}
