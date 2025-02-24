/**
 * Task 2: Write a Java program to convert a list of strings to uppercase or lowercase using streams.
 */

import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");

        List<String> uppercaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> lowercaseWords = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println("Uppercase: " + uppercaseWords);
        System.out.println("Lowercase: " + lowercaseWords);
    }
}
