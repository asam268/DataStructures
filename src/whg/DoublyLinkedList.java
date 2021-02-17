package whg;

public interface DoublyLinkedList { // TODO: implement the DoublyLinkedList interface

    interface Node {
        /**
         * Returns true if the value of this node equals the value of the given node.
         * Useful for quickly identifying matching nodes.
         *
         * Example: curr_node.equals(next_node);
         *
         * @param node  Non-null Node
         * @return  boolean
         */
        boolean equals(DLL.Node node);
        DLL.Node getNext();
        DLL.Node getPrev();
        String getValue();
        void setNext(DLL.Node next);
        void setPrev(DLL.Node prev);
        void setValue(String value);
    }
    DLL append(DLL list, String value);             //  TODO: append a value to the end of the list
//    DLL deleteAtPosition(DLL list, int index);        TODO: implement the commented methods last
//    DLL deleteByKey(DLL list, String value);
    DLL.Node getHead();
//    DLL insertBefore(DLL list, DLL.Node next, String value);
//    DLL insertAfter(DLL list, DLL.Node prev, String value);

    /**
     * Prints every value in the linked list forward and backward order.
     * The orders are separated by a newline escape character \n
     *
     * Example: list.printList(list);
     * Output:
     * { a b c }
     * { c b a }
     *
     * @param list  the linked list
     */
    void printList(DLL list);
    DLL push(DLL list, String value);   // TODO: push a value to the beginning of the linked list
    void setHead(DLL.Node head);
}
