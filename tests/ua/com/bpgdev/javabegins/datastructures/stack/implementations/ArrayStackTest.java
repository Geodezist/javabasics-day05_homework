package ua.com.bpgdev.javabegins.datastructures.stack.implementations;

import org.junit.Test;
import ua.com.bpgdev.javabegins.datastructures.stack.interfaces.Stack;

import static org.junit.Assert.assertEquals;
import java.util.NoSuchElementException;

public class ArrayStackTest {
    @Test
    public void testPushAndPop() {
        Stack stack = new ArrayStack();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        // good test!!!!
        assertEquals(3, stack.size());
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushAndPopWithGrow() {
        Stack stack = new ArrayStack();


        for (int i = 0; i < 10; i++) {
            char valueToAdd = (char) ('A' + i);
            stack.push(valueToAdd);
        }

        // F7 (step into), F8 (step over), F9 (resume)
        // good test!!!!
        assertEquals(10, stack.size());
        for (int i = 9; i >= 0; i--) {
            char expectedValue = (char) ('A' + i);

            assertEquals(expectedValue, stack.pop());
        }

        assertEquals(0, stack.size());
    }

    @Test
    public void testPushAndPeek() {
        Stack stack = new ArrayStack();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        // good test!!!!
        assertEquals(3, stack.size());
        assertEquals("C", stack.peek());
        assertEquals(3, stack.size());
        assertEquals("C", stack.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPushThrowNoSuchElementIfSizeIsZero() {
        Stack stack = new ArrayStack();

        stack.pop();
    }

}