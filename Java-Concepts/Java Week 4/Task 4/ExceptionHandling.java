public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            throw new Exception("This is an exception");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
