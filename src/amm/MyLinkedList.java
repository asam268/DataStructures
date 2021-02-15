package amm;

class MyLinkedList {

    private Node head;

    static class Node {
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
            try {
                return this.next;
            } catch (NullPointerException e) {
                return null;
            }
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    MyLinkedList() {
        head = null;
    }

    MyLinkedList deleteAtPosition(MyLinkedList list, int index) {
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
    
    MyLinkedList deleteByKey(MyLinkedList list, String value) { // FIXME: 2/14/2021 
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

    MyLinkedList insert(MyLinkedList list, String value) {
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

    Node getHead() {
        return this.head;
    }

    void printList(MyLinkedList list) {
        Node node = list.getHead();

        System.out.print("{ ");
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.print("}");
    }

    private void setHead(Node head) {
        this.head = head;
    }

}
