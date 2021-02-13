package amm;

/**
 * amm.MyStack is a statically sized stack of Strings
 */
class MyStack {

    private final int MAX = 1000;               // default size of the stack
    private int top;                            // The "Parser" which marks the top of the stack
    private String[] stack = new String[MAX];   // array to hold values in the stack

    MyStack() {
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
     * @return String or null if the stack is empty
     */
    String peek() {
        return (top < 0) ? null : stack[top];
    }

    /**
     * Remove and return String at the top of the stack
     *
     * @return String or null to mark underflow condition
     */
    String pop() {
        return (top < 0) ? null : stack[top--];
    }

    /**
     * Add an item to the top of the stack
     * Return true if the item is successfully pushed
     * Return false to mark an overflow condition
     *
     * @param value to be pushed to the top of the stack
     * @return      boolean
     */
    boolean push(String value) {
        if (top >= (MAX - 1)) {
            return false;
        }
        else {
            stack[++top] = value;
            return true;
        }
    }
}
