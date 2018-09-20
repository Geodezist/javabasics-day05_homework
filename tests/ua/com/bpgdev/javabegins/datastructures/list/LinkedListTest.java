package ua.com.bpgdev.javabegins.datastructures.list;

import org.junit.Before;
import org.junit.Test;
import ua.com.bpgdev.javabegins.datastructures.list.LinkedList;

import java.util.Random;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList linkedListWithZeroElements;
    private LinkedList linkedListWithTenElements;
    private LinkedList linkedListWithOneHundredElements;

    @Before
    public void before() {
        linkedListWithZeroElements = new LinkedList();
        linkedListWithTenElements = new LinkedList();
        linkedListWithOneHundredElements = new LinkedList();
        char c = 'A';

        for (int index = 0; index < 10; index++) {
            linkedListWithTenElements.add(String.valueOf((char) (c + index)));
        }

        for (int index = 0; index < 100; index++) {
            linkedListWithOneHundredElements.add(index % 50);
        }
    }

    @Test
    public void testAddAndGet() {
        char c = 'A';

        linkedListWithTenElements.add(String.valueOf(c + linkedListWithTenElements.size()));
        assertEquals(11, linkedListWithTenElements.size());

        assertEquals(String.valueOf(c + (linkedListWithTenElements.size() - 1)),
                linkedListWithTenElements.get(linkedListWithTenElements.size() - 1));

        linkedListWithOneHundredElements.add(100);
        linkedListWithOneHundredElements.add(101);
        linkedListWithOneHundredElements.add(102);

        assertEquals(103, linkedListWithOneHundredElements.size());

    }

    @Test
    public void testAddByIndex() {

        linkedListWithTenElements.add("X", 0);
        assertEquals("X", linkedListWithTenElements.get(0));
        linkedListWithTenElements.add("Y", 3);
        assertEquals("Y", linkedListWithTenElements.get(3));
        linkedListWithTenElements.add(null, 3);
        assertNull(linkedListWithTenElements.get(3));
        linkedListWithTenElements.add("Z", linkedListWithTenElements.size());
        assertEquals("Z", linkedListWithTenElements.get(linkedListWithTenElements.size() - 1));

    }

    @Test
    public void testRemove() {
    }


    @Test
    public void testGet() {
        assertEquals(1, linkedListWithOneHundredElements.get(1));
        assertEquals(2, linkedListWithOneHundredElements.get(2));
        assertEquals(10, linkedListWithOneHundredElements.get(10));
        assertEquals(0, linkedListWithOneHundredElements.get(50));
        assertEquals(49, linkedListWithOneHundredElements.get(99));

        Random random = new Random();
        for (int i = 0; i < linkedListWithOneHundredElements.size(); i++) {
            int randomIndex = random.nextInt(linkedListWithOneHundredElements.size());
            assertEquals(randomIndex % 50, linkedListWithOneHundredElements.get(randomIndex));
        }
    }

    @Test
    public void testGetUsingStream() {
        assertEquals(1, linkedListWithOneHundredElements.getUsingStream(1));
        assertEquals(2, linkedListWithOneHundredElements.getUsingStream(2));
        assertEquals(10, linkedListWithOneHundredElements.getUsingStream(10));
        assertEquals(0, linkedListWithOneHundredElements.getUsingStream(50));
        assertEquals(49, linkedListWithOneHundredElements.getUsingStream(99));
    }


    @Test
    public void testSet() {
        assertEquals("A", linkedListWithTenElements.set("Z", 0));
        assertEquals("Z", linkedListWithTenElements.get(0));

        assertEquals("B", linkedListWithTenElements.set("Y", 1));
        assertEquals("Y", linkedListWithTenElements.get(1));

        assertEquals("C", linkedListWithTenElements.set("X", 2));
        assertEquals("X", linkedListWithTenElements.get(2));

        assertEquals("D", linkedListWithTenElements.set("Q", 3));
        assertEquals("Q", linkedListWithTenElements.get(3));
    }

    @Test
    public void testClear() {
        linkedListWithOneHundredElements.clear();
        assertEquals(0, linkedListWithOneHundredElements.size());

        assertNull(linkedListWithOneHundredElements.getHead());
        assertNull(linkedListWithOneHundredElements.getTail());

        linkedListWithOneHundredElements.add(1);
        assertEquals(1, linkedListWithOneHundredElements.get(0));
    }

    @Test
    public void testSize() {
        assertEquals(100, linkedListWithOneHundredElements.size());
        assertEquals(10, linkedListWithTenElements.size());
        assertEquals(0, linkedListWithZeroElements.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(linkedListWithOneHundredElements.isEmpty());
        linkedListWithOneHundredElements.clear();
        assertTrue(linkedListWithOneHundredElements.isEmpty());

        assertFalse(linkedListWithTenElements.isEmpty());
        linkedListWithTenElements.clear();
        assertTrue(linkedListWithTenElements.isEmpty());

        assertTrue(linkedListWithZeroElements.isEmpty());
        linkedListWithZeroElements.clear();
        assertTrue(linkedListWithZeroElements.isEmpty());

    }

    @Test
    public void testContains() {
        assertTrue(linkedListWithTenElements.contains("A"));
        assertTrue(linkedListWithTenElements.contains("B"));
        assertTrue(linkedListWithTenElements.contains("C"));
        assertTrue(linkedListWithTenElements.contains("D"));

        assertFalse(linkedListWithTenElements.contains("X"));
        assertFalse(linkedListWithTenElements.contains("Y"));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, linkedListWithTenElements.indexOf("A"));
        assertEquals(1, linkedListWithTenElements.indexOf("B"));
        assertEquals(2, linkedListWithTenElements.indexOf("C"));
        assertEquals(3, linkedListWithTenElements.indexOf("D"));

        assertEquals(-1, linkedListWithTenElements.indexOf("X"));
        assertEquals(-1, linkedListWithTenElements.indexOf("Y"));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(50, linkedListWithOneHundredElements.lastIndexOf(0));
        assertEquals(51, linkedListWithOneHundredElements.lastIndexOf(1));
        assertEquals(60, linkedListWithOneHundredElements.lastIndexOf(10));
        assertEquals(99, linkedListWithOneHundredElements.lastIndexOf(49));

        assertEquals(-1, linkedListWithOneHundredElements.lastIndexOf(null));
        assertEquals(-1, linkedListWithOneHundredElements.lastIndexOf(50));
        linkedListWithOneHundredElements.add(null);
        assertEquals(100, linkedListWithOneHundredElements.lastIndexOf(null));

    }
}