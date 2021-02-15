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
    
    MyLinkedList deleteByKey(MyLinkedList list, String value) { // FIXME: 2/14/2021 
        Node node = list.getHead();
        if (node.getNext() != null && node.getValue().equals(value)) {
            
        }
        return null;
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

    private void setHead(Node head) {
        this.head = head;
    }

}
