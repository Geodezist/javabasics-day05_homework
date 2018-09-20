package ua.com.bpgdev.javabegins.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ua.com.bpgdev.javabegins.datastructures.stack.LinkedStack;
import ua.com.bpgdev.javabegins.datastructures.stack.Stack;

import java.util.NoSuchElementException;

public class LinkedStackTest {
    private Stack stack;
    private Stack stackOfFive;

    @Before
    public void setUp() throws Exception {
        stack = new LinkedStack();

        stackOfFive = new LinkedStack();
        stackOfFive.push("A");
        stackOfFive.push("B");
        stackOfFive.push("C");
        stackOfFive.push("D");
        stackOfFive.push("E");
    }

    @Test
    public void testPush() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("E");

        assertEquals(4, stack.size());
    }

    @Test
    public void testPop() {
        assertEquals("E", stackOfFive.pop());
        assertEquals("D", stackOfFive.pop());
        assertEquals("C", stackOfFive.pop());
        assertEquals("B", stackOfFive.pop());
        assertEquals("A", stackOfFive.pop());

        assertEquals(0, stackOfFive.size());
    }

    @Test
    public void testPeek() {
        for (int index = 0; index < stackOfFive.size(); index++) {
            assertEquals("E", stackOfFive.peek());
        }
        assertEquals(5, stackOfFive.size());
    }

    @Test
    public void testSize() {
        assertEquals(5, stackOfFive.size());
        for (int index = 0; index < 5; index++) {
            stackOfFive.pop();
        }
        assertEquals(0,stackOfFive.size());
    }

    @Test
    public void testRemove() {
        assertTrue(stackOfFive.contains("C"));
        assertEquals(5, stackOfFive.size());

        stackOfFive.remove("C");

        assertFalse(stackOfFive.contains("C"));
        assertEquals(4, stackOfFive.size());

        stackOfFive.remove("E");
        assertFalse(stackOfFive.contains("E"));

        stackOfFive.remove("A");
        assertFalse(stackOfFive.contains("A"));

    }

    @Test
    public void testContains() {
        assertTrue(stackOfFive.contains("B"));
        assertFalse(stackOfFive.contains("X"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIllegalArgumentException() {
        stack.push(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void getNoSuchElementException() {
        stack.pop();
    }
}