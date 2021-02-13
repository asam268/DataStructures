package amm;

public class MyStack {

    private final int MAX = 1000;
    private int top;
    private String[] stack = new String[MAX];

    public MyStack() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public String peek() {
        return (top < 0) ? null : stack[top];
    }

    public String pop() {
        return (top < 0) ? null : stack[top--];
    }

    public boolean push(String value) {
        if (top >= (MAX - 1)) {
            return false;
        }
        else {
            stack[++top] = value;
            return true;
        }
    }
}
