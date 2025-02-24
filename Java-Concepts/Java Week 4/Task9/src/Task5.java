/**
 * Task 5: Write a Java program to count the number of strings in a list that start with a specific letter using streams.
 */

import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "apricot", "banana", "avocado", "cherry", "blueberry");

        char targetLetter = 'a';

        long count = words.stream()
                .filter(word -> word.startsWith(String.valueOf(targetLetter)))
                .count();

        System.out.println("Count of words starting with '" + targetLetter + "': " + count);
    }
}
