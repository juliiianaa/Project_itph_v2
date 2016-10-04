


<form>
    <div class="main" id = "logout">
        <%
            //This scriptlet gets the date
            java.util.Date date = new java.util.Date();
        %>
        <br/>
        <p id = "time">Tijd en datum:<br/> <%= date%></p>
        <table>
            <button type="button" onClick="logoutButton()">Log out</button>
        </table>
    </div>
</form>
