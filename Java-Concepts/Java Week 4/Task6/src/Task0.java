// Check if Two Arrays Have the Same Elements in the Same Order

import java.util.Arrays;

public class Task0 {
    public static <T> boolean areArraysEqual(T[] array1, T[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {1, 2, 3, 4};
        Integer[] arr3 = {1, 2, 3, 5};

        System.out.println("Arrays equal: " + areArraysEqual(arr1, arr2)); // true
        System.out.println("Arrays equal: " + areArraysEqual(arr1, arr3)); // false
    }
}
