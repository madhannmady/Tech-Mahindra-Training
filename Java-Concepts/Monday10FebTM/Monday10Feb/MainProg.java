package Monday10Feb;

public class MainProg {
    public static void main(String[] args) {
        PrintMsg msg = new PrintMsg();
        msg.printMessage();
        msg.printMessage();

        PrintlnMsg msg2 = new PrintlnMsg();
        msg2.printlnMessage();
        msg2.printlnMessage();
        msg2.printlnMessage();

        ErrorMsg msg3 = new ErrorMsg();
        msg3.errorMessage();
        msg3.errorMessage();
        msg3.errorMessage();
    }
}
