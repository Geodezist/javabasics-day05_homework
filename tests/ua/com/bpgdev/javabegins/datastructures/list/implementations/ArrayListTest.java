package ua.com.bpgdev.javabegins.datastructures.list.implementations;

import ua.com.bpgdev.javabegins.datastructures.list.interfaces.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayListTest {

    List listWithZeroElements;
    List listWithFiveElements;
    List listWithTenElements;

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
    public void testAddByIndex(){
        listWithFiveElements.add("X", 4);
        listWithFiveElements.add("Y", 5);
        listWithFiveElements.add("Z", 6);
        assertEquals(8,listWithFiveElements.size());
        assertEquals("X", listWithFiveElements.get(4));
        assertEquals("Y", listWithFiveElements.get(5));
        assertEquals("Z", listWithFiveElements.get(6));
    }

    @Test
    public void testClear(){
        listWithFiveElements.clear();
        listWithTenElements.clear();
        listWithZeroElements.clear();
        assertEquals(0 , listWithFiveElements.size());
        assertEquals(0 , listWithTenElements.size());
        assertEquals(0 , listWithZeroElements.size());
    }

    @Test
    public void testSet(){
        assertEquals("A", listWithFiveElements.set("Z", 0));
        assertEquals("Z", listWithFiveElements.get(0));
        assertEquals("B", listWithFiveElements.set("Y", 1));
        assertEquals("Y", listWithFiveElements.get(1));
        assertEquals("C", listWithFiveElements.set("X", 2));
        assertEquals("X", listWithFiveElements.get(2));
    }

    @Test
    public void testIsEmpty(){
        assertTrue(listWithZeroElements.isEmpty());
        assertFalse(listWithFiveElements.isEmpty());
        listWithFiveElements.clear();
        assertTrue(listWithFiveElements.isEmpty());
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