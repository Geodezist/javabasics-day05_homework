package ua.com.bpgdev.javabegins.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class ListTest {
    private List listWithZeroElements;
    private List listWithTenElements;
    private List listWithOneHundredElements;

    @Before
    public void before() {
        listWithZeroElements = getList();
        listWithTenElements = getList();
        listWithOneHundredElements = getList();
        char c = 'A';

        for (int index = 0; index < 10; index++) {
            listWithTenElements.add(String.valueOf((char) (c + index)));
        }

        for (int index = 0; index < 100; index++) {
            listWithOneHundredElements.add(index % 50);
        }

    }

    abstract List getList();


    @Test
    public void testAddAndGet() {
        char c = 'A';

        listWithTenElements.add(String.valueOf(c + listWithTenElements.size()));
        assertEquals(11, listWithTenElements.size());

        assertEquals(String.valueOf(c + (listWithTenElements.size() - 1)),
                listWithTenElements.get(listWithTenElements.size() - 1));

        listWithOneHundredElements.add(100);
        listWithOneHundredElements.add(101);
        listWithOneHundredElements.add(102);

        assertEquals(103, listWithOneHundredElements.size());
    }

    @Test
    public void testAddByIndex() {

        listWithTenElements.add("X", 0);
        assertEquals("X", listWithTenElements.get(0));
        listWithTenElements.add("Y", 3);
        assertEquals("Y", listWithTenElements.get(3));
        listWithTenElements.add(null, 3);
        assertNull(listWithTenElements.get(3));
        listWithTenElements.add("Z", listWithTenElements.size());
        assertEquals("Z", listWithTenElements.get(listWithTenElements.size() - 1));
    }

    @Test
    public void testGet() {
        assertEquals(1, listWithOneHundredElements.get(1));
        assertEquals(2, listWithOneHundredElements.get(2));
        assertEquals(10, listWithOneHundredElements.get(10));
        assertEquals(0, listWithOneHundredElements.get(50));
        assertEquals(49, listWithOneHundredElements.get(99));

        Random random = new Random();
        for (int i = 0; i < listWithOneHundredElements.size(); i++) {
            int randomIndex = random.nextInt(listWithOneHundredElements.size());
            assertEquals(randomIndex % 50, listWithOneHundredElements.get(randomIndex));
        }
    }

    @Test
    public void testSet() {
        assertEquals("A", listWithTenElements.set("Z", 0));
        assertEquals("Z", listWithTenElements.get(0));

        assertEquals("B", listWithTenElements.set("Y", 1));
        assertEquals("Y", listWithTenElements.get(1));

        assertEquals("C", listWithTenElements.set("X", 2));
        assertEquals("X", listWithTenElements.get(2));

        assertEquals("D", listWithTenElements.set("Q", 3));
        assertEquals("Q", listWithTenElements.get(3));
    }

    @Test
    public void testClear() {
        listWithOneHundredElements.clear();
        assertEquals(0, listWithOneHundredElements.size());

        listWithOneHundredElements.add(1);
        assertEquals(1, listWithOneHundredElements.get(0));
    }

    @Test
    public void testSize() {
        assertEquals(100, listWithOneHundredElements.size());
        assertEquals(10, listWithTenElements.size());
        assertEquals(0, listWithZeroElements.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(listWithOneHundredElements.isEmpty());
        listWithOneHundredElements.clear();
        assertTrue(listWithOneHundredElements.isEmpty());

        assertFalse(listWithTenElements.isEmpty());
        listWithTenElements.clear();
        assertTrue(listWithTenElements.isEmpty());

        assertTrue(listWithZeroElements.isEmpty());
        listWithZeroElements.clear();
        assertTrue(listWithZeroElements.isEmpty());

    }

    @Test
    public void testContains() {
        assertTrue(listWithTenElements.contains("A"));
        assertTrue(listWithTenElements.contains("B"));
        assertTrue(listWithTenElements.contains("C"));
        assertTrue(listWithTenElements.contains("D"));

        assertFalse(listWithTenElements.contains("X"));
        assertFalse(listWithTenElements.contains("Y"));
    }

    @Test
    public void testIndexOf() {
        listWithTenElements.add(null);

        assertEquals(0, listWithTenElements.indexOf("A"));
        assertEquals(1, listWithTenElements.indexOf("B"));
        assertEquals(2, listWithTenElements.indexOf("C"));
        assertEquals(3, listWithTenElements.indexOf("D"));
        assertEquals(10, listWithTenElements.indexOf(null));


        assertEquals(-1, listWithTenElements.indexOf("X"));
        assertEquals(-1, listWithTenElements.indexOf("Y"));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(50, listWithOneHundredElements.lastIndexOf(0));
        assertEquals(51, listWithOneHundredElements.lastIndexOf(1));
        assertEquals(60, listWithOneHundredElements.lastIndexOf(10));
        assertEquals(99, listWithOneHundredElements.lastIndexOf(49));

        assertEquals(-1, listWithOneHundredElements.lastIndexOf(null));
        assertEquals(-1, listWithOneHundredElements.lastIndexOf(50));
        listWithOneHundredElements.add(null);
        assertEquals(100, listWithOneHundredElements.lastIndexOf(null));

    }

    public List getListWithZeroElements() {
        return listWithZeroElements;
    }

    public List getListWithTenElements() {
        return listWithTenElements;
    }

    public List getListWithOneHundredElements() {
        return listWithOneHundredElements;
    }
}
