package amm;

public class DLL implements DoublyLinkedList {

    private Node head;

    static class Node implements DoublyLinkedList.Node {
        private Node next;
        private Node prev;
        private String value;

        Node(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Node node) {
            return (this.value.equals(node.getValue()));
        }

        @Override
        public Node getNext() {
            return next;
        }

        @Override
        public Node getPrev() {
            return prev;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }
    }

    DLL() {
        this.head = null;
    }

    @Override
    public DLL append(DLL list, String value) {
        Node new_node = new Node(value);
        new_node.setNext(null);
        if (list.head == null) {
            new_node.setPrev(null);
            list.setHead(new_node);
        } else {
            Node node = list.head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            new_node.setPrev(node);
            node.setNext(new_node);
        }
        return list;
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public DLL insertBefore(DLL list, Node next, String value) {
        if (next == null)
            return list;
        Node new_node = new Node(value);
        Node curr = list.getHead();
        if (curr != null) {
            if (curr.equals(next)) {
                new_node.setPrev(null);
                new_node.setNext(curr);
                curr.setPrev(new_node);
                list.setHead(new_node);
            }
            while (curr.getNext() != null && !curr.getNext().equals(next)) {
                curr = curr.getNext();
            }
            if (curr.getNext() != null) {
                new_node.setPrev(curr);
                new_node.setNext(next);
                curr.setNext(new_node);
                next.setPrev(new_node);
            }
        }
        return list;
    }

    @Override
    public DLL insertAfter(DLL list, Node prev, String value) {
        if (prev == null)
            return list;
        Node new_node = new Node(value);
        Node curr = list.getHead();

        while (curr != null && !curr.equals(prev))
            curr = curr.getNext();
        if (curr != null && curr.getNext() == null) {
            new_node.setNext(null);
            new_node.setPrev(curr);
            curr.setNext(new_node);
        } else if (curr != null) {
            prev = curr;
            curr = curr.getNext();
            new_node.setPrev(prev);
            new_node.setNext(curr);
            prev.setNext(new_node);
            curr.setPrev(new_node);
        }

        return list;
    }

    @Override
    public void printList(DLL list) {

    }

    @Override
    public DLL push(DLL list, String value) {
        Node new_node = new Node(value);
        new_node.setPrev(null);

        if (list.getHead() == null) {
            new_node.setNext(null);
            list.setHead(new_node);
        } else {
            Node node = list.head;
            new_node.setNext(node);
            node.setPrev(new_node);
            list.setHead(new_node);
        }
        return list;
    }

    @Override
    public void setHead(Node head) {
        this.head = head;
    }
}
