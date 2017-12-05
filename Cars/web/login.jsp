<%-- 
    Document   : login
    Created on : Nov 27, 2017, 6:33:37 PM
    Author     : Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="login">
        <form action="LoginServlet" method="post">
            Username: <input type="text" name="username"> <br />
            Password: <input type="password" name="password">
            <input type="submit" value="Submit">
        </form>
        </div>
    </body>
</html>
