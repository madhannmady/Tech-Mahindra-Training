import java.util.Arrays;

public class MultiThreadedSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 2, 7};
        Arrays.sort(array);

        Thread sortThread = new Thread(() -> Arrays.sort(array));
        sortThread.start();

        try {
            sortThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(array));
    }
}
