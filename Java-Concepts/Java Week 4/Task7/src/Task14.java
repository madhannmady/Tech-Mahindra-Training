// Write a Java program to iterate a linked list in reverse order.

import java.util.LinkedList;
import java.util.Collections;

public class Task14 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.List.of("Apple", "Banana", "Cherry"));
        Collections.reverse(list);
        for (String item : list) {
            System.out.println(item);
        }
    }
}
