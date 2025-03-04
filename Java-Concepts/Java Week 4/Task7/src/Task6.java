// Write a Java program to remove the third element from an array list.

import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(java.util.List.of("Red", "Blue", "Green", "Yellow"));
        colors.remove(2);
        System.out.println(colors);
    }
}
