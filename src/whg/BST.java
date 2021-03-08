package whg;

/*
TODO: finish this skeleton code to implement a Binary Search Tree
Method explanations are in the interface.
Remember to add constructors and necessary private variables for these classes.
Also, you may want to add some extra methods to get the BST to work. Methods from the interface have already been
overridden here, but you can add as many methods as you want without editing the interface.
 */
public class BST implements BinarySearchTree {

    static class Node implements BinarySearchTree.Node {

        @Override
        public int getValue() {
            return 0;
        }

        @Override
        public void setValue(int value) {

        }

        @Override
        public Node getLeft() {
            return null;
        }

        @Override
        public void setLeft(Node left) {

        }

        @Override
        public Node getRight() {
            return null;
        }

        @Override
        public void setRight(Node right) {

        }
    }

    @Override
    public Node getRoot() {
        return null;
    }

    @Override
    public void insert(int value) {

    }

    @Override
    public void print() {

    }

    @Override
    public Node search(Node root, int value) {
        return null;
    }
}
