<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.User"%>
<%@page import="ModeloDAO.loginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>

        
        <h1>Introduce tus datos</h1>
    <form action="Controlador?accion=index" method="post">
        <fieldset>
            <legend>Ingrese</legend>
            <label for=""> User: <input type="text" name="login"> </label><br><br>
            <label for=""> Password: <input type="password" name="password" id=""></label><br><br>
            <input type="submit" name="btnLogin" value="Login">
        </fieldset>
    </form>
</body>
        
        
        
        
        
      
    </body>
</html>
