package ua.com.bpgdev.javabegins.datastructures;

import ua.com.bpgdev.javabegins.datastructures.list.LinkedList;

public class Application {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");


        System.out.println(linkedList.toString());

    }
}
