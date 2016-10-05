package nl.project.jn.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class is used when a new user wants to register for the first time or when a user wants to change his/her password. 
 * This class contains the methods UpdatePass() and RegisterUser().
 * @author Juliana Goh & Negar Ahmadifard
 */
public class UpdateMysqlTable extends MysqlDatabaseConnector{
    
    /**
     * This method is called when the user wants to change his/her password. 
     * @param username, String which contains the user's username.
     * @param password, String which contains the new password of the user.
     * @throws SQLException
     */
    public void UpdatePass(String username, String password) throws SQLException {
        
        // SQL query to change the password which already exists in the database.
        // The PreparedStatement sends SQL statements to the database.
        // The given username is replaced with the second "?". 
        // The password for the given username is replaced with the first "?" and hashed with md5. 
        String sqlStatement = "UPDATE users_information SET password=md5(?) WHERE username=?";
        PreparedStatement ps = con.prepareStatement(sqlStatement);
        ps.setString(1, password);
        ps.setString(2, username);
        
        ps.executeUpdate();
        
        System.out.println(ps.toString());   
    }
        
    /**
     * This method is called when the user wants to register for the first time, to send input to the database. 
     * @param username, String which contains the user's username.
     * @param name, String which contains the first name of the user.
     * @param lastName, String which contains the last name of the user.
     * @param email, String which contains the email name of the user.
     * @param password, String which contains the password of the user.
     * @throws IOException
     * @throws SQLException
     */
    public void RegisterUser(String username, String name, String lastName, String email, String password) 
                throws IOException, SQLException {
            
        // SQL query for adding data to "users_information" table.
        // A prepared statement is used to fill in placeholders and send it to the database.
        // Username is replaced with the first "?", the first name with the second "?" and so forth. 
        // Password gets hashed with md5.
        String sqlStatement = "INSERT into users_information (username, name, lastName, email, password) VALUES (?, ?, ?, ?, md5(?));";
        PreparedStatement ps = con.prepareStatement(sqlStatement);
        ps.setString(1, username);
        ps.setString(2, name);
        ps.setString(3, lastName);
        ps.setString(4, email);
        ps.setString(5, password);

        //The query gets executed. 
        ps.executeUpdate();
        
    }
    
        
}