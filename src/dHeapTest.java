import static org.junit.jupiter.api.Assertions.*;

class dHeapTest {
    dHeap<Integer> database;
    dHeap<String> patients;

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
        System.out.println(database.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void isFull() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void element() {
    }
}