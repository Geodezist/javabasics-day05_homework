package ua.com.bpgdev.javabegins.datastructures.quene;

import java.util.NoSuchElementException;

public class LinkedQueue implements Queue {
    private int size;
    private Node head;
    private Node last;


    @Override
    public void enqueue(Object value) {
        validateNullValue(value);
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            last = newNode;
        } else {
            last.nextNode = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        validateSize();
        Node result = head;
        head = head.nextNode;
        if (size != 1) {
            result.nextNode = null;
        }
        size--;
        return result.value;
    }

    @Override
    public Object peek() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object value) {
        validateNullValue(value);
        Node prevNode = null;
        Node currentNode = head;
        for (int index = 0; index < size; index++) {
            if (currentNode.value.equals(value)) {
                if (prevNode != null) {
                    prevNode.nextNode = currentNode.nextNode;
                } else {
                    head = head.nextNode;
                }
                size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        validateNullValue(value);
        Node currentNode = head;
        for (int index = 0; index < size; index++) {
            if (currentNode.value.equals(value)) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    @Override
    public Object max() {
        return null;
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

    @Override
    public String toString() {
        String result = "";
        Node currentNode = this.head;
        for (int index = 0; index < size; index++) {
            result += currentNode.value.toString() + "; ";
            currentNode = currentNode.nextNode;
        }
        return "LinkedQueue{" +
                "size=" + size +
                "contains=" + result +
                '}';
    }
}
