
/**
 * Task 2: Update the row of a table dynamically using Scanner class.
 */

import java.sql.*;
import java.util.Scanner;

public class Task2 {
    private static final String UPDATE_QUERY = "UPDATE Employees SET name=?, age=?, department=? WHERE id=?";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root",
                "madhan@13");
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new department: ");
            String department = scanner.nextLine();

            try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, department);
                pstmt.setInt(4, id);
                int rowsUpdated = pstmt.executeUpdate();
                System.out.println(rowsUpdated > 0 ? "Update successful!" : "No record found with given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
