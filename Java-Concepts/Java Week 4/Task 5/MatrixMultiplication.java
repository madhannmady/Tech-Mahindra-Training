public class MatrixMultiplication {
    static int[][] matrix1 = {{1, 2}, {3, 4}};
    static int[][] matrix2 = {{5, 6}, {7, 8}};
    static int[][] result = new int[2][2];

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            result[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
            result[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
        });

        Thread t2 = new Thread(() -> {
            result[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
            result[1][1] = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
