package ua.com.bpgdev.javabegins.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class LinkedList extends AbstractList {
    private Node tail;
    private Node head;

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
        return getNode(index).getValue();
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
        Node node = getNode(index);
        Object result = node.getValue();
        node.setValue(value);

        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object value) {
        Node currentNode = head;
        for (int index = 0; index < size; index++) {
            if (isEqualWithNulls(value, currentNode.getValue())) {
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
            if (isEqualWithNulls(value, currentNode.getValue())) {
                return index;
            }
            currentNode = currentNode.getPrev();
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private Node getNode(int index) {
        Node node;
        if (index <= (size / 2)) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = tail;
            for (int i = size; i > index + 1; i--) {
                node = node.getPrev();
            }
        }
        return node;
    }

    public Node getTail() {
        return tail;
    }


    public Node getHead() {
        return head;
    }


    private static class Node {
        private Object value;
        private Node prev;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator{
        Node node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Object next() {
            Object value = node.getValue();
            node = node.getNext();
            return value;
        }
    }

}
