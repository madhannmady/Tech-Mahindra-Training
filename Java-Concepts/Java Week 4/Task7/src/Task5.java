// Write a Java program to update an array element by the given element.

import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(java.util.List.of("Red", "Blue", "Green"));
        colors.set(1, "Purple");
        System.out.println(colors);
    }
}
