package ua.com.bpgdev.javabegins.datastructures.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack implements Stack {

    private Object[] array;
    private int size;
    private final int INITIAL_CAPACITY = 5;

    public ArrayStack() {
        array = new Object[INITIAL_CAPACITY];
    }

    public ArrayStack(int customInitialCapacity) {
        array = new Object[customInitialCapacity];
    }

    @Override
    public void push(Object value) {
        validateNullValue(value);
        if (size == array.length) {
            Object[] newArray = new Object[(int) (size * 1.5 + 1)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }


    @Override
    public Object pop() {
        validateSize();
        Object result = array[size - 1];
        array[size - 1] = null;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        validateSize();
        return array[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object value) {
        validateNullValue(value);
        for (int index = 0; index < size; index++) {
            if (array[index].equals(value)) {
                System.arraycopy(array, index + 1, array, index, size - index - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Object value) {
        validateNullValue(value);
        boolean result = false;
        int index = 0;
        while (index < size) {
            if (array[index].equals(value)) {
                System.arraycopy(array, index + 1, array, index, size - index - 1);
                array[size - 1] = null;
                size--;
                index--;
                result = true;
            }
            index++;
        }
        return result;
    }

    @Override
    public boolean contains(Object value) {
        validateNullValue(value);
        for (int index = 0; index < size; index++) {
            if (array[index].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    private void validateSize() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private void validateNullValue(Object value) {
        if (value == null){
            throw new IllegalArgumentException("Value can't be null.");
        }
    }

}
