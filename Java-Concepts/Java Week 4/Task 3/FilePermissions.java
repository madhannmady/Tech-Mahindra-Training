import java.io.File;

public class FilePermissions {
    public static void main(String[] args) {
        File file = new File("D://scanned documents//Demo.txt");
        
        System.out.println("Read permission: " + file.canRead());
        System.out.println("Write permission: " + file.canWrite());
    }
}
