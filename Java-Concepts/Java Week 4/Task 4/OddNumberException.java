public class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}

class OddNumberCheck {
    public static void main(String[] args) {
        try {
            checkEvenNumber(3);
        } catch (OddNumberException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void checkEvenNumber(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("Number is odd");
        }
    }
}
