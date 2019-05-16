package org.group8.schoolbus.org.group8.project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class ConnectionUtil {
    Connection conn = null;
    static Statement stmt = null;
    
    @SuppressWarnings("unused")
    /**
     * creates buswhere_users table in database
     * if you don't yet have buswhere_users table uncomment lines 32 and 33 and run the program
     * after table has been created, comment them out again
     * also make sure to change line 33 to your user name and password
     */
	private static final String BUSWHERE_USERS = "create table buswhere_users ( "
    	      + "   firstName VARCHAR(20), lastName VARCHAR(20), "
    	      + "   userName VARCHAR(20), password VARCHAR(20))";
    	  
    
    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=tanianelzy&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST");
        //    stmt = con.createStatement();
        //    stmt.executeUpdate(BUSWHERE_USERS);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
           return null;
        }
    }
    
}