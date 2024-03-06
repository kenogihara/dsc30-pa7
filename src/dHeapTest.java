import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class dHeapTest {
    dHeap<Integer> database;
    dHeap<String> patients;
    String[] names = {"aria", "ken", "ricky", "andrew", "arthur", "annie", "dom", "noah", "nacho"};

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
    }

    @org.junit.jupiter.api.Test
    void remove() {
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
    }

    @org.junit.jupiter.api.Test
    void add() {
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
        for (int i = 0; i < 11; i++) {
            if (i % 2 == 0) {
                database.add(i);
            }
        }
        assertEquals(Arrays.toString(new int[]{10, 6, 8, 0, 4, 2}), database.toStr());
        System.out.println(database.toStr());
    }
}