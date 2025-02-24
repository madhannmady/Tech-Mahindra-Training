import java.io.File;

public class FileSize {
    public static void main(String[] args) {
        File file = new File("D://scanned documents//Demo.txt");
        long bytes = file.length();
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);

        System.out.println("File size in bytes: " + bytes);
        System.out.println("File size in kilobytes: " + kilobytes);
        System.out.println("File size in megabytes: " + megabytes);
    }
}
