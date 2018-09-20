package ua.com.bpgdev.javabegins.datastructures.list;

import java.util.stream.IntStream;

// TDD
// Ctrl + Shift + T
public class ArrayList implements List {
    private final int INITIAL_CAPACITY = 5;
    private final int currentCapacity;
    private Object[] array;
    private int size;

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
        validateNullValue(value);
        for (Object o : array) {
            if (value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        validateNullValue(value);
        return IntStream.range(0, size).filter(index -> value.equals(array[index])).findFirst().orElse(-1);
    }

    @Override
    public int lastIndexOf(Object value) {
        validateNullValue(value);
        for (int index = size - 1, lastIndex = 0; index >= 0; index--, lastIndex++) {
            if (value.equals(array[index])) {
                return lastIndex;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(array[i]));
            if (i == size - 1)
                return b.append(']').toString();
            b.append(", ");
        }
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
