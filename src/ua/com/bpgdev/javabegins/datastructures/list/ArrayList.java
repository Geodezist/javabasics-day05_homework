package ua.com.bpgdev.javabegins.datastructures.list;

import java.util.Iterator;
import java.util.stream.IntStream;

// TDD
// Ctrl + Shift + T
public class ArrayList extends AbstractList {
    private final int INITIAL_CAPACITY = 5;
    private final int currentCapacity;
    private Object[] array;

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
        extendArray();
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        validateIndexForAdd(index);
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
    public boolean contains(Object value) {
        for (Object o : array) {
            if (value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return IntStream.range(0, size).filter(index -> isEqualWithNulls(value, array[index])).findFirst().orElse(-1);
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int index = size - 1; index >= 0; index--) {
            if (isEqualWithNulls(value, array[index])){
                return index;
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

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            return array[index++];
        }
    }
}
