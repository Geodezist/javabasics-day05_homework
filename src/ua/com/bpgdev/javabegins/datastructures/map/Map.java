package ua.com.bpgdev.javabegins.datastructures.map;

import java.util.List;

public interface Map {
    Object put(Object key, Object value);

    Object putIfAbsent(Object key, Object value);

    void putAll(HashMap map);

    Object get(Object key);

    Object remove(Object key);

    List keys();

    List values();

    boolean containsKey(Object key);

    int size();

}
