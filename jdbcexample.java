import java.sql.*;

public class jdbcexample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; 
        String user = "root"; 
        String password = "root"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
