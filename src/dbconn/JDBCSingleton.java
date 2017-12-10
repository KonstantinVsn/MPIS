package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCSingleton {
    // Step 1
    // create a JDBCSingleton class.
    // static member holds only one instance of the JDBCSingleton class.

    private static JDBCSingleton jdbc;

    // JDBCSingleton prevents the instantiation from any other class.
    private JDBCSingleton() {
    }

    // Now we are providing gloabal point of access.
    public static JDBCSingleton getInstance() {
        if (jdbc == null) {
            jdbc = new JDBCSingleton();
        }
        return jdbc;
    }

    // to get the connection from methods like insert, view etc.
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "1234");
        return con;

    }
}
