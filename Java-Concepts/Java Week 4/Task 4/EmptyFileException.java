import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

class EmptyFileCheck {
    public static void main(String[] args) {
        try {
            checkEmptyFile("D://scanned documents//empty.txt");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void checkEmptyFile(String fileName) throws FileNotFoundException, EmptyFileException {
        Scanner scanner = new Scanner(new File(fileName));
        if (!scanner.hasNext()) {
            throw new EmptyFileException("File is empty");
        }
    }
}
