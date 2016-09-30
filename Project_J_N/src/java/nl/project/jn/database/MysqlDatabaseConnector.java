/**
 *
 * Class which is used for anything that has to do with the database
 * Make connection, retrieve data from the database, disconnects the database when needed
 * 
 * @author Juliana Goh & Negar Ahmadifard
 */

package nl.project.jn.database;

import java.io.IOException;
import java.sql.*;


public class MysqlDatabaseConnector {
    
    private final static String USERDB = "root";
    private final static String USERPW = "java2016" ;
    protected static Connection con;
    
    /**
     *
     * connectDB, makes a connection with the database with the help of the url, user and password
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void connectDB()throws SQLException, ClassNotFoundException, InstantiationException,IllegalAccessException {
        String url="jdbc:mysql://localhost:3306/test";
        
        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        con = DriverManager.getConnection(url,USERDB, USERPW);
        
        if(con==null)   {
            System.out.println("connection failed");
        }
        
    }

 

    /**
     *
     * disconnectDB, stops the connection of the database
     * 
     * @throws IOException
     */
    public static void disconnectDB() throws IOException {
        try {
	    //close the connection
            con.close();
        } catch (SQLException ex) {
            
            System.out.println("SQL EXCEPTION message: " + ex);
        }
    }

}
