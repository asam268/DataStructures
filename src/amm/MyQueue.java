package amm;

public class MyQueue {

    private int front, rear, size;
    private int capacity;
    public String[] array; // TODO: make private and update tests

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.array = new String[this.capacity];
        this.front = this.size = 0;
        this.rear = -1;
    }

    public boolean isFull() {
        return (this.size == this.capacity);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void enqueue(String value) {
        if (this.isFull())
            return;
        this.size++;
        this.array[++this.rear] = value;
    }

    public String dequeue() {
        if (!this.isEmpty()) {
            String pop = this.array[front];
            System.arraycopy(this.array, 1, this.array, front, --this.size);
            this.array[this.rear--] = null;
            return pop;
        }
        return null;
    }

    public String front() {
        return (this.isEmpty()) ? null : this.array[this.front];
    }

    public String rear() {
        return (this.isEmpty()) ? null : this.array[this.rear];
    }
}
