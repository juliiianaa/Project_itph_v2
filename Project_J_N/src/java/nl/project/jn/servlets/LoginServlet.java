/**
 *
 * A servlet which receive the data from the ajax call in sendData.js (function called performAjaxSend)
 * 
 * 
 * @author Juliana Goh & Negar Ahmadifard
 */

package nl.project.jn.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import nl.project.jn.database.*;

/**
 *
 * @author juulz
 */
public class LoginServlet extends HttpServlet {

    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
            try {
                //        gets the parameter value given from AJAX
                String username = request.getParameter("user");
                String password = request.getParameter("passwordUser");
                
                System.out.println(username + " " + password);
                
                String href = null;
                
                
                //            connects with the database
                MysqlDatabaseConnector.connectDB();

                //            If username and password is not empty, check users Login
                if (username!=null&&password!=null) {
                    System.out.println(username + " " + password);

                    RetrieveMysqlData rd = new RetrieveMysqlData();

                //                Sends the data to the LoginUser method in MysqlDatabaseConnector class to check if the user already is registrated
                    User user = rd.LoginUser(username, password);

                    System.out.println(user.getUserAccess());
                    
                    if(user.getUserAccess()== null){
                           href = "error";
                    
                    }else{


                        if(user.getUserAccess().equals("yes")){
                            System.out.println("yaaayyy admin");
                    //                    RequestDispatcher view = request.getRequestDispatcher("/AdminServlet");
                    //                    view.forward(request, response);

                    //Sends the generated script to the website page
                    //                    href = "../AdminServlet";
                            href = user.getUserAccess();

                        } else{
                            System.out.println("user");
                            //Sends the generated script to the website page
                        //                	href = "../html/user.jsp";
                            href = user.getUserAccess();
                        }

                        // disconnects the database
                        MysqlDatabaseConnector.disconnectDB();
                    
                    }
                }
                
//                request.setAttribute("dsad", href);
//                RequestDispatcher view = new ;
//                view.forward()

                response.getWriter().print(href);
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException  ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }

}
