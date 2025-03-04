import java.util.*;
import java.lang.Thread;

public class MultiThreads {
    public static void main(String[] args) {// Thread 1
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
        MadhanThread t1 = new MadhanThread();
        t1.start();// calls run method-Thread 2
        // t1.run();
        MadhanThread2 t2 = new MadhanThread2();
        Thread tt2 = new Thread(t2);
        new Thread(t2).start();// Thread 3
        tt2.start();// Thread 4
        t2.run();

        System.out.println(10 / 0);
    }
}

class MadhanThread extends Thread {
    public void run() {
        System.out.println("From Thread1!" + this.getName());
        // System.out.println(10/0);
    }
}

class MadhanThread2 implements Runnable {
    public void run() {
        // System.out.println("From MadhanThread2!");
        System.out.println(10 / 0);
    }
}