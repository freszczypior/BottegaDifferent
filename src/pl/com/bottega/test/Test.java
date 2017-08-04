package pl.com.bottega.test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    //private static LinkedList list = new LinkedList();
    private static ArrayList list = new ArrayList();

    public static void main(String[] args) {


       ArrayList array = new ArrayList();
        array.add("one");
        array.add(null);
        array.add("three");
        array.add("four");
        System.out.println(array.contains("three"));
        array.remove("one");
        array.clear();

        LinkedList linked = new LinkedList();
        System.out.println(linked.size());
        linked.add("one");
        linked.add("two");
        linked.add("three");
        linked.add("four");
        System.out.println(linked.size());
        linked.remove("four");
        System.out.println(linked.size());
        linked.toString();
    }



}
