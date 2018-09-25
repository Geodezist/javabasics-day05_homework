package ua.com.bpgdev.javabegins.datastructures.list;

public interface List extends Iterable {
    // add value to the end of the list
    // +++
    void add(Object value);

    // we can add value by index between [0, size]
    // otherwise throw new IndexOutOfBoundsException
    // [A, B, C] . add("D", [0, 1, 2, 3])
    // +++ ArrayList
    // +++ LinkedList
    void add(Object value, int index);

    // we can remove value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    // [A, B, C] remove = 0
    // [B (index = 0) , C (index = 1)]
    // +++ ArrayList
    // +++ LinkedList
    Object remove(int index);

    // [A, B, C] size = 3
    // we can get value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    // +++ ArrayList
    // +++ LinkedList
    Object get(int index);

    // we can set value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    // +++ ArrayList
    // +++ LinkedList
    Object set(Object value, int index);

    // +++ ArrayList
    // +++ LinkedList
    void clear();

    // +++ ArrayList
    // +++ LinkedList
    int size();

    // +++ ArrayList
    // +++ LinkedList
    boolean isEmpty();

    // +++ ArrayList
    // +++ LinkedList
    boolean contains(Object value);

    // +++ ArrayList
    // +++ LinkedList
    int indexOf(Object value);

    // +++ ArrayList
    // --- LinkedList
    int lastIndexOf(Object value);

    // [A, B, C]
    // +++ ArrayList
    // --- LinkedList
    String toString();
}
