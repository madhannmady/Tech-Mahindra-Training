// Given a table with rows and columns. Perform CRUD operatios on it using JDBC API

import java.sql.*;
import java.util.Scanner;

public class Task1 {
    private static final String INSERT_QUERY = "INSERT INTO Students (name, age, grade) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Students SET name=?, age=?, grade=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM Students WHERE id=?";
    private static final String SELECT_QUERY = "SELECT * FROM Students";

    public static void insertStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully!");
        }
    }

    public static void updateStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new grade: ");
        String grade = scanner.nextLine();

        try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.setInt(4, id);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Update successful!" : "No record found.");
        }
    }

    public static void deleteStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        try (PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Record deleted successfully!" : "No record found.");
        }
    }

    public static void selectStudents(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SELECT_QUERY)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Grade: " + rs.getString("grade"));
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SchoolDB", "root",
                "madhan@13");
                Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println(
                        "\n1. Insert Student\n2. Update Student\n3. Delete Student\n4. View Students\n5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> insertStudent(conn, scanner);
                    case 2 -> updateStudent(conn, scanner);
                    case 3 -> deleteStudent(conn, scanner);
                    case 4 -> selectStudents(conn);
                    case 5 -> System.exit(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
