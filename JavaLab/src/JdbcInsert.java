import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcInsert {
    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/emp";
            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, userName, password);

            PreparedStatement ps = con.prepareStatement("insert into emp_info (name,age,address)values(?,?,?)");

            /*
             * ps.setString(1, "Saroj Gautam");
             * ps.setInt(2, 24);
             * ps.setString(3, "Chandrapur"); *
             * int i=ps.executeUpdate();
             * if(i>0){
             * System.out.println("data inserted sucessfully");
             * }
             */
            PreparedStatement ps1 = con.prepareStatement("SELECT *FROM emp_info");
            ResultSet rs = ps1.executeQuery();
            System.out.println("Employee imformation*****");
            System.out.println("ID" + " " + "NAME" + " " + "AGE" + " " + "ADDRESS");
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
