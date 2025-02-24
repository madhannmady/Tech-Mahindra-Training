
/**
 * Task 4: Create a menu-driven program with options:
 * 1. Insert a new Row
 * 2. Update a Row
 * 3. Delete a Row
 * 4. Select a Row
 * 5. Exit
 * Use PreparedStatement for all operations.
 */

import java.sql.*;
import java.util.Scanner;

public class Task4 {
    private static final String INSERT_QUERY = "INSERT INTO Employees (name, age, department) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Employees SET name=?, age=?, department=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM Employees WHERE id=?";
    private static final String SELECT_QUERY = "SELECT * FROM Employees WHERE id=?";

    public static void insertRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            System.out.println("Row inserted successfully!");
        }
    }

    public static void updateRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

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
            System.out.println(rowsUpdated > 0 ? "Update successful!" : "No record found.");
        }
    }

    public static void deleteRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        try (PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Record deleted successfully!" : "No record found.");
        }
    }

    public static void selectRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to view: ");
        int id = scanner.nextInt();

        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_QUERY)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Department: " + rs.getString("department"));
            } else {
                System.out.println("No record found.");
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root",
                "madhan@13");
                Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n1. Insert Row\n2. Update Row\n3. Delete Row\n4. Select Row\n5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> insertRow(conn, scanner);
                    case 2 -> updateRow(conn, scanner);
                    case 3 -> deleteRow(conn, scanner);
                    case 4 -> selectRow(conn, scanner);
                    case 5 -> System.exit(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
