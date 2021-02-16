package amm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DLLTest {

    private DLL list;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    void setUp() {
        list = new DLL();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void append() {
        // it can append
        DLL.Node node;
        list = list.append(list, "0");
        traverse(list, 1);

        // it appends the Node to the end of the list
        list = list.append(list, "1");
        traverse(list, 2);

        list = list.append(list, "2");
        traverse(list, 3);
    }

    @Test
    void deleteByKey() {
        DLL.Node node;
        // it won't delete anything out of an empty list
        list = list.deleteByKey(list, "0");
        assertNull(list.getHead());

        // it can delete from a linked list of size 1
        list = list.append(list, "0");
        list = list.deleteByKey(list, "0");
        assertNull(list.getHead());

        // it can delete the head of a linked list with multiple values
        list = list.append(list, "0");
        list = list.append(list, "0");
        list = list.append(list, "1");

        list = list.deleteByKey(list, "0");
        traverse(list, 2);

        // it can delete a Node from the middle of the list
        list = new DLL();
        list = list.append(list, "0");
        list = list.append(list, "1");
        list = list.append(list, "2");
        list = list.append(list, "2");
        list = list.append(list, "3");

        list = list.deleteByKey(list, "2");
        traverse(list, 4);

        // it can delete a Node from the end of the list
        list = list.deleteByKey(list, "3");
        traverse(list, 3);

        // it does not delete anything when the key is not found in the list
        list = list.deleteByKey(list, "3");
        traverse(list, 3);
    }

    @Test
    void getHead() {
        assertNull(list.getHead());
        list = list.append(list, "a");
        assertNotNull(list.getHead());
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
        // it can print an empty list
        list.printList(list);
        assertEquals("{ }\n{ }", outContent.toString());

        outContent.reset();

        // it can print a list with multiple values
        list = list.append(list, "a");
        list = list.append(list, "b");
        list = list.append(list, "c");

        list.printList(list);
        assertEquals("{ a b c }\n{ c b a }", outContent.toString());
    }

    @Test
    void push() {
        // it can push to an empty list
        DLL.Node node, prev;
        list = list.push(list, "c");
        node = list.getHead();
        assertEquals("c", node.getValue());
        assertNull(node.getPrev());
        assertNull(node.getNext());

        // it pushes the Node to the front of the list
        list = list.push(list, "b");
        node = list.getHead();
        assertEquals("b", node.getValue());
        assertNull(node.getPrev());
        node = node.getNext();
        assertEquals("c", node.getValue());
        assertNull(node.getNext());
        node = node.getPrev();
        assertEquals("b", node.getValue());

        // it properly allocates all pointers
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
        assertNull(list.getHead());
        DLL.Node node = new DLL.Node("a");
        list.setHead(node);
        assertNotNull(list.getHead());
    }

    void traverse (DLL list, int size) {
        DLL.Node node = list.getHead();
        int i = 0;
        while (i < size) {
            if (i == 0) {
                assertNull(node.getPrev());
                assertEquals("" + i, node.getValue());
                node = node.getNext();
                i++;
            } else if (i == size - 1){
                assertEquals("" + i, node.getValue());
                assertNull(node.getNext());
                node = node.getPrev();
                assertEquals("" + (i - 1), node.getValue());
                i++;
            } else {
                assertEquals("" + i, node.getValue());
                node = node.getPrev();
                assertEquals("" + (i - 1), node.getValue());
                node = node.getNext();
                node = node.getNext();
                i++;
            }
        }
    }
}