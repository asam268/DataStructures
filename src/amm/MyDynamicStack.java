package amm;

public class MyDynamicStack {

    private String[] stack;
    private int top;

    public MyDynamicStack() {
        stack = new String[0];
        top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public String peek() {
        return (top < 0) ? null : stack[top];
    }

    public String pop() {
        if (top < 0)
            return null;
        String result = stack[top];
        String[] temp = new String[top];
        System.arraycopy(stack, 0, temp, 0, top--);
        stack = temp;
        return result;
    }

    public void push(String value) {
        String[] temp = new String[top + 2];
        System.arraycopy(stack, 0, temp, 0, ++top);
        stack = temp;
        stack[top] = value;
    }
}
