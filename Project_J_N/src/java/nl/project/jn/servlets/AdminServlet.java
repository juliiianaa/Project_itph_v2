package nl.project.jn.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.project.jn.database.MysqlDatabaseConnector;
import nl.project.jn.database.RetrieveMysqlData;

/**
 * This class will be used for when an admin has logged in. 
 * This class will retrieve all the data of every user in the database and will send it to the frontend
 *
 * @author Juliana Goh & Negar Ahmadifard
 */
public class AdminServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Empty list which only accept User objects
        List<User> users = null; 
        
        try {
            //connects with the database
            MysqlDatabaseConnector.connectDB();
            //Saves the given user object to the List<User>
            users = RetrieveMysqlData.getAllUser();
            //disconnect with database
            MysqlDatabaseConnector.disconnectDB();
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Sets users to variable usersList and sends it to server
        request.setAttribute("usersList", users);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/html/allUsers.jsp");  
        rd.forward(request, response);
        
    }
}
