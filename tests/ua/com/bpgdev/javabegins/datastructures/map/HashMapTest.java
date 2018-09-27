package ua.com.bpgdev.javabegins.datastructures.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    private HashMap hashMap;
    private HashMap hashMapForPutAll;
    private HashMap hashMapWithNulls;

    @Before
    public void before() {
        hashMap = new HashMap();
        hashMapForPutAll = new HashMap();
        hashMapWithNulls = new HashMap();

        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        hashMap.put(4, "D");
        hashMap.put(5, "E");
        hashMap.put(6, "F");
        hashMap.put(7, "G");

        hashMapForPutAll.put(1,"X");
        hashMapForPutAll.put(2,"Y");
        hashMapForPutAll.put(8,"Z");
        hashMapForPutAll.put(9,"XX");
        hashMapForPutAll.put(10,"YY");
        hashMapForPutAll.put(101,"YY");
        hashMapForPutAll.put(102,"YY");

        for (int index = 0; index < 10; index++) {
            hashMapWithNulls.put(null, index);
        }
    }

    @Test
    public void put() {
        assertEquals(7, hashMap.size());

        assertEquals("A", hashMap.put(1, "Z"));
        assertEquals("B", hashMap.put(2, "Y"));
        assertEquals("C", hashMap.put(3, "X"));

        assertEquals(7, hashMap.size());

        assertEquals(1, hashMapWithNulls.size());
        assertEquals(9, hashMapWithNulls.get(null));
    }

    @Test
    public void putIfAbsent() {
        assertEquals("X", hashMap.putIfAbsent(10, "X"));
        assertEquals("Y", hashMap.putIfAbsent(11, "Y"));
        assertEquals("Z", hashMap.putIfAbsent(12, "Z"));

        assertEquals(10, hashMap.size());

        assertNull(hashMap.putIfAbsent(1, "A"));
        assertNull(hashMap.putIfAbsent(2, "B"));
        assertNull(hashMap.putIfAbsent(3, "C"));

        assertEquals(10, hashMap.size());
    }


    @Test
    public void putAll() {
        hashMap.putAll(hashMapForPutAll);
        assertEquals(12, hashMap.size());
    }

    @Test
    public void get() {

        assertEquals("A", hashMap.get(1));
        assertEquals("B", hashMap.get(2));
        assertEquals("C", hashMap.get(3));
        assertEquals("D", hashMap.get(4));
        assertEquals("G", hashMap.get(7));

        assertNull(hashMap.get(100));
        assertNull(hashMap.get(50));

    }

    @Test
    public void remove() {
        assertEquals("A", hashMap.remove(1));
        assertEquals("B", hashMap.remove(2));
        assertEquals("C", hashMap.remove(3));
        assertEquals("G", hashMap.remove(7));
        assertEquals(3, hashMap.size());
        assertNull(hashMap.remove("X"));
        assertNull(hashMap.remove("Y"));
        assertNull(hashMap.remove(null));
    }

    @Test
    public void keys() {
        for (int index = 1; index < hashMap.size(); index++) {
            assertTrue(hashMap.keys().contains(index));
        }

        assertFalse(hashMap.keys().contains(0));
        assertFalse(hashMap.keys().contains(-101));
        assertFalse(hashMap.keys().contains(15));
        assertFalse(hashMap.keys().contains(null));
    }

    @Test
    public void values() {
        assertTrue(hashMap.values().contains("A"));
        assertTrue(hashMap.values().contains("B"));
        assertTrue(hashMap.values().contains("F"));

        assertFalse(hashMap.values().contains("X"));
        assertFalse(hashMap.values().contains("Y"));
        assertFalse(hashMap.values().contains(null));

        assertEquals(7,hashMap.values().size() );
    }

    @Test
    public void containsKey() {
        assertTrue(hashMap.containsKey(1));
        assertTrue(hashMap.containsKey(2));
        assertTrue(hashMap.containsKey(3));
        assertTrue(hashMap.containsKey(7));
        assertFalse(hashMap.containsKey(null));
        assertFalse(hashMap.containsKey(-101));
        assertFalse(hashMap.containsKey(15));
    }

    @Test
    public void size() {
        assertEquals(7, hashMap.size());
        hashMap.put(101,"X");
        hashMap.put(102,"X");
        hashMap.put(103,"X");
        assertEquals(10, hashMap.size());

        int size = hashMap.size();
        for (int index = 1; index < size; index++) {
            hashMap.remove(index);
        }
        assertEquals(3,hashMap.size());
    }
}