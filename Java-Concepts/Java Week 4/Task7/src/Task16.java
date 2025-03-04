// Write a Java program to insert elements into the linked list at the first and last positions.

import java.util.LinkedList;

public class Task16 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("First");
        list.addLast("Last");
        System.out.println(list);
    }
}
