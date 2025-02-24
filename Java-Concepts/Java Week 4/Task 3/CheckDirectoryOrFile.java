import java.io.File;

public class CheckDirectoryOrFile {
    public static void main(String[] args) {
        File file = new File("D://scanned documents//Demo.txt");
        
        if (file.isDirectory()) {
            System.out.println("It is a directory.");
        } else if (file.isFile()) {
            System.out.println("It is a file.");
        }
    }
}
