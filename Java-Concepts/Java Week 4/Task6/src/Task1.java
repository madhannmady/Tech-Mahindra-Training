// Write a Java program to create a generic method that takes a list of numbers and returns the sum of all the even and odd numbers

import java.util.List;

public class Task1 {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        double evenSum = 0, oddSum = 0;
        for (T num : numbers) {
            if (num.intValue() % 2 == 0) {
                evenSum += num.doubleValue();
            } else {
                oddSum += num.doubleValue();
            }
        }
        System.out.println("Sum of Even Numbers: " + evenSum);
        System.out.println("Sum of Odd Numbers: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7);
        sumEvenOdd(numList);
    }
}
