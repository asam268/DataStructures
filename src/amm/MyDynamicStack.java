package amm;

/**
 * @author Asa Marshall
 *
 * amm.MyDynamicStack is a resizable stack of Strings
 */
class MyDynamicStack {

    private String[] stack; // array to hold values in the stack
    private int top;        // The "Parser" which marks the top of the stack

    MyDynamicStack() {
        stack = new String[0];
        top = -1;
    }

    /**
     * Return true if the stack is empty
     *
     * @return boolean
     */
    boolean isEmpty() {
        return (top < 0);
    }

    /**
     * Shows the String at the top of the stack
     *
     * @return String
     */
    String peek() {
        return (top < 0) ? null : stack[top];
    }

    /**
     * Gets the String at the top of the stack and decreases the stack's size
     *
     * @return String
     */
    String pop() {
        if (top < 0)
            return null;
        String result = stack[top];
        String[] temp = new String[top];
        System.arraycopy(stack, 0, temp, 0, top--);
        stack = temp;
        return result;
    }

    /**
     * Increases the size of the stack and adds a String to the top of the stack
     *
     * @param value     to be pushed to the top of the stack
     */
    void push(String value) {
        String[] temp = new String[top + 2];
        System.arraycopy(stack, 0, temp, 0, ++top);
        stack = temp;
        stack[top] = value;
    }
}
