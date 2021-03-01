package whg;


import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    private myList a;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        a = new myList();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @org.junit.jupiter.api.Test
    void append() {
        // it can append a String
        a.append("a");
        assertEquals(1, a.size());
        assertEquals("a", a.get(0));

        // it appends elements to the end of the array
        a.append("b");
        assertEquals(2, a.size());
        assertEquals("a", a.get(0));
        assertEquals("b", a.get(1));
    }

    @org.junit.jupiter.api.Test
    void get() {
        // it cannot get an element out of an empty list
        assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));

        // it gets the correct list item
        for (int i = 0; i < 10; i++) {
            a.append("a" + i);
            assertEquals("a" + i, a.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void remove() {
        a.append("a");
        a.append("b");
        a.append("c");

        // it creates a list correctly
        assertEquals("a", a.get(0));
        assertEquals("b", a.get(1));
        assertEquals("c", a.get(2));
        assertEquals(3, a.size());

        // it can remove the first element in the list
        a.remove(0);
        assertEquals("b", a.get(0));
        assertEquals("c", a.get(1));
        assertEquals(2, a.size());

        // its internal array decreases in size after removing
        assertThrows(IndexOutOfBoundsException.class, () -> a.get(2));

        // it can remove the middle element in the list
        a.append("d");
        assertEquals("b", a.get(0));
        assertEquals("c", a.get(1));
        assertEquals("d", a.get(2));
        assertEquals(3, a.size());
        a.remove(1);
        assertEquals("b", a.get(0));
        assertEquals("d", a.get(1));
        assertEquals(2, a.size());

        // it can remove the last element in the list
        a.append("e");
        assertEquals("b", a.get(0));
        assertEquals("d", a.get(1));
        assertEquals("e", a.get(2));
        assertEquals(3, a.size());
        a.remove(2);
        assertEquals("b", a.get(0));
        assertEquals("d", a.get(1));
        assertEquals(2, a.size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        // it's size is initially zero
        assertEquals(0, a.size());

        // it's size increases after appending variables
        for (int i = 0; i < 10; i++) {
            a.append("a");
            assertEquals(i + 1, a.size());
        }

        // it's size decreases after removing variables
        a.remove(0);
        assertEquals(9, a.size());
    }
}