package amm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLLTest {

    private DLL list;
    @BeforeEach
    void setUp() {
        list = new DLL();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void append() {
        DLL.Node node;
        list = list.append(list, "a");
        node = list.getHead();
        assertEquals("a", node.getValue());
        assertNull(node.getPrev());
        assertNull(node.getNext());

        list = list.append(list, "b");
        node = list.getHead();
        node = node.getNext();
        assertEquals("b", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("a", node.getValue());

        list = list.append(list, "c");
        node = list.getHead();
        node = node.getNext();
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("b", node.getValue());
    }

    @Test
    void getHead() {
        DLL.Node node = new DLL.Node("a");
        node.setPrev(null);
        node.setNext(null);
        list = list.append(list, "a");
        assertTrue(node.equals(list.getHead()));
        list = list.push(list, "b");
        assertFalse(node.equals(list.getHead()));
        node.setPrev(list.getHead());
        DLL.Node temp = list.getHead();
        temp = temp.getNext();
        assertTrue(node.equals(temp));

    }

    @Test
    void insertBefore() {
        // it cannot be run on an empty list
        DLL.Node node;
        list = list.insertBefore(list, null, "c");
        assertNull(list.getHead());
        node = new DLL.Node("c");
        list = list.insertBefore(list, node, "c");
        assertNull(list.getHead());

        // it can insert a node at the beginning of the list
        list = list.append(list, "c");
        node = list.getHead();
        list.insertBefore(list, node, "a");
        node = list.getHead();
        assertNull(node.getPrev());
        assertEquals("a", node.getValue());
        node = node.getNext();
        assertEquals("c", node.getValue());
        node = node.getPrev();
        assertEquals("a", node.getValue());

        // it can insert a Node in the middle of the list
        node = node.getNext();
        list = list.insertBefore(list, node, "b");
        node = list.getHead();
        assertNull(node.getPrev());
        assertEquals("a", node.getValue());
        node = node.getNext();
        assertEquals("b", node.getValue());
        node = node.getPrev();
        assertEquals("a", node.getValue());
        node = node.getNext();
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("b", node.getValue());

        node = new DLL.Node("d");
        // it cannot insert before a Node that does not exist
        list = list.insertBefore(list, node, "d");
        node = list.getHead();
        assertNull(node.getPrev());
        assertEquals("a", node.getValue());
        node = node.getNext();
        assertEquals("b", node.getValue());
        node = node.getPrev();
        assertEquals("a", node.getValue());
        node = node.getNext();
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("b", node.getValue());
    }


    @Test
    void insertAfter() {
        // it cannot be run on an empty list
        DLL.Node node;
        list = list.insertAfter(list, null, "c");
        assertNull(list.getHead());
        node = new DLL.Node("c");
        list = list.insertAfter(list, node, "c");
        assertNull(list.getHead());

        // it can insert after the head in a list of size 1
        list = list.append(list, "a");
        node = list.getHead();
        list = list.insertAfter(list, node, "c");
        assertEquals("a", node.getValue());
        assertNull(node.getPrev());
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("a", node.getValue());

        // it can insert after the head in a list size greater than 1
        node = list.getHead();
        list = list.insertAfter(list, node, "b");
        assertEquals("a", node.getValue());
        assertNull(node.getPrev());
        node = node.getNext();
        assertEquals("b", node.getValue());
        node = node.getPrev();
        assertEquals("a", node.getValue());
        node = node.getNext();
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("b", node.getValue());

        // it can insert at the end of the list
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        assertNotNull(node.getPrev());
        list = list.insertAfter(list, node, "d");
        node = list.getHead();
        assertEquals("a", node.getValue());
        assertNull(node.getPrev());
        node = node.getNext();
        assertEquals("b", node.getValue());
        node = node.getPrev();
        assertEquals("a", node.getValue());
        node = node.getNext();
        node = node.getNext();
        assertEquals("c", node.getValue());
        node = node.getPrev();
        assertEquals("b", node.getValue());
        node = node.getNext();
        node = node.getNext();
        assertEquals("d", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("c", node.getValue());
    }

    @Test
    void printList() {
    }

    @Test
    void push() {
        DLL.Node node, prev;
        list = list.push(list, "c");
        node = list.getHead();
        assertEquals("c", node.getValue());
        assertNull(node.getPrev());
        assertNull(node.getNext());

        list = list.push(list, "b");
        node = list.getHead();
        assertEquals("b", node.getValue());
        assertNull(node.getPrev());
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("b", node.getValue());

        list = list.push(list, "a");
        node = list.getHead();
        assertEquals("a", node.getValue());
        assertNull(node.getPrev());
        node = node.getNext();
        assertEquals("b", node.getValue());
        node = node.getPrev();
        assertEquals("a", node.getValue());
        node = node.getNext();
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("b", node.getValue());
    }

    @Test
    void setHead() {
    }
}