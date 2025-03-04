// Write a Java program to append the specified element to the end of a linked list.

import java.util.LinkedList;

public class Task11 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.addLast("Banana");
        System.out.println(list);
    }
}
