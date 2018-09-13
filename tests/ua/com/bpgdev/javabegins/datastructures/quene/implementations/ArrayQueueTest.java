package ua.com.bpgdev.javabegins.datastructures.quene.implementations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import ua.com.bpgdev.javabegins.datastructures.quene.interfaces.Queue;

public class ArrayQueueTest {

    private Queue prepareQueue(char charStartWith, int size) {
        Queue queue = new ArrayQueue();
        for (int index = 0; index < size; index++) {
            queue.enqueue((char) (charStartWith + index));
        }
        return queue;
    }

    @Test
    public void testEnqueue() {
        int expectedResult = 7;
        Queue queue = prepareQueue('A', expectedResult);

        assertEquals(expectedResult, queue.size());
    }

    @Test
    public void testDequeueAndSize() {
        int expectedResult = 7;
        Queue queue = prepareQueue('A', expectedResult);

        for (int index = 0; index < expectedResult; index++) {

            assertEquals((char) ('A' + index), queue.dequeue());

            assertEquals((expectedResult - (index + 1)), queue.size());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testPushThrowNoSuchElementIfSizeIsZero() {
        Queue queue = new ArrayQueue();
        queue.dequeue();
    }

    @Test
    public void testPeekAndSize() {
        int expectedResult = 7;
        Queue queue = prepareQueue('A', expectedResult);

        for (int index = 0; index < expectedResult; index++) {
            assertEquals((char) ('A'), queue.peek());
            assertEquals(expectedResult, queue.size());
        }
    }

    @Test
    public void testSize() {
        int expectedResult = 7;
        Queue queue = prepareQueue('a', expectedResult);

        assertEquals(expectedResult, queue.size());
    }

    @Test
    public void testRemove() {
        Queue queue = new ArrayQueue();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("B");
        queue.enqueue("D");

        queue.remove("B");

        assertEquals("A", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertEquals("D", queue.dequeue());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        queue.remove("D");
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());

        queue.enqueue("A");
        queue.remove("D");
        assertEquals("A", queue.dequeue());
    }

    @Test
    public void testContains() {
        boolean expectedResult = true;
        int size = 7;
        Queue queue = prepareQueue('c', size);

        for (int index = 0; index < size; index++) {

            assertEquals(expectedResult, queue.contains((char) ('c' + index)));
        }
    }

    @Test
    public void testMax() {

    }
}
