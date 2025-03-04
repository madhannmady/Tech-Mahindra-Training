import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File directory = new File("D://scanned documents");
        String[] fileList = directory.list();
        if (fileList != null) {
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
        }
    }
}
