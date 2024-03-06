import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class dHeapTest {
    dHeap<Integer> database;
    dHeap<String> patients;
    String[] names = {"aria", "ken", "ricky", "andrew", "arthur", "annie", "leo", "noah", "nacho"};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
       database = new dHeap<>();
       patients = new dHeap<>();
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
    }

    @org.junit.jupiter.api.Test
    void remove() {
        for (int i = 0; i < 5; i++) {
            database.add(i);
        }
        assertEquals(4, database.remove());
        assertEquals(Arrays.toString(new int[]{3, 2, 1, 0}), database.toString());
        for (int i = 6; i < 15; i++) {
            database.add(i);
        }
        assertEquals(Arrays.toString(new int[]{14, 11, 13, 8, 10, 12, 6, 0, 3, 2, 9, 1, 7}), database.toString());
        database.clear();
        assertThrows(NoSuchElementException.class, () -> database.remove());
        database.add(1000000);
        assertEquals(1000000, database.remove());
    }

    @org.junit.jupiter.api.Test
    void add() {
        for (String name : names) {
            patients.add(name);
        }
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void element() {
    }
}