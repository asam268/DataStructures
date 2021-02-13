package amm;

class MyLinkedList {

    private Node[] list;

    private static class Node {
        private String value;
        private Node next;

        Node(String value) {
            this.value = "";
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    MyLinkedList() {
        this.list = new Node[0];
    }

    void insert(int idx, String value) {
        Node[] temp = list;
        list = new Node[temp.length + 1];
        System.arraycopy(temp, 0, list, 0, temp.length);

        list[list.length - 1] = new Node("value");
    }

}
