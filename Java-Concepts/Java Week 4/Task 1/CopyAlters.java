public class CopyAlters {
    public static void main(String[] args) {
        int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] alternateArray = new int[(originalArray.length + 1) / 2];

        for (int i = 0, j = 0; i < originalArray.length; i += 2, j++) {
            alternateArray[j] = originalArray[i];
        }

        for (int num : alternateArray) {
            System.out.print(num + " ");
        }
    }
}
