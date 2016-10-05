package nl.project.jn.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nl.project.jn.servlets.User;

/**
 * This class will be called whenever data needs to be retrieved from the database with a select query
 * 
 * @author Juliana Goh & Negar Ahmadifard
 */
public class RetrieveMysqlData extends MysqlDatabaseConnector{
    
     /**
     *
     * This class will be called to check if the user that logged in from the website is a valid user or not
     * 
     * @param username      A string of the given username
     * @param password      A string of the given password
     * @return              An user object
     * @throws IOException
     * @throws SQLException
     */
    public User LoginUser(String username, String password) throws IOException, SQLException {

        //SQL select query for retrieving data from the table "users_information".
        String sqlStatement = "SELECT * FROM users_information WHERE username=? AND password=md5(?)";
        
        //Creates a new user
        User u = new User();
        
        //Makes a prepared statement with query and fills in the placeholders
        PreparedStatement ps = con.prepareStatement(sqlStatement);
        //username is placed in the first " ?" 
        ps.setString(1, username);
        //password is placed in the 2nd " ?"  and hashed with md5
        ps.setString(2, password);

        //executes the query
        ResultSet rs = ps.executeQuery();

        //if no data is found
        if (!rs.next() ) {
            System.out.println("no data");
        }else{
            //All information of the logged in user will be saved in User object    
            u.setUsername(rs.getString("username"));
            u.setFirstName(rs.getString("name"));
            u.setLastName(rs.getString("lastName"));
            u.setEmailAddress(rs.getString("email"));
            u.setUserAccess(rs.getString("userAccess"));
                
        }
        
        return u;
    }
    
    /**
     * This class will be called to retrieve all information of all the users found in the database.
     * 
     * @return A list of the users saved as an object User
     * @throws SQLException
     */
    public static List<User> getAllUser() throws SQLException{
        
        //SQL select query for retrieving data from the table "users_information".
        String sqlStatement = "SELECT * FROM users_information";
        
        //Creates the sql statement
        Statement stm=(Statement) con.createStatement();
        //executes the query
        ResultSet rs = stm.executeQuery(sqlStatement);
        
        //A List which only accepts User objects
        List<User> list = new ArrayList<>();
        
        while (rs.next()) {
            User u = new User();
           
            u.setUsername(rs.getString("username"));
            u.setFirstName(rs.getString("name"));
            u.setLastName(rs.getString("lastName"));
            u.setEmailAddress(rs.getString("email"));
            u.setUserAccess(rs.getString("userAccess"));
            
            //Adds the User object to List
            list.add(u);
            
        }
        return list;
    }
    
    /**
     * This class will be called from the RegisterServlet to check if a registered username is already in use or not.
     * 
     * @param username String of user that wants to be registered under the given username
     * @return boolean, if user exists or not
     * @throws IOException
     * @throws SQLException
     */
    public boolean CheckUser(String username) throws IOException, SQLException {
        //boolean is set to true
    	boolean usernameExists = true;
    	
        //SQL select query for retrieving data from the table "users_information".
    	String sqlExist = "SELECT * FROM users_information WHERE username=?";    
        
        PreparedStatement sqlu = con.prepareStatement(sqlExist);

        sqlu.setString(1, username);
        
        ResultSet rs = sqlu.executeQuery();
        
        if(!rs.next()) { 
            //Sets username to false if no data is found of the given username
            usernameExists = false;
        } 
        return usernameExists;
    }

    /**
     * This class will be called from the RegisterServlet to check if a registered email is already in use or not.
     *
     * @param email String of user that wants to be registered under the given email
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public boolean CheckEmail(String email) throws IOException, SQLException {
        //boolean is set to true
    	boolean emailExists = true;
    	
    	String sqlExist = "SELECT * FROM users_information WHERE email=?";    
        
        PreparedStatement sqle = con.prepareStatement(sqlExist);

        sqle.setString(1, email);
        
        ResultSet rs = sqle.executeQuery();
        
        if(!rs.next()) { 
            //Sets email to false if no data is found of the given username
            emailExists = false;
        } 
        return emailExists;
    }
    
}