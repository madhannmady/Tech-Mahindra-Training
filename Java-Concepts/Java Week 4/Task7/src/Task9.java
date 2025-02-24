// Write a Java program to copy one array list into another.

import java.util.ArrayList;
import java.util.Collections;

public class Task9 {
    public static void main(String[] args) {
        ArrayList<String> original = new ArrayList<>(java.util.List.of("Red", "Blue", "Green"));
        ArrayList<String> copy = new ArrayList<>(original);
        System.out.println(copy);
    }
}
