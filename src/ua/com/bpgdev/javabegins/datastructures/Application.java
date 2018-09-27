package ua.com.bpgdev.javabegins.datastructures;

import ua.com.bpgdev.javabegins.datastructures.list.ArrayList;
import ua.com.bpgdev.javabegins.datastructures.list.LinkedList;
import ua.com.bpgdev.javabegins.datastructures.map.HashMap;

public class Application {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add("sdlkfjsldf");
        linkedList.add("asdas");
        linkedList.add("weqwe2");
        linkedList.add("1312312");
        linkedList.add("sdflgkdl;");
        System.out.println(linkedList.toString());

        ArrayList arrayList = new ArrayList();
        arrayList.add("sdfsd");
        arrayList.add("SDFSDF");
        arrayList.add("SDFSDFWER");
        arrayList.add("EEEE");
        arrayList.add("HLFG");
        System.out.println(arrayList.toString());

    }
}
