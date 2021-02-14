package whg;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private myStack a;
    @BeforeEach
    void setUp() {
        a = new myStack();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isEmpty() {
        // it is empty by default
        assertTrue(a.isEmpty());

        // it is not empty after pushing
        a.push("a");
        assertFalse(a.isEmpty());

        // it is empty after popping all values
        a.pop();
        assertTrue(a.isEmpty());
    }

    @Test
    void peek() {
        assertTrue(a.isEmpty());

        // it returns 0 by default
        assertNull(a.peek());

        // it returns the correct number after pushing
        a.push("a");
        assertEquals("a", a.peek());
        a.push("b");
        assertEquals("b", a.peek());

        // it returns the correct number after popping
        a.pop();
        assertEquals("a", a.peek());
    }

    @Test
    void pop() {
        assertTrue(a.isEmpty());

        a.push("a");
        a.push("b");
        // it pops the top element
        assertEquals("b", a.pop());

        // it decrements the top index correctly
        assertEquals("a", a.pop());

        // it returns 0 if the stack is empty
        assertTrue(a.isEmpty());
        assertNull(a.pop());

        // it does not over decrement the top index
        assertNull(a.pop());
        a.push("c");
        assertEquals("c", a.pop());
    }

    @Test
    void push() {
        a.push("a");
        a.push("b");
        a.push("c");

        assertEquals("c", a.pop());
        assertEquals("b", a.pop());
        assertEquals("a", a.pop());

        a.push("d");
        assertEquals("d", a.peek());
    }
}