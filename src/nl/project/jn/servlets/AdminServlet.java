 /**
     * Uitleg class
     * @author: Juliana Goh & Negar Ahmadifard
     */
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
import nl.project.jn.database.User;

public class AdminServlet extends HttpServlet {

    /**
	 * 
	 */
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
        
        List<User> users = null; 
        
        try {
//            connects with the database
            MysqlDatabaseConnector.connectDB();
            
       
           users = RetrieveMysqlData.getAllUser();
           
           MysqlDatabaseConnector.disconnectDB();
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        request.setAttribute("usersList", users); 
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/html/allUsers.jsp");  
        rd.forward(request, response);
        
        
    }

}
