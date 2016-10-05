package nl.project.jn.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import nl.project.jn.database.*;

/**
 * This class will be used for when a user logs in
 * 
 * @author Juliana Goh & Negar Ahmadifard
 */
public class LoginServlet extends HttpServlet {

    
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
        
            try {
                //gets the parameter value given from AJAX
                String username = request.getParameter("user");
                String password = request.getParameter("passwordUser");
                
                String href = null;
                
                
                //connects with the database
                MysqlDatabaseConnector.connectDB();

                //If username and password is not empty, check users Login
                if (username!=null&&password!=null) {
                    System.out.println(username + " " + password);

                    RetrieveMysqlData rd = new RetrieveMysqlData();
                    
                    //Sends the data to the LoginUser method in MysqlDatabaseConnector class to check if the user already is registrated
                    User user = rd.LoginUser(username, password);

                    
                    if(user.getUserAccess()== null){
                           href = "error";
                    
                    }else{
                        if(user.getUserAccess().equals("yes")){
                            href = user.getUserAccess();

                        } else{
                            href = user.getUserAccess();
                        }

                        // disconnects the database
                        MysqlDatabaseConnector.disconnectDB();
                    }
                }
                response.getWriter().print(href);
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException  ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }

}
