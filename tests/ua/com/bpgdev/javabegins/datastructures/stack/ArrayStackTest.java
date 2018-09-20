package ua.com.bpgdev.javabegins.datastructures.stack;

import org.junit.Test;
import ua.com.bpgdev.javabegins.datastructures.stack.ArrayStack;
import ua.com.bpgdev.javabegins.datastructures.stack.Stack;

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

    @Test(expected = IllegalArgumentException.class)
    public void testPushThrowIllegalArgumentNull() {
        Stack stack = new ArrayStack();
        stack.push(null);
    }


    @Test
    public void testRemove(){
        Stack stack = new ArrayStack();
        stack.push("F");
        stack.push("A");
        stack.push("B");
        stack.push("C");

        stack.remove("B");
        assertEquals(3,stack.size());

    }

    @Test
    public void testRemoveAll(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("B");
        arrayStack.push("B");
        arrayStack.push("B");
        arrayStack.push("B");
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("B");
        arrayStack.push("C");
        arrayStack.push("B");

        arrayStack.removeAll("B");
        assertEquals(2, arrayStack.size());
    }

}