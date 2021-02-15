package amm;

class MyLinkedList implements LinkedList{

    private Node head;

    static class Node implements LinkedList.Node {
        private String value;
        private Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    MyLinkedList() {
        head = null;
    }

    public MyLinkedList deleteAtPosition(MyLinkedList list, int index) {
        Node node = list.getHead(), prev = null;
        if (node != null && index == 0) {
            list.setHead(node.getNext());
        }

        int i = 0;
        while (node != null && index != i++) {
            prev = node;
            node = node.getNext();
        }

        if (node != null && prev != null) {
            prev.setNext(node.getNext());
        }

        return list;
    }
    
    public MyLinkedList deleteByKey(MyLinkedList list, String value) {
        Node node = list.getHead();
        Node prev = null;
        if (node != null && node.getValue().equals(value))
            list.head = node.getNext();


        while (node != null && !node.getValue().equals(value)) {
            prev = node;
            node = node.getNext();
        }

        if (node != null && prev != null) {
            prev.setNext(node.getNext());
        }

        return list;
    }

    public MyLinkedList insert(MyLinkedList list, String value) {
        Node node = new Node(value);
        node.setNext(null);
        if (list.getHead() == null)
            list.setHead(node);
        else {
            Node last = list.getHead();
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
        return list;
    }

    public Node getHead() {
        return this.head;
    }

    public void printList(MyLinkedList list) {
        Node node = list.getHead();

        System.out.print("{ ");
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.print("}");
    }

    public void setHead(Node head) {
        this.head = head;
    }

}
