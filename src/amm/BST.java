package amm;

public class BST implements BinarySearchTree {

    static class Node implements BinarySearchTree.Node {
        private int value;
        private Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public Node getLeft() {
            return left;
        }

        @Override
        public void setLeft(Node left) {
            this.left = left;
        }

        @Override
        public Node getRight() {
            return right;
        }

        @Override
        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.getValue())
            root.setLeft(insertRec(root.getLeft(), value));
        else if (value > root.getValue())
            root.setRight(insertRec(root.getRight(), value));

        return root;
    }

    @Override
    public void print() {
        printRec(root);
    }

    void printRec(Node root) {
        if (root != null) {
            printRec(root.getLeft());
            System.out.println(root.getValue());
            printRec(root.getRight());
        }
    }

    public Node search(Node root, int value) {
        if (root == null || root.getValue() == value)
            return root;

        if (root.getValue() < value)
            return search(root.getRight(), value);

        return search(root.getLeft(), value);
    }
}
