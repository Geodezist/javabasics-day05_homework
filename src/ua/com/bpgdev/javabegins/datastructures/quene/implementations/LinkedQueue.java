package ua.com.bpgdev.javabegins.datastructures.quene.implementations;

import ua.com.bpgdev.javabegins.datastructures.quene.interfaces.Queue;

public class LinkedQueue implements Queue {
    private int size;
    private Node head;
    private Node last;


    @Override
    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (size == 0){
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
        validateQueue();
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
        Node currentNode = head;
        for (int index = 0; index < size; index++) {
            if (currentNode.value.equals(value)){

                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        Node currentNode = head;
        for (int index = 0; index < size; index++) {
            if (currentNode.value.equals(value)){
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

    public void validateQueue(){
        if (size == 0){
            throw new NullPointerException("Size of Queue = " + Integer.toString(size) + ". Maybe the Queue is empty.");
        }
    }

}
