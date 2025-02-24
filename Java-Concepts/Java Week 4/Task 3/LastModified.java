import java.io.File;
import java.text.SimpleDateFormat;

public class LastModified {
    public static void main(String[] args) {
        File file = new File("D://scanned documents//Demo.txt");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        System.out.println("Last modified date: " + sdf.format(file.lastModified()));
    }
}
