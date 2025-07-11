import java.sql.*;
import java.util.Scanner;

public class crud {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; 
        String user = "root";  
        String pass = "root";      

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Scanner sc = new Scanner(System.in)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to database!");

            while (true) {
                System.out.println("\n1. Add Student\n2. View Students\n3. Update Student Email\n4. Delete Student\n5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        String insertSQL = "INSERT INTO student(name, email) VALUES (?, ?)";
                        try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                            ps.setString(1, name);
                            ps.setString(2, email);
                            ps.executeUpdate();
                            System.out.println("Student added successfully!");
                        }
                        break;

                    case 2:
                        String selectSQL = "SELECT * FROM student";
                        try (Statement stmt = conn.createStatement();
                             ResultSet rs = stmt.executeQuery(selectSQL)) {
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("id") +
                                        ", Name: " + rs.getString("name") +
                                        ", Email: " + rs.getString("email"));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID to Update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();
                        String updateSQL = "UPDATE student SET email=? WHERE id=?";
                        try (PreparedStatement ps = conn.prepareStatement(updateSQL)) {
                            ps.setString(1, newEmail);
                            ps.setInt(2, uid);
                            int rows = ps.executeUpdate();
                            if (rows > 0) System.out.println("Updated successfully!");
                            else System.out.println("ID not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Student ID to Delete: ");
                        int did = sc.nextInt();
                        String deleteSQL = "DELETE FROM student WHERE id=?";
                        try (PreparedStatement ps = conn.prepareStatement(deleteSQL)) {
                            ps.setInt(1, did);
                            int rows = ps.executeUpdate();
                            if (rows > 0) System.out.println("Deleted successfully!");
                            else System.out.println("ID not found!");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
