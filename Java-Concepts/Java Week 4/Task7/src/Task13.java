// Write a Java program to iterate through all elements in a linked list starting at the specified position.

import java.util.LinkedList;

public class Task13 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.List.of("Apple", "Banana", "Cherry", "Date"));
        list.listIterator(2).forEachRemaining(System.out::println);
    }
}
