// Write a Java program to shufle elements in an array list.

import java.util.ArrayList;
import java.util.Collections;

public class Task10 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(java.util.List.of("Red", "Blue", "Green", "Yellow"));
        Collections.shuffle(colors);
        System.out.println(colors);
    }
}
