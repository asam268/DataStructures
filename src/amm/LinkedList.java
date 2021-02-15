package amm;

/**
 * The LinkedList interface displays the structure for the MyLinkedList object. MyLinkedList should have a global
 * variable 'head', which is the head Node of the linked list. In the constructor for MyLinkedList, head should be set
 * to null by default.
 *
 * This interface can be implemented by adding this to your class declaration:
 * class MyLinkedList implements LinkedList { ... }
 */
public interface LinkedList {

    /**
     * MyLinkedList should use a subclass 'Node' to keep track of data for each Node. The Node subclass should have
     * global variables 'value' and 'next'. 'value' is the String value of the current Node, and 'next' is the next Node
     * in the linked list.
     *
     * This interface can be implemented by adding this to your subclass declaration:
     * static class Node implements LinkedList.Node { ... }
     */
    interface Node {
        /**
         * Gets the String value of the current Node
         *
         * @return  String
         */
        String getValue();

        /**
         * Sets the String value of the current Node to the given String
         *
         * @param value String to be set
         */
        void setValue(String value);

        /**
         * Gets the next Node in the Linked List
         *
         * @return  Node
         */
        MyLinkedList.Node getNext();

        /**
         * Sets the next Node to the given Node
         *
         * @param next  Node to be set
         */
        void setNext(MyLinkedList.Node next);
    }

    /**
     * Deletes the Node at the given index in the linked list. The method will traverse the linked list until reaching
     * the given index, and then set the 'next' value of the previous node to the 'next' value of the current Node
     *
     * Example: list = list.deleteAtPosition(list, 0);
     *
     * @param list  the linked list
     * @param index index of the node to be removed
     * @return      the linked list
     */
    MyLinkedList deleteAtPosition(MyLinkedList list, int index);

    /**
     * Deletes the Node which has a value that matches the given value. The method will traverse the linked list until
     * reaching the Node that matches the given value, and then set the 'next' value of the previous node to the 'next'
     * value of the current node
     *
     * Example: list = list.deleteByKey(list, "a");
     *
     * @param list  the linked list
     * @param value value of the Node to be removed
     * @return      the linked list
     */
    MyLinkedList deleteByKey(MyLinkedList list, String value);

    /**
     * Inserts the given value into a new Node at the end of the linked list. The method will traverse the linked list
     * until reaching the last node, and then will set the 'next' value of the last node to the new node. The new node
     * should then have a 'next' value of null
     *
     * Example: list = list.insert(list, "a");
     *
     * @param list  the linked list
     * @param value the value to be added to a new Node
     * @return      the linked list
     */
    MyLinkedList insert(MyLinkedList list, String value);

    /**
     * Returns the head Node of the linked list
     *
     * @return MyLinkedList.Node
     */
    MyLinkedList.Node getHead();

    /**
     * Prints every value in the linked list
     *
     * Example: list.printList(list);
     * Output:  { a b c }
     *
     * @param list  the linked list
     */
    void printList(MyLinkedList list);

    /**
     * Sets the head of the linked list to the given Node
     *
     * @param head  the Node to be set as head of the linked list
     */
    void setHead(MyLinkedList.Node head);
}
