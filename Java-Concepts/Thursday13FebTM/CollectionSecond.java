import java.util.*;

class ArrayListThread extends Thread {
    public void run() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        System.out.println("ArrayList: " + arrayList);
        arrayList.remove(2);
        System.out.println("ArrayList after removal: " + arrayList);
    }
}

class LinkedListThread extends Thread {
    public void run() {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(50);
        linkedList.add(60);
        linkedList.add(70);
        linkedList.add(80);
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove(1);
        System.out.println("LinkedList after removal: " + linkedList);
    }
}

class StackThread extends Thread {
    public void run() {
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        System.out.println("Stack: " + stack);
        stack.pop();
        System.out.println("Stack after pop: " + stack);
    }
}

class VectorThread extends Thread {
    public void run() {
        Vector<Integer> vector = new Vector<>();
        vector.add(500);
        vector.add(600);
        vector.add(700);
        vector.add(800);
        System.out.println("Vector: " + vector);
        vector.remove(2);
        System.out.println("Vector after removal: " + vector);
    }
}

public class CollectionSecond {
    public static void main(String[] args) {
        ArrayListThread thread1 = new ArrayListThread();
        LinkedListThread thread2 = new LinkedListThread();
        StackThread thread3 = new StackThread();
        VectorThread thread4 = new VectorThread();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}