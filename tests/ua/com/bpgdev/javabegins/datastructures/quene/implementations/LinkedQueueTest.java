package ua.com.bpgdev.javabegins.datastructures.quene.implementations;

import org.junit.Before;
import org.junit.Test;
import ua.com.bpgdev.javabegins.datastructures.quene.interfaces.Queue;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LinkedQueueTest {
    private Queue linkedQueue;

    @Before
    public void setUp() {
        linkedQueue = new LinkedQueue();
    }


    @Test
    public void testEnqueue() {
        final int expectedResult = 10;
        for (int index = 0; index < expectedResult; index++) {
            linkedQueue.enqueue((char) ('A' + 1));
        }
        assertEquals(expectedResult, linkedQueue.size());
    }

    @Test
    public void testDequeue() {
        final int expectedResult = 10;
        for (int index = 0; index < expectedResult; index++) {
            linkedQueue.enqueue((char) ('A' + 1));
        }

        for (int index = 0; index < expectedResult; index++) {
            assertEquals((char) ('A' + 1), linkedQueue.dequeue());
        }

        assertEquals(0, linkedQueue.size());
    }

    @Test
    public void testRemove() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        linkedQueue.enqueue("E");
        assertEquals(5, linkedQueue.size());

        linkedQueue.remove("C");
        assertFalse(linkedQueue.contains("C"));
        assertEquals(4, linkedQueue.size());

        linkedQueue.remove("E");
        assertFalse(linkedQueue.contains("E"));
        assertEquals(3, linkedQueue.size());

        linkedQueue.remove("A");
        assertFalse(linkedQueue.contains("A"));
        assertEquals(2, linkedQueue.size());

        linkedQueue.remove("X");
        assertEquals(2, linkedQueue.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIllegalArgumentException() {
        linkedQueue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void getNoSuchElementException() {
        linkedQueue.dequeue();
    }


}
