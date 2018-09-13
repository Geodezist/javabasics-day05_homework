package ua.com.bpgdev.javabegins.datastructures;

import ua.com.bpgdev.javabegins.datastructures.quene.implementations.LinkedQueue;

public class Application {
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();

        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");

        System.out.println(linkedQueue.size());

        System.out.println(linkedQueue.dequeue().toString());
        System.out.println(linkedQueue.dequeue().toString());
        System.out.println(linkedQueue.dequeue().toString());
        System.out.println(linkedQueue.dequeue().toString());

        linkedQueue.enqueue("E");
        linkedQueue.enqueue("F");
        linkedQueue.enqueue("G");
        linkedQueue.enqueue("H");

        System.out.println(linkedQueue.size());

        System.out.println(linkedQueue.contains("T"));
    }
}
