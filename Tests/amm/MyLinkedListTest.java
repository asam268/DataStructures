package amm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList a;

    @BeforeEach
    void setUp() {
        a = new MyLinkedList();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        MyLinkedList.Node node;

        // populate linked list
        a = a.insert(a, "0");
        a = a.insert(a, "1");
        a = a.insert(a, "2");
        a = a.insert(a, "3");
        a = a.insert(a, "4");

        // it should get the value of each String inserted
        node = a.getHead();
        for (int i = 0; i < 5; i++) {
            assertEquals("" + i, node.getValue());
            node = node.getNext();
        }

        // it's last 'next' node should be null
        final MyLinkedList.Node YEET = node;
        assertThrows(NullPointerException.class, () -> YEET.getNext());
    }

    @Test
    void getHead() {
        assertNull(a.getHead());

        a = a.insert(a, "a");
        MyLinkedList.Node node = a.getHead();
        assertEquals("a", node.getValue());

        a = a.insert(a, "b");
        node = a.getHead();
        assertEquals("a", node.getValue());
    }
}