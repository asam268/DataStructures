package amm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    private BST tree;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        tree = new BST();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void insert() {
        BST.Node root, left, right;

        // it sets the root to the first inserted node
        tree.insert(5);
        root = tree.getRoot();
        assertEquals(5, root.getValue());

        // it sets nodes with lesser values to left leaf of the root
        tree.insert(2);
        left = root.getLeft();
        assertEquals(5, root.getValue());
        assertEquals(2, left.getValue());

        // it sets nodes with higher values to the right leaf of the root
        tree.insert(8);
        right = root.getRight();
        assertEquals(5, tree.getRoot().getValue());
        assertEquals(2, left.getValue());
        assertEquals(8, right.getValue());

        // it can continue the hierarchy down the left side
        tree.insert(3);
        tree.insert(1);
        root = root.getLeft();
        left = root.getLeft();
        right = root.getRight();
        assertEquals(2, root.getValue());
        assertEquals(1, left.getValue());
        assertEquals(3, right.getValue());

        root = tree.getRoot();

        // it can continue the hierarchy down the right side
        tree.insert(7);
        tree.insert(9);
        root = root.getRight();
        left = root.getLeft();
        right = root.getRight();
        assertEquals(8, root.getValue());
        assertEquals(7, left.getValue());
        assertEquals(9, right.getValue());

        root = tree.getRoot();

        // it continues the hierarchy to the third leaf level
        tree.insert(4);
        tree.insert(6);
        tree.insert(10);

        root = root.getLeft();
        root = root.getRight();
        right = root.getRight();
        assertEquals(4, right.getValue());

        root = tree.getRoot();
        root = root.getRight();
        root = root.getLeft();
        left = root.getLeft();
        assertEquals(6, left.getValue());

        root = tree.getRoot();
        root = root.getRight();
        root = root.getRight();
        right = root.getRight();
        assertEquals(10, right.getValue());
    }

    @Test
    void print() {
        String nl = System.getProperty("line.separator");
        StringBuilder expected = new StringBuilder();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(2);
        tree.insert(9);
        tree.insert(10);

        tree.print();
        for (int i = 1; i <= 10; i++) {
            expected.append(i).append(nl);
        }
        assertEquals(expected.toString(), outContent.toString());
    }

    @Test
    void search() {
        BST.Node root, result;

        // it can search the root
        tree.insert(5);
        root = tree.getRoot();
        result = tree.search(root,5);
        assertEquals(5, result.getValue());

        // it can search values on multiple leaf levels of the tree
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(2);
        tree.insert(9);
        tree.insert(10);

        for (int i = 1; i <=10; i++) {
            result = tree.search(root, i);
            assertEquals(i, result.getValue());
        }

        // it returns null when not found
        result = tree.search(root, 11);
        assertNull(result);
    }
}