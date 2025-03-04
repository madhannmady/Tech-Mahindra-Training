// Write a Java program to insert the specified element at the specified position in the linked list.

import java.util.LinkedList;

public class Task15 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.List.of("Apple", "Banana"));
        list.add(1, "Cherry");
        System.out.println(list);
    }
}
