package whg;

public class MyLinkedList implements LinkedList {
    Node head;

    public MyLinkedList() {
        this.head = null;
    }

    static class Node implements LinkedList.Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public Node getNext() {
            return next;
        }

        @Override
        public void setNext(Node next) {
            this.next = next;
        }
    }


    @Override
    public MyLinkedList deleteAtPosition(MyLinkedList list, int index) {
        Node prev = list.getHead();
        Node curr = prev.getNext();
        int count = 0;

        if (index == 0) {
            list.setHead(curr);
        }
        while (curr != null) {
            count += 1;
            if (count == index) {
                prev.setNext(curr.getNext());
            }
            prev = prev.getNext();
            curr = curr.getNext();
        }

        return list;
    }

    @Override
    public MyLinkedList deleteByKey(MyLinkedList list, String value) {
        Node prev = list.getHead();
        Node curr = prev.getNext();

        if (prev.getValue().equals(value)) {
            list.setHead(curr);
        } else {
            while (curr != null) {
                if (curr.getValue().equals(value)) {
                    prev.setNext(curr.getNext());
                }
                prev = prev.getNext();
                curr = curr.getNext();
            }
        }
        return list;
    }

    @Override
    public MyLinkedList insert(MyLinkedList list, String value) {
        Node newNode = new Node(value);
        newNode.setNext(null);

        if (list.getHead() == null) {
            list.setHead(newNode);
        } else {
            Node prev = list.getHead();
            while (prev.getNext() != null) {
                prev = prev.getNext();
            }
            prev.setNext(newNode);
        }
        return list;
    }

    @Override
    public Node getHead() {
        return this.head;
    }

    @Override
    public void printList(MyLinkedList list) {
        Node prev = list.getHead();
        if (prev == null) {
            System.out.print("{ }");

        } else {
            System.out.print("{ " + prev.getValue() + " ");
            while (prev.getNext() != null) {
                prev = prev.getNext();
                System.out.print(prev.getValue() + " ");
            }
            System.out.print("}");
        }
    }

    @Override
    public void setHead(Node head) {
        this.head = head;
    }


}
