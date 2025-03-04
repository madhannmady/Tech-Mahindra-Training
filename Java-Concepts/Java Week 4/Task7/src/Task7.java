// Write a Java program to search for an element in an array list

import java.util.ArrayList;

public class Task7 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(java.util.List.of("Red", "Blue", "Green", "Yellow"));
        System.out.println("Contains Blue? " + colors.contains("Blue"));
    }
}

