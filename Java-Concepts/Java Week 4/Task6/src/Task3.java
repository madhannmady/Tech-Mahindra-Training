// Write a Java program to create a generic method that takes a list of any type and returns it as a new list with the elements in reverse order

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("Reversed List: " + reverseList(numbers));
    }
}
