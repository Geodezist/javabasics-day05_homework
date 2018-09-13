package ua.com.bpgdev.javabegins.datastructures.quene.implementations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedQueueTest {


    @Test
    public void testEnqueue() {
        final int expectedResult = 10;
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int index = 0; index < expectedResult; index++) {
            linkedQueue.enqueue((char) ('A' + 1));
        }
        assertEquals(expectedResult, linkedQueue.size());
    }

    @Test
    public void testDequeue() {
        final int expectedResult = 10;
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int index = 0; index < expectedResult; index++) {
            linkedQueue.enqueue((char) ('A' + 1));
        }

        for (int index = 0; index < expectedResult; index++) {
            assertEquals((char) ('A' + 1), linkedQueue.dequeue());
        }

        assertEquals(0, linkedQueue.size());

    }
}
