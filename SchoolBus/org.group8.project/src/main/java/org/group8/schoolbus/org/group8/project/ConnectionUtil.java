package org.group8.schoolbus.org.group8.project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class ConnectionUtil {
    Connection conn = null;
    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhostlocalhost:3306/my_database?user=root&password=Pass");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
           return null;
        }
    }
    
}