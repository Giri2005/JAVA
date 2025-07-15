import java.sql.*;
import java.util.Scanner;

public class EmployeeManager {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps;
            ResultSet rs;

            while (true) {
                System.out.println("\n--- Employee Management System ---");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Position: ");
                        String position = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        ps = conn.prepareStatement("INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)");
                        ps.setString(1, name);
                        ps.setString(2, position);
                        ps.setDouble(3, salary);
                        ps.executeUpdate();
                        System.out.println("Employee Added!");
                        break;

                    case 2:
                        ps = conn.prepareStatement("SELECT * FROM employee");
                        rs = ps.executeQuery();
                        System.out.println("Employees:");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                               ", Name: " + rs.getString("name") +
                                               ", Position: " + rs.getString("position") +
                                               ", Salary: " + rs.getDouble("salary"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        ps = conn.prepareStatement("UPDATE employee SET salary = ? WHERE id = ?");
                        ps.setDouble(1, newSalary);
                        ps.setInt(2, id);
                        int updated = ps.executeUpdate();
                        if (updated > 0) System.out.println("Salary Updated!");
                        else System.out.println("Employee Not Found.");
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to Delete: ");
                        int delId = sc.nextInt();
                        ps = conn.prepareStatement("DELETE FROM employee WHERE id = ?");
                        ps.setInt(1, delId);
                        int deleted = ps.executeUpdate();
                        if (deleted > 0) System.out.println("Employee Deleted!");
                        else System.out.println("Employee Not Found.");
                        break;

                    case 5:
                        conn.close();
                        sc.close();
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
