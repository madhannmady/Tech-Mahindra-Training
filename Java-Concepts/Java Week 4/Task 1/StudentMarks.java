import java.util.*;

class Student {
    String name;
    int[] marks;
    int total;
    double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = Arrays.stream(marks).sum();
        this.average = total / (double) marks.length;
    }
}

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student name:");
            String name = scanner.next();
            System.out.println("Enter marks for 3 subjects:");
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                marks[j] = scanner.nextInt();
            }
            students.add(new Student(name, marks));
        }

        students.sort(Comparator.comparingDouble(student -> -student.average));

        for (Student student : students) {
            System.out.println(student.name + ": Total = " + student.total + ", Average = " + student.average);
        }
    }
}
