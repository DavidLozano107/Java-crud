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
        <title>Holi</title>
    </head>
    <body>
        <%
            loginDAO lo = new loginDAO();

            String correo = request.getParameter("login");
            String contra = request.getParameter("password");
            String btnLogin = request.getParameter("btnLogin");

            User u = (User) lo.loguear(correo, contra);
            HttpSession sesion = request.getSession();

            if (btnLogin != null) {
                switch (2) {
                    case 1:
                        sesion.setAttribute("user", u.getNombres());
                        sesion.setAttribute("nivel", u.getNivel());
                        out.print("Holaa");
                        response.sendRedirect("Controlador?accion=listar");
                        break;
                    case 2:
                        sesion.setAttribute("user", u.getNombres());
                        sesion.setAttribute("nivel", u.getNivel());
                        out.print("Holaa");
                        response.sendRedirect("Controlador?accion=listar");
                        break;
                    case 3:
                        out.print("Holaa");
                        break;
                }

            }


        %>
        <h1> Prueba</h1>
    </body>
</html>
