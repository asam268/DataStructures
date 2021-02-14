package amm;


import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    private MyList a;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        a = new MyList();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @org.junit.jupiter.api.Test
    void append() {
        a.append("a");
        assertEquals(1, a.size());
        assertEquals("a", a.get(0));

        a.append("b");
        assertEquals(2, a.size());
        assertEquals("a", a.get(0));
        assertEquals("b", a.get(1));
    }

    @org.junit.jupiter.api.Test
    void get() {
        // it fails when getting an index out of bounds
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
        assertEquals("{ a b c }", a.toString());
        assertEquals(3, a.size());

        // it can remove the first element in the list
        a.remove(0);
        assertEquals("{ b c }", a.toString());
        assertEquals(2, a.size());

        // it can remove the middle element in the list
        a.append("d");
        assertEquals("{ b c d }", a.toString());
        assertEquals(3, a.size());
        a.remove(1);
        assertEquals("{ b d }", a.toString());
        assertEquals(2, a.size());

        // it can remove the last element in the list
        a.append("e");
        assertEquals("{ b d e }", a.toString());
        assertEquals(3, a.size());
        a.remove(2);
        assertEquals("{ b d }", a.toString());
        assertEquals(2, a.size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        // it's size is initially zero
        Assertions.assertEquals(0, a.size());

        // it's size increases after appending variables
        for (int i = 0; i < 10; i++) {
            a.append("a");
            Assertions.assertEquals(i+1, a.size());
        }

        // it's size decreases after removing variables
        a.remove(0);
        Assertions.assertEquals(9, a.size());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}