<%-- 
    Document   : book
    Created on : 4-okt-2016, 11:11:08
    Author     : juulz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/menu.css" rel="stylesheet">
        <link href="../css/book.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="../js/turnPages.js"></script>
        <script src="../js/turn.js"></script>
    </head>
    <body>
        <jsp:include page="../includes/menu.jsp" /> 
        
        <jsp:include page="../includes/logout.jsp" /> 
        
       <div id="flipbook">
            <div class="hard"> Turn.js </div> 
            <div class="hard"></div>
            <div> Page 1 </div>
            <div> Page 2 </div>
            <div> Page 3 </div>
            <div> Page 4 </div>
            <div class="hard"></div>
            <div class="hard"></div>
        </div>
        
    </body>
</html>
