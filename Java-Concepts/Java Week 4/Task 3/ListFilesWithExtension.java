import java.io.File;
import java.io.FilenameFilter;

public class ListFilesWithExtension {
    public static void main(String[] args) {
        File directory = new File("D://scanned documents");
        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");

        String[] fileList = directory.list(filter);
        
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }
}
