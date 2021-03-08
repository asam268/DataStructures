package amm;

interface BinarySearchTree {

    interface Node {
        int getValue();
        void setValue(int value);
        BST.Node getLeft();
        void setLeft(BST.Node left);
        BST.Node getRight();
        void setRight(BST.Node right);
    }

    BST.Node getRoot(); // get the root of the BST
    void insert(int value); // create a Node and insert it into the BST
    void print(); // println BST Node values from least to greatest
    BST.Node search(BST.Node root, int value); // search the BST for a certain value, return the node if found else return null
}
