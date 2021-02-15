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
    void deleteByKey() {
        MyLinkedList.Node node;

        // it can delete from a linked list of size 1
        a = a.insert(a, "a");
        node = a.getHead();
        assertEquals("a", node.getValue());
        a = a.deleteByKey(a, "a");
        assertNull(a.getHead());

        // it can delete the head from a linked list with multiple values
        a = a.insert(a, "a");
        a = a.insert(a, "b");
        a = a.insert(a, "c");
        node = a.getHead();
        assertEquals("a", node.getValue());
        a = a.deleteByKey(a, "a");
        node = a.getHead();
        assertEquals("b", node.getValue());

        // it can delete an item from the middle of the linked list
        a = a.insert(a, "d");
        a = a.deleteByKey(a, "c");
        node = a.getHead();
        assertEquals("b", node.getValue());
        node = node.getNext();
        assertEquals("d", node.getValue());

        // it can delete an item from the end of the linked list
        a = a.insert(a, "e");
        a = a.deleteByKey(a, "e");
        node = a.getHead();
        assertEquals("b", node.getValue());
        node = node.getNext();
        assertEquals("d", node.getValue());
        node = node.getNext();
        assertNull(node);

        // it does not delete anything when the key is not found in the list
        a = a.insert(a, "f");
        a.deleteByKey(a, "e");
        node = a.getHead();
        assertEquals("b", node.getValue());
        node = node.getNext();
        assertEquals("d", node.getValue());
        node = node.getNext();
        assertEquals("f", node.getValue());
        node = node.getNext();
        assertNull(node);
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
        assertNull(node);
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