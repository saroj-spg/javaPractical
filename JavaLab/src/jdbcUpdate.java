import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcUpdate {
    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/emp";
            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, userName, password);

            PreparedStatement ps = con.prepareStatement("UPDATE emp_info set name =? where age=?");
            ps.setString(1, "Dinesh Basnet");
            ps.setInt(2, 25);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("data updated sucessfully");
            }
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM emp_info");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {

                System.out.println(+rs.getInt("id") + " " +
                        rs.getString("name") + " " + rs.getString("age") + " " + rs.getString("address"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}