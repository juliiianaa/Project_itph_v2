package nl.project.jn.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.project.jn.database.MysqlDatabaseConnector;
import nl.project.jn.database.RetrieveMysqlData;
import nl.project.jn.database.UpdateMysqlTable;

/**
 * This servlet is called when an user wants to register for the first time. 
 * Ajax sends the username's given values to the Servlet, which in turn sends the values to the database.
 * This class contains the method doPost().
 * @author: Julia Goh & Negar Ahmadifard
 */
public class RegisterServlet extends HttpServlet {
    
    //A version control in a Serializable class
    private static final long serialVersionUID = 1L;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Gets the parameter values which are send by AJAX
        String username = request.getParameter("user");
        String name = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");        
        String password = request.getParameter("password");

        // String, which contains the message which will be alerted to the user when registration fails, 
        // or it contains the redirect url when registration is completed.
        String href;
            
        try{
           // Connecting with the database.
           MysqlDatabaseConnector.connectDB();
           
           /*
	   * First, checking whether the username is already taken. 
           * If the username is already taken, a message will be alerted to the user. 
           * If the username isn't taken, it will then check whether the emailaddress is already in use.
           * If the email is already in use, a message will be alerted to the user. 
           * If both the username and the email aren't in use, data will be send to the database. 
            */
           RetrieveMysqlData ch = new RetrieveMysqlData();
           
           //Checks if the given user exists or not
           boolean checkuser = ch.CheckUser(username);
           
           //if user does not exist
           if(checkuser == false) {
                   //checks if email exists or not
        	   boolean checkemail = ch.CheckEmail(email);
        	   //if email does not exist
        	   if(checkemail == false) {
        		   
                       
		           UpdateMysqlTable ut = new UpdateMysqlTable();
                           //Register the user to database
		           ut.RegisterUser(username, name, lastName, email, password);    
		           
		           href="complete";

        	   } else {
		           href="This email is already in use. Please use another emailaddress.";
        	   }
           }  else {
	           href="This username is already taken. Please choose another username.";
           }
           response.getWriter().write(href);
           
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        
        } finally {     	
          //Disconnecting the database.
          MysqlDatabaseConnector.disconnectDB();
        }
    }
}