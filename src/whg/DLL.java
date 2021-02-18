package whg;

public class DLL implements DoublyLinkedList {
    private Node head;

    public DLL() {
        this.head = null;
    }


    static class Node implements DoublyLinkedList.Node {
        private String value;
        private Node next;
        private Node prev;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Node node) {
            return this.value.equals(node.getValue());
        }

        @Override
        public Node getNext() {
            return this.next;
        }

        @Override
        public Node getPrev() {
            return this.prev;
        }

        @Override
        public String getValue() {
            return this.value;
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

    @Override
    public DLL append(DLL list, String value) {
        Node newNode = new Node(value);

        if (list.getHead() == null) {
            list.setHead(newNode);

        } else {
            Node node = list.getHead();

            while (node.getNext() != null) {
                node = node.getNext();
            }
            newNode.setPrev(node);
            node.setNext(newNode);

        }
        return list;
    }

    @Override
    public DLL deleteAtPosition(DLL list, int index) {
        return null;
    }

    @Override
    public DLL deleteByKey(DLL list, String value) {
        Node node = list.getHead();

        while (node != null) {
            if (node.getValue().equals(value)) {
                Node prev = node.getPrev();
                Node next = node.getNext();
                if (next == null && prev == null) {
                    list.setHead(null);
                }
                else if (next == null) {
                    prev.setNext(null);
                } else if (prev == null) {
                    next.setPrev(null);
                    list.setHead(next);
                } else {
                    prev.setNext(next);
                    next.setPrev(prev);
                }
            }
            node = node.getNext();
        }


        return list;
    }

    @Override
    public void printList(DLL list) {
        Node node = list.getHead();

        if (node == null) {
            System.out.print("{ }\n{ }");
        } else {
            System.out.print("{ " + node.getValue() + " ");
            while (node.getNext() != null) {
                node = node.getNext();
                System.out.print(node.getValue() + " ");
            }
            System.out.print("}");
            System.out.print("\n");
            System.out.print("{ " + node.getValue() + " ");
            while (node.getPrev() != null) {
                node = node.getPrev();
                System.out.print(node.getValue() + " ");
            }
            System.out.print("}");
        }
    }

    @Override
    public DLL push(DLL list, String value) {
        Node newNode = new Node(value);

        if (list.getHead() == null) {
            list.setHead(newNode);
        } else {
            Node node = list.getHead();
            node.setPrev(newNode);
            newNode.setNext(node);
            newNode.setPrev(null);
        }
        list.setHead(newNode);
        return list;
    }

    @Override
    public DLL insertBefore(DLL list, Node next, String value) {
        Node newNode = new Node(value);
        Node node = list.getHead();

        if (list.getHead() == null) {
            list.setHead(null);
        } else if (node.equals(next)) {
            newNode.setNext(node);
            node.setPrev(newNode);
            list.setHead(newNode);
        } else {
            Node curr = node.getNext();
            while (node != null) {
                if (curr.equals(next)) {
                    newNode.setPrev(node);
                    newNode.setNext(curr);

                    curr.setPrev(newNode);
                    node.setNext(newNode);
                    break;
                }
                node = node.getNext();
                curr = curr.getNext();
            }
        }
        return list;

    }

    @Override
    public DLL insertAfter(DLL list, Node prev, String value) {
        Node newNode = new Node(value);
        Node node = list.getHead();

        if (list.getHead() == null) {
            list.setHead(null);
        } else {
            Node curr = node.getNext();
            while (node != null) {
                if (node.equals(prev)) {
                    newNode.setPrev(node);
                    newNode.setNext(curr);
                    if (curr != null) {
                        curr.setPrev(newNode);
                    }
                    node.setNext(newNode);
                    break;
                }
                node = node.getNext();
                curr = curr.getNext();
            }
        }
        return list;
    }

    @Override
    public void setHead(Node head) {
        this.head = head;
    }

    @Override
    public Node getHead() {
        return this.head;
    }


}
