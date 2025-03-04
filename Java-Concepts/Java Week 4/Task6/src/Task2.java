// Write a Java program to create a generic method that takes a list of any type and a target element. It returns the index of the first occurrence of the target element in the list. Return -1 if the target element cannot be found.

import java.util.List;

public class Task2 {
    public static <T> int findFirstIndex(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Bob");
        System.out.println("Index of 'Bob': " + findFirstIndex(names, "Bob")); // 1
        System.out.println("Index of 'David': " + findFirstIndex(names, "David")); // -1
    }
}
