// Write a Java program to sort a given array list.

import java.util.ArrayList;
import java.util.Collections;

public class Task8 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(java.util.List.of("Yellow", "Blue", "Green", "Red"));
        Collections.sort(colors);
        System.out.println(colors);
    }
}

