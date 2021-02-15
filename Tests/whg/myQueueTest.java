package whg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class myQueueTest {

    private myQueue a;

    @BeforeEach
    void setUp() {
        a = new myQueue();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void publish() {
        // it can publish a string;
        a.publish("a");
        assertEquals(1, a.size());

        // it can publish more than one string;
        a.publish("b");
        assertEquals(2, a.size());
    }

    @Test
    void pull() {
        //it returns 0 if queue is empty
         assertNull(a.pull());

        // can pull the last item in a queue of more than 1 entries
        for (int i = 0; i <= 100; i++) {
            String entry = String.valueOf(i);
            a.publish(entry);
        }
        assertEquals("0", a.pull());

        // TODO: it removes the item from the list when pulled
    }

    @Test
    void size() {
        // size returns 0 if queue is empty
        assertEquals(0, a.size());

        // size increases by 1 when new entry is published
        for (int i = 1; i <= 100; i++) {
            String entry = String.valueOf(i);
            a.publish(entry);
            assertEquals(i, a.size());
        }

        // size decrease when entry is pulled
        for (int i = 100; i >= 1; i--) {
            assertEquals(i, a.size());
            a.pull();
        }
    }
}