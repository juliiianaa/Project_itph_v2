 /**
     * Uitleg class
     * @author: Juliana Goh & Negar Ahmadifard
     */
package nl.project.jn.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juulz
 */
public class UpdateMysqlTable extends MysqlDatabaseConnector{
    
    /**
     *
     * @param username
     * @throws SQLException
     */
    public void updateForgetPss(String username) throws SQLException{
        
        System.out.println("Moet nog");
        
        //SQL query for retrieving data from "users_information" table to log in user
//        String sqlStatement = "SELECT * FROM users_information where username='" + username + "';";
//        Statement stm=(Statement) con.createStatement();
////        executes the query
//        ResultSet rs = stm.executeQuery(sqlStatement);
//        
//        String access = null;
//        
//        while (rs.next()) {
//
//           access = rs.getString("userAccess");
//        }
    }
        
    /**
     *
     * @param username
     * @param name
     * @param lastName
     * @param email
     * @param password
     * @throws IOException
     * @throws SQLException
     */
    public void RegisterUser(String username, String name, String lastName, String email, String password) 
                throws IOException, SQLException {
            
            
            
        //SQL query for adding data to "users_information" table 
        String sqlStatement = "INSERT into users_information (username, name, lastName, email, password) VALUES (?, ?, ?, ?, md5(?));";

        //Makes a prepared statement with query and fills in placeholders
        PreparedStatement ps = con.prepareStatement(sqlStatement);
        //username is placed in the first ?
        ps.setString(1, username);
        //firstname
        ps.setString(2, name);
        //lastname
        ps.setString(3, lastName);
        //email 
        ps.setString(4, email);
        //password 
        ps.setString(5, password);

//      executes the query
        ps.executeUpdate();
                      
    }
    
    
}
