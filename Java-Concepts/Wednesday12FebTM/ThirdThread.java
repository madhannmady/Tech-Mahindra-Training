public class ThirdThread {
    public static void main(String[] args) {
        ThreadTwo t1 = new ThreadTwo();
        ThreadTwo t2 = new ThreadTwo();

        t1.start();
        t2.start();
        t1.run();
    }
}

class ThreadTwo extends Thread {
    public void run() {
        System.out.println("ThreadTwo!");
        System.out.println("ThreadTwo!");
        System.out.println(10 / 0);
    }
}
