package ua.com.bpgdev.javabegins.datastructures;

import ua.com.bpgdev.javabegins.datastructures.quene.implementations.LinkedQueue;
import ua.com.bpgdev.javabegins.datastructures.quene.interfaces.Queue;

public class Application {
    public static void main(String[] args) {
        Queue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        linkedQueue.enqueue("E");
        System.out.println(linkedQueue.toString());


        linkedQueue.remove("C");
        System.out.println(linkedQueue.toString());

        linkedQueue.remove("E");
        System.out.println(linkedQueue.toString());

        linkedQueue.remove("A");
        System.out.println(linkedQueue.toString());

        linkedQueue.remove("X");
        System.out.println(linkedQueue.toString());
    }
}
