import java.io.File;
import java.io.IOException;

public class Javafile {
    public static void main(String[] args) throws IOException {
        File folder1 = new File("folder1");
        File folder2 = new File("folder2");
        folder1.mkdir();
        folder2.mkdir();
        File file1_1 = new File(folder1, "file1_1.txt");
        File file1_2 = new File(folder1, "file1_2.txt");
        File file1_3 = new File(folder1, "file1_3.txt");
        file1_1.createNewFile();
        file1_2.createNewFile();
        file1_3.createNewFile();
        File file2_1 = new File(folder2, "file2_1.txt");
        File file2_2 = new File(folder2, "file2_2.txt");
        File file2_3 = new File(folder2, "file2_3.txt");
        File file2_4 = new File(folder2, "file2_4.txt");
        file2_1.createNewFile();
        file2_2.createNewFile();
        file2_3.createNewFile();
        file2_4.createNewFile();
    }
}