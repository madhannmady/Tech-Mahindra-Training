// Write a Java program to retrieve an element (at a specified index) from a given array list

import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(java.util.List.of("Red", "Blue", "Green", "Yellow"));
        System.out.println("Element at index 2: " + colors.get(2));
    }
}

