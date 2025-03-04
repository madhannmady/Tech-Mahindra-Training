/**
 * Task 1: Write a Java program to calculate the average of a list of integers using streams.
 */

import java.util.List;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);

        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Average: " + (average.isPresent() ? average.getAsDouble() : "No elements"));
    }
}
