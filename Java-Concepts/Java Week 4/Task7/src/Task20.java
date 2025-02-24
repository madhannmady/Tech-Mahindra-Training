// Write a Java program to get the first and last occurrence of the specified elements in a linked list.

import java.util.LinkedList;

public class Task20 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.List.of("A", "B", "C", "A"));
        System.out.println("First occurrence of A: " + list.indexOf("A"));
        System.out.println("Last occurrence of A: " + list.lastIndexOf("A"));
    }
}
