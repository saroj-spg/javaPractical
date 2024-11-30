import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTable {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/emp";

            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, userName, password);
            // System.out.println("connected ");
            /*
             * String sql = "CREATE DATABASE " + databaseName;
             * Statement s = con.createStatement();
             * s.executeUpdate(sql);
             * s.close();
             */
            Statement s = con.createStatement();
            String sql1 = "CREATE TABLE emp_info(id int(20) primary key auto_increment,name varchar(30) unique not null,age int(20),address varchar(30))";
            s.executeUpdate(sql1);
            System.out.println("table created ");
            s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}