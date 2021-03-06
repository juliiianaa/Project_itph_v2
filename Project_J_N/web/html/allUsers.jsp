<%-- 
    Document   : allUsers
    Created on : 26-sep-2016, 14:37:06
    Author     : Juliana Goh & Negar Ahmadifard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" charset="utf8" src="js/jquery.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="js/dataTables.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <link href="css/menu.css" rel="stylesheet">
        <script src="js/nicescroll.js" type="text/javascript"></script>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
        <title>JSP Page</title>
    </head>
    
    <jsp:include page="../includes/menu.jsp" /> 
    
    <br />
    
<!--    <div id="">Push!</div>
    <div>
        Username : <input type="text">
        First <input type="text">
        <input type="text">
    </div>-->
    <label> Hallo, ${requestScope.username}</label>
    
    <div>
            <table id="user_table" class="display">
                <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>username</th>
                        <th>email</th>
                        <th>user access</th>
                    </tr>
                </thead>
                <c:if test="${not empty requestScope.usersList}">
                    <c:forEach items="${requestScope.usersList}" var="user">
                        <tr>
                            <td>${user.firstName }</td>
                            <td>${user.lastName }</td>
                            <td>${user.username }</td>
                            <td>${user.emailAddress }</td>
                            <td>${user.userAccess }</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <tfoot>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>username</th>
                        <th>email</th>
                        <th>user access</th>
                    </tr>
                </tfoot>
            </table>
    </div>    
    
</html>
