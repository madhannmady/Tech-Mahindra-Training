
/**
 * Task 1: Recursively insert multiple rows into the table.
 * Hint: Use PreparedStatement
 */

import java.sql.*;
import java.util.Scanner;

public class Task1 {
    private static final String INSERT_QUERY = "INSERT INTO Employees (name, age, department) VALUES (?, ?, ?)";

    public static void insertData(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            System.out.println("Row inserted successfully!");
        }

        System.out.print("Do you want to insert another row? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            insertData(conn, scanner);
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root",
                "madhan@13");
                Scanner scanner = new Scanner(System.in)) {
            insertData(conn, scanner);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
