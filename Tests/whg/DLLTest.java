package whg;

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
    void deleteAtPosition() {
        DLL.Node node;

        // it does not delete anything from an empty list
        list = list.deleteAtPosition(list, 0);
        assertNull(list.getHead());
        list = list.deleteAtPosition(list, 5);
        assertNull(list.getHead());

        // it can delete from a list of one
        list = list.append(list, "0");
        list = list.deleteAtPosition(list, 0);
        assertNull(list.getHead());

        // it can delete the head from a linked list with multiple values
        list = list.append(list, "0");
        list = list.append(list, "0");
        list = list.append(list, "1");
        list = list.append(list, "2");
        list = list.append(list, "3");
        list = list.deleteAtPosition(list, 0);
        traverse(list, 4);

        // it can delete a Node from the middle of the linked list
        list = new DLL();
        list = list.append(list, "0");
        list = list.append(list, "1");
        list = list.append(list, "1");
        list = list.append(list, "2");
        list = list.append(list, "3");
        list = list.deleteAtPosition(list, 2);
        traverse(list, 4);

        // it can delete a Node from the end of the linked list
        list = list.deleteAtPosition(list, 3);
        traverse(list, 3);

        // it does not delete anything if there is not a value for the given index
        list = list.deleteAtPosition(list, 5);
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
        list = list.append(list, "1");
        node = list.getHead();
        list.insertBefore(list, node, "0");
        traverse(list, 2);

        // it can insert a Node in the middle of the list
        list = new DLL();
        list = list.append(list, "0");
        list = list.append(list, "2");
        node = new DLL.Node("2");
        list = list.insertBefore(list, node, "1");
        traverse(list, 3);

        // it cannot insert before a Node that does not exist
        node = new DLL.Node("d");
        list = list.insertBefore(list, node, "d");
        traverse(list, 3);
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
        list = list.append(list, "0");
        node = list.getHead();
        list = list.insertAfter(list, node, "1");
        traverse(list, 2);

        // it can insert after the head in a list size greater than 1
        list = new DLL();
        list = list.append(list, "0");
        list = list.append(list, "2");
        node = list.getHead();
        list = list.insertAfter(list, node, "1");
        traverse(list, 3);

        // it can insert at the end of the list
        while (node.getNext() != null)
            node = node.getNext();
        list = list.insertAfter(list, node, "3");
        traverse(list, 4);

        // it can insert in the middle of the list
        list = new DLL();
        list = list.append(list, "0");
        list = list.append(list, "1");
        list = list.append(list, "3");
        list = list.append(list, "4");

        node = new DLL.Node("1");
        list = list.insertAfter(list, node, "2");
        traverse(list, 5);
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
        list = list.push(list, "0");
        traverse(list, 1);

        // it pushes the Node to the front of the list
        list = new DLL();
        list = list.push(list, "1");
        list = list.push(list, "0");
        traverse(list, 2);

        // it properly allocates all pointers
        list = new DLL();
        list = list.push(list, "4");
        list = list.push(list, "3");
        list = list.push(list, "2");
        list = list.push(list, "1");
        list = list.push(list, "0");
        traverse(list, 5);
    }

    @Test
    void setHead() {
        assertNull(list.getHead());
        DLL.Node node = new DLL.Node("a");
        list.setHead(node);
        assertNotNull(list.getHead());
    }

    /**
     * This method traverses a linked list and makes assertions on the expected values of a properly formatted list.
     * The nodes are expected to have values ranging from 0..size
     *
     * Example:
     * list:    { 0 1 2 3 4 }
     * size:    5
     *
     * @param list  doubly linked list
     * @param size  expected size of the linked list
     */
    void traverse (DLL list, int size) {
        DLL.Node node = list.getHead();
        int i = 0;
        while (i < size) {
            if (i == 0) { // first node
                assert node != null;
                assertNull(node.getPrev());
                assertEquals("" + i, node.getValue());
                if (size == 1) // if this is the only node
                    assertNull(node.getNext());
                node = node.getNext();
                i++;
            } else if (i == size - 1){ // last node
                assertEquals("" + i, node.getValue());
                assertNull(node.getNext());
                node = node.getPrev();
                assertEquals("" + (i - 1), node.getValue());
                i++;
            } else { // nodes in the middle
                assert node != null;
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