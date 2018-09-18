package ua.com.bpgdev.javabegins.datastructures.list.implementations;

import ua.com.bpgdev.javabegins.datastructures.list.interfaces.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayListTest {

    private List listWithZeroElements;
    private List listWithFiveElements;
    private List listWithTenElements;

    @Before
    public void before() {
        listWithZeroElements = new ArrayList();
        listWithFiveElements = new ArrayList();
        listWithTenElements = new ArrayList();

        listWithFiveElements.add("A");
        listWithFiveElements.add("B");
        listWithFiveElements.add("C");
        listWithFiveElements.add("D");
        listWithFiveElements.add("E");

        for (int i = 0; i < 10; i++) {
            listWithTenElements.add(i);
        }
    }

    @Test
    public void testGetFromListWithFiveElements() {
        assertEquals("A", listWithFiveElements.get(0));
        assertEquals("B", listWithFiveElements.get(1));
        assertEquals("C", listWithFiveElements.get(2));
        assertEquals("D", listWithFiveElements.get(3));
        assertEquals("E", listWithFiveElements.get(4));
    }

    @Test
    public void testGetFromListWithTenElements() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, listWithTenElements.get(i));
        }
    }

    @Test
    public void testAddByIndex() {
        listWithFiveElements.add("X", 4);
        listWithFiveElements.add("Y", 5);
        listWithFiveElements.add("Z", 6);
        assertEquals(8, listWithFiveElements.size());
        assertEquals("X", listWithFiveElements.get(4));
        assertEquals("Y", listWithFiveElements.get(5));
        assertEquals("Z", listWithFiveElements.get(6));
    }

    @Test
    public void testClear() {
        listWithFiveElements.clear();
        listWithTenElements.clear();
        listWithZeroElements.clear();
        assertEquals(0, listWithFiveElements.size());
        assertEquals(0, listWithTenElements.size());
        assertEquals(0, listWithZeroElements.size());
    }

    @Test
    public void testSet() {
        assertEquals("A", listWithFiveElements.set("Z", 0));
        assertEquals("Z", listWithFiveElements.get(0));
        assertEquals("B", listWithFiveElements.set("Y", 1));
        assertEquals("Y", listWithFiveElements.get(1));
        assertEquals("C", listWithFiveElements.set("X", 2));
        assertEquals("X", listWithFiveElements.get(2));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(listWithZeroElements.isEmpty());
        assertFalse(listWithFiveElements.isEmpty());
        listWithFiveElements.clear();
        assertTrue(listWithFiveElements.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(listWithFiveElements.contains("A"));
        assertTrue(listWithFiveElements.contains("B"));
        assertTrue(listWithFiveElements.contains("C"));
        assertTrue(listWithFiveElements.contains("D"));
        assertTrue(listWithFiveElements.contains("E"));
        assertFalse(listWithFiveElements.contains("F"));

        for (int index = 0; index < listWithTenElements.size(); index++) {
            assertTrue(listWithTenElements.contains(index));
            assertFalse(listWithFiveElements.contains(-1 * index));
        }

    }

    @Test
    public void testIndexOf() {
        for (int index = 0; index < listWithTenElements.size(); index++) {
            assertEquals(index, listWithTenElements.indexOf(index));
        }

        assertEquals(0, listWithFiveElements.indexOf("A"));
        assertEquals(1, listWithFiveElements.indexOf("B"));
        assertEquals(2, listWithFiveElements.indexOf("C"));
        assertEquals(3, listWithFiveElements.indexOf("D"));
        assertEquals(4, listWithFiveElements.indexOf("E"));

        assertEquals(-1, listWithFiveElements.indexOf("X"));
        assertEquals(-1, listWithFiveElements.indexOf("Y"));
    }

    @Test
    public void testLastIndexOf() {
        for (int index = 0; index < listWithTenElements.size(); index++) {
            assertEquals(listWithTenElements.size() - index - 1, listWithTenElements.lastIndexOf(index));
        }

        assertEquals(4, listWithFiveElements.lastIndexOf("A"));
        assertEquals(3, listWithFiveElements.lastIndexOf("B"));
        assertEquals(2, listWithFiveElements.lastIndexOf("C"));
        assertEquals(1, listWithFiveElements.lastIndexOf("D"));
        assertEquals(0, listWithFiveElements.lastIndexOf("E"));

        assertEquals(-1, listWithFiveElements.lastIndexOf("X"));
        assertEquals(-1, listWithFiveElements.lastIndexOf("Y"));

    }

    @Test
    public void testToString() {
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", listWithTenElements.toString());
        assertEquals("[A, B, C, D, E]", listWithFiveElements.toString());
        assertEquals("[]", listWithZeroElements.toString());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFromIndexLessThanZero() {
        listWithFiveElements.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFromIndexGreaterThanSize() {
        listWithFiveElements.get(5);
    }

    @Test
    public void testSize() {
        assertEquals(5, listWithFiveElements.size());
        assertEquals(0, listWithZeroElements.size());
    }


}