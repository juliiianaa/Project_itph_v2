package nl.project.jn.database;

import java.io.IOException;
import java.sql.*;

/**
 * This class will be called when a connection or disconnection with the database needs to be made. 
 * 
 * @author Juliana Goh & Negar Ahmadifard
 */
public class MysqlDatabaseConnector {
    
    //The needed information to access the database 
    private final static String USERDB = "root";
    private final static String USERPW = "java2016" ;
    //format for a JDBC url for connecting with the MYSQL server by: host:port/database
    private final static String URL ="jdbc:mysql://localhost:3306/test";

    //protected class variable where the connection can only be made from the class
    protected static Connection con;
    
    /**
     * This class will be called to make a connection with the database.
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void connectDB()throws SQLException, ClassNotFoundException, InstantiationException,IllegalAccessException {
        //Class that implements the java.sql.Driver. Used when registering the driver or when configuring a software to use MySQL Connector/J
        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        
        //Connection with the MySQL server 
        con = DriverManager.getConnection(URL,USERDB, USERPW);
        
        //Connection failed if null
        if(con==null)   {
            System.out.println("connection failed");
        }
        
    }

    /**
     *
     * This class will be called to disconnect the database
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
