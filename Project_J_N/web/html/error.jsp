<%-- 
    Document   : error
    Created on : 3-okt-2016, 11:22:04
    Author     : juulz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            setTimeout(function(){
               window.location='form.html';
            }, 5000);
        </script>
        <link href="../css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <jsp:include page="../includes/menu.jsp" /> 
        
        <div>

        </div>
    </body>
</html>
