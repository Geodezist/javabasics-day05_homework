package ua.com.bpgdev.javabegins.datastructures.list.implementations;

import ua.com.bpgdev.javabegins.datastructures.list.interfaces.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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