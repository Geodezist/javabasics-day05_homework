package ua.com.bpgdev.javabegins.datastructures.list.implementations;

import ua.com.bpgdev.javabegins.datastructures.list.interfaces.List;

// TDD
// Ctrl + Shift + T
public class ArrayList implements List {
    private final int INITIAL_CAPACITY = 5;
    private final int currentCapacity;
    Object[] array;
    int size;

    public ArrayList() {
        validateInitialCapacity(INITIAL_CAPACITY);
        array = new Object[INITIAL_CAPACITY];
        currentCapacity = INITIAL_CAPACITY;
    }

    public ArrayList(int customInitialCapacity) {
        validateInitialCapacity(customInitialCapacity);
        array = new Object[customInitialCapacity];
        currentCapacity = customInitialCapacity;
    }

    @Override
    public void add(Object value) {
        validateNullValue(value);
        extendArray();
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        validateNullValue(value);
        validateIndex(index);
        extendArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Object result = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        size--;
        return result;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        validateNullValue(value);
        validateIndex(index);
        Object result = array[index];
        array[index] = value;
        return result;
    }

    @Override
    public void clear() {
        array = new Object[currentCapacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    private void validateNullValue(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Value can't be null.");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void validateInitialCapacity(int initialCapacity) {
        if (initialCapacity <= 1) {
            throw new IndexOutOfBoundsException("Initial capacity must be > 1");
        }
    }

    private void extendArray() {
        if (array.length == size) {
            Object[] newArray = new Object[(array.length * 3 / 2 + 1)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}
