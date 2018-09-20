package ua.com.bpgdev.javabegins.datastructures.stack;

import java.util.NoSuchElementException;

public class LinkedStack implements Stack {
    private int size;
    private Node tail;

    @Override
    public void push(Object value) {
        validateNullValue(value);
        Node newNode = new Node(value);
        if (size != 0) {
            newNode.prevNode = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public Object pop() {
        validateSize();
        Object result = tail.value;
        tail = tail.prevNode;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        return tail.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object value) {
        validateNullValue(value);
        Node prevNode = null;
        Node currentNode = tail;
        for (int index = 0; index < size; index++) {
            if ( currentNode.value.equals(value)) {
                if (prevNode != null) {
                    prevNode.prevNode = currentNode.prevNode;
                } else {
                    tail = currentNode.prevNode;
                }
                size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.prevNode;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        validateNullValue(value);
        Node currentNode = tail;
        for (int index = 0; index < size; index++) {
            if (currentNode.value.equals(value)) {
                return true;
            }
            currentNode = currentNode.prevNode;
        }
        return false;
    }

    private void validateSize() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private void validateNullValue(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Value can't be null.");
        }
    }
}
