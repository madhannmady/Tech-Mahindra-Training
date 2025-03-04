// Write a Java program to create an array list, add some colors (strings) and print out the collection.

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        System.out.println("Color List: " + colors);
    }
}
