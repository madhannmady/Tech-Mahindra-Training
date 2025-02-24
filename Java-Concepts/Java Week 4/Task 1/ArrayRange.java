import java.util.Arrays;

public class ArrayRange {
    public static void main(String[] args) {
        int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] copiedArray = Arrays.copyOfRange(originalArray, 2, 7);

        for (int num : copiedArray) {
            System.out.print(num + " ");
        }
    }
}
