import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

class PositiveNumberCheck {
    public static void main(String[] args) {
        try {
            checkPositiveNumber("D://scanned documents//numbers.txt");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void checkPositiveNumber(String fileName) throws FileNotFoundException, PositiveNumberException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number > 0) {
                throw new PositiveNumberException("Found a positive number: " + number);
            }
        }
    }
}
