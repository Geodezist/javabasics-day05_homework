package ua.com.bpgdev.javabegins.datastructures.stack.implementation;

import ua.com.bpgdev.javabegins.datastructures.stack.interfaces.Stack;

import java.util.NoSuchElementException;

public class ArrayStack implements Stack {

    Object[] array;
    int size;
    private final int initialCapacity = 5;

    public ArrayStack() {
        array = new Object[initialCapacity];
    }

    @Override
    public void push(Object value) {
        // TODO: check if array is full, create new, and copy values from old one
        if (size == array.length) {
            Object[] newArray = new Object[size + initialCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            System.out.println(array.length);
        }
        array[size] = value;
        size++;
    }

    @Override
    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Object result = array[size - 1];
        array[size - 1] = null;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object value) {
        boolean result = false;
        for (int index = 0; index < size; index++) {
            if (array[index].equals(value)) {
                array[index] = null;
                System.arraycopy(array, index - 1, array, index + 1, array.length - index - 1);
                size--;
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean contains(Object value) {
        for (int index = 0; index < size; index++) {
            if (array[index].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void printStack() {
        for (int index = 0; index < size(); index++) {
            System.out.println(array[index].toString());
        }

    }


}
