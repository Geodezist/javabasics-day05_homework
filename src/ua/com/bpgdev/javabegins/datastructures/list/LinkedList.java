package ua.com.bpgdev.javabegins.datastructures.list;

import java.util.stream.IntStream;

public class LinkedList implements List {
    private Node tail;
    private Node head;
    private int size;


    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        validateIndexForAdd(index);
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            if (index == 0) {
                head.setPrev(newNode);
                newNode.setNext(head);
                head = newNode;
            } else {
                Node currentNode = head;
                for (int i = 1; i < index; i++) {
                    currentNode = currentNode.getNext();
                }
                if (index == size) {
                    tail = newNode;
                } else {
                    currentNode.getNext().setPrev(newNode);
                }
                newNode.setPrev(currentNode);
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Node result = head;
        for (int i = 0; i < index; i++) {
            result = result.getNext();
        }
        if (result.getPrev() == null) {
            result.getNext().setPrev(null);
            head = result.getNext();
        } else if (result.getNext() == null) {
            result.getPrev().setNext(null);
            tail = result.getPrev();
        } else {
            result.getPrev().setNext(result.getNext());
            result.getNext().setPrev(result.getPrev());
        }
        size--;

        return result.getValue();
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        Node result = head;
        for (int i = 0; i < index; i++) {
            result = result.getNext();
        }
        return result.getValue();
    }

    public Object getUsingStream(int index) {
        validateIndex(index);
        Node[] result = new Node[1];
        result[0] = head;
        IntStream.range(0, index).forEach(i -> result[0] = result[0].getNext());

        return result[0].getValue();
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Node currentNode = head;
        Object result;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        result = currentNode.getValue();
        currentNode.setValue(value);

        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
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
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        Node currentNode = head;
        for (int index = 0; index < size; index++) {
            if (value == null && currentNode.getValue() == null) {
                return index;
            } else if (value.equals(currentNode.getValue())) {
                return index;
            }
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node currentNode = tail;
        for (int index = size - 1; index >= 0; index--) {
            if (value == null) {
                if (currentNode.getValue() == null) {
                    return index;
                }
            } else if (value.equals(currentNode.getValue())) {
                return index;
            }
            currentNode = currentNode.getPrev();
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        Node currentNode = head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; ; i++) {
            stringBuilder.append(currentNode.getValue().toString());
            if (i == size - 1) {
                return stringBuilder.append(']').toString();
            }
            stringBuilder.append(", ");
            currentNode = currentNode.getNext();
        }
    }

    public Node getTail() {
        return tail;
    }


    public Node getHead() {
        return head;
    }


    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Valid index values for add() methods are between 0 and " + size +
                    " inclusive. Current index value = " + index);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Valid index values are between 0 and " + (size - 1) +
                    " inclusive. Current index value = " + index);
        }
    }
}
