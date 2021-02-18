package amm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {     // TODO: update tests to no longer use internal MyQueue array

    private MyQueue a;

    @BeforeEach
    void setUp() {
        a = new MyQueue(100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isFull() {
        assertFalse(a.isFull());
        for (int i = 0; i < 100; i++) {
            a.enqueue("a");
        }
        assertTrue(a.isFull());
        a.dequeue();
        assertFalse(a.isFull());
    }

    @Test
    void isEmpty() {
        assertTrue(a.isEmpty());
        a.enqueue("a");
        assertFalse(a.isEmpty());
        a.dequeue();
        assertTrue(a.isEmpty());
    }

    // FIXME: 2/13/2021
    @Test
    void enqueue() {
        a.enqueue("a");
        assertEquals("a", a.array[0]);
        a.enqueue("b");
        assertEquals("b", a.array[1]);
    }

    // FIXME: 2/13/2021
    @Test
    void dequeue() {
        a.enqueue("a");
        a.enqueue("b");
        a.enqueue("c");

        assertEquals("a", a.dequeue());
        assertEquals("b", a.array[0]);
        assertEquals("c", a.array[1]);
        assertNotEquals("c", a.array[2]);

        assertEquals("b", a.dequeue());
        assertEquals("c", a.array[0]);

        a.enqueue("d");
        assertEquals("c", a.array[0]);
        assertEquals("d", a.array[1]);
        assertEquals("c", a.dequeue());
        assertEquals("d", a.array[0]);
        assertNull(a.array[1]);

        assertEquals("d", a.dequeue());
        assertNull(a.dequeue());
    }

    @Test
    void front() {
        assertNull(a.front());
        a.enqueue("a");
        assertEquals("a", a.front());
        a.enqueue("b");
        assertEquals("a", a.front());
        a.dequeue();
        assertEquals("b", a.front());
    }

    @Test
    void rear() {
        assertNull(a.rear());
        a.enqueue("a");
        assertEquals("a", a.rear());
        a.enqueue("b");
        assertEquals("b", a.rear());
        a.enqueue("c");
        assertEquals("c", a.rear());

        a.dequeue();
        assertEquals("c", a.rear());
        a.dequeue();
        assertEquals("c", a.rear());
        a.dequeue();
        assertNull(a.rear());
    }
}