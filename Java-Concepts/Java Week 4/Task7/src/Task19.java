// Write a Java program to insert some elements at the specified position into a linked list.

import java.util.LinkedList;

public class Task19 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.List.of("A", "B", "D"));
        list.add(2, "C");
        System.out.println(list);
    }
}
