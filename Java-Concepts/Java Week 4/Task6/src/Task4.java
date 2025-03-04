// Write a Java program to create a generic method that takes two lists of the same type and merges them into a single list. This method alternates the elements of each list

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static <T> List<T> mergeAlternately(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int size1 = list1.size(), size2 = list2.size();
        int i = 0;

        while (i < size1 || i < size2) {
            if (i < size1) mergedList.add(list1.get(i));
            if (i < size2) mergedList.add(list2.get(i));
            i++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<String> listA = List.of("A", "B", "C");
        List<String> listB = List.of("1", "2", "3", "4");

        System.out.println("Merged List: " + mergeAlternately(listA, listB));
    }
}
