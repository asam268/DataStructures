package amm;

public interface DoublyLinkedList {

    interface Node {
        boolean equals(DLL.Node node);
        DLL.Node getNext();
        DLL.Node getPrev();
        String getValue();
        void setNext(DLL.Node next);
        void setPrev(DLL.Node prev);
        void setValue(String value);
    }
    DLL append(DLL list, String value);
    DLL deleteAtPosition(DLL list, String value);
    DLL deleteByKey(DLL list, String value);
    DLL.Node getHead();
    DLL insertBefore(DLL list, DLL.Node next, String value);
    DLL insertAfter(DLL list, DLL.Node prev, String value);
    void printList(DLL list);
    DLL push(DLL list, String value);
    void setHead(DLL.Node head);
}
