import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDelete {
    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/emp";
            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, userName, password);

            Statement smt = con.createStatement();
            String sql = "DELETE FROM emp_info where age=23";

            int i = smt.executeUpdate(sql);
            if (i > 0) {
                System.out.println("data deleted sucessfully");
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