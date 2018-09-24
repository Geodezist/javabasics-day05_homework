package ua.com.bpgdev.javabegins.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest extends ListTest {

    @Override
    List getList() {
        return new LinkedList();
    }


    @Test
    public void testRemove() {
    }


    @Test
    public void testGetUsingStream() {
        assertEquals(1, ((LinkedList) getListWithOneHundredElements()).getUsingStream(1));
        assertEquals(2, ((LinkedList) getListWithOneHundredElements()).getUsingStream(2));
        assertEquals(10, ((LinkedList) getListWithOneHundredElements()).getUsingStream(10));
        assertEquals(0, ((LinkedList) getListWithOneHundredElements()).getUsingStream(50));
        assertEquals(49, ((LinkedList) getListWithOneHundredElements()).getUsingStream(99));
    }

    @Override
    public void testClear() {
        getListWithOneHundredElements().clear();
        assertEquals(0, getListWithOneHundredElements().size());

        assertNull(((LinkedList) getListWithOneHundredElements()).getHead());
        assertNull(((LinkedList) getListWithOneHundredElements()).getTail());

        getListWithOneHundredElements().add(1);
        assertEquals(1, getListWithOneHundredElements().get(0));
    }
}