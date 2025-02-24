import java.io.File;

public class FileExists {
    public static void main(String[] args) {
        File file = new File("D://scanned documents//Demo.txt");
        
        if (file.exists()) {
            System.out.println("File or directory exists.");
        } else {
            System.out.println("File or directory does not exist.");
        }
    }
}
