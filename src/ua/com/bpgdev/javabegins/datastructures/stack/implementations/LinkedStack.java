package ua.com.bpgdev.javabegins.datastructures.stack.implementations;

import ua.com.bpgdev.javabegins.datastructures.stack.interfaces.Stack;

public class LinkedStack implements Stack {
    private int size;
    private Node tail;

    @Override
    public void push(Object value) {
        Node newNode = new Node(value);
        if (size != 0) {
            newNode.prevNode = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public Object pop() {
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
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }
}
