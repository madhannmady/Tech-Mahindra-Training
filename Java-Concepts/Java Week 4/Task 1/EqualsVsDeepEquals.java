import java.util.Arrays;

public class EqualsVsDeepEquals {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};

        System.out.println("Equals: " + Arrays.equals(array1, array2)); // true
        System.out.println("Deep Equals: " + Arrays.deepEquals(new int[][]{array1}, new int[][]{array2})); // true
    }
}
