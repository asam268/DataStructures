package whg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyLinkedListTest {

    private whg.MyLinkedList a;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        a = new whg.MyLinkedList();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void deleteAtPosition() {
        whg.MyLinkedList.Node node;

        // it can delete from a linked list of size 1
        a = a.insert(a, "a");
        node = a.getHead();
        assertEquals("a", node.getValue());
        a = a.deleteAtPosition(a, 0);
        node = a.getHead();
        assertNull(node);

        // it can delete the head from a linked list with multiple values
        a = a.insert(a, "a");
        a = a.insert(a, "b");
        a = a.insert(a, "c");
        a = a.deleteAtPosition(a, 0);
        node = a.getHead();
        assertEquals("b", node.getValue());
        node = node.getNext();
        assertEquals("c", node.getValue());
        node = node.getNext();
        assertNull(node);

        // it can delete an item from the middle of a linked list
        a = a.insert(a, "d");
        a = a.deleteAtPosition(a, 1);
        node = a.getHead();
        assertEquals("b", node.getValue());
        node = node.getNext();
        assertEquals("d", node.getValue());
        node = node.getNext();
        assertNull(node);

        // it can delete an item from the end of a linked list
        a = a.insert(a, "e");
        a = a.deleteAtPosition(a, 2);
        node = a.getHead();
        assertEquals("b", node.getValue());
        node = node.getNext();
        assertEquals("d", node.getValue());
        node = node.getNext();
        assertNull(node);

        // it does not delete anything if there is not value for the given index
        a = a.insert(a, "f");
        a = a.deleteAtPosition(a, 4);
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
    void deleteByKey() {
        whg.MyLinkedList.Node node;

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
        whg.MyLinkedList.Node node;

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
        // it's head should be null initially
        assertNull(a.getHead());

        // it's head should be the first node
        a = a.insert(a, "a");
        whg.MyLinkedList.Node node = a.getHead();
        assertEquals("a", node.getValue());

        // it's head should not change when adding new values
        a = a.insert(a, "b");
        node = a.getHead();
        assertEquals("a", node.getValue());
    }

    @Test
    void printList() {
        // it can print an empty list
        a.printList(a);
        assertEquals("{ }", outContent.toString());

        outContent.reset();

        // it can print a list with multiple values
        a = a.insert(a, "a");
        a = a.insert(a, "b");
        a = a.insert(a, "c");

        a.printList(a);
        assertEquals("{ a b c }", outContent.toString());
    }
}