/**
 * Task 4: Write a Java program to remove all duplicate elements from a list using streams.
 */

import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8);

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("List after removing duplicates: " + uniqueNumbers);
    }
}
