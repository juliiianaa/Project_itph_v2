
<form id = "logout" class="login" action="/LogOutServlet" method="POST" action="#">
    <input type="hidden" name="location" value="${param.location}">
    <div class="main" id = "logout">
        <label> Hallo, ${sessionScope.user.username}</label><br/>
        <!--by mkslofstra-->
        <%
            //This scriptlet gets the date
            java.util.Date date = new java.util.Date();
        %>
        <br/>
        <p id = "time">Tijd en datum:<br/> <%= date%></p>
        <table>
            <input type="submit" value="Log uit" name="logout" id="login" class="logoutButton"/>    
        </table>
    </div>
</form>
