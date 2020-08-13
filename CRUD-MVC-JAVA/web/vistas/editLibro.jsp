<%-- 
    Document   : editLibro
    Created on : 12/08/2020, 01:42:39 AM
    Author     : david
--%>

<%@page import="model.Libros"%>
<%@page import="ModeloDAO.LibreriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/a69cc2f74e.js" crossorigin="anonymous"></script>


        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <% LibreriaDAO dao = new LibreriaDAO();
                    int id = Integer.parseInt((String) request.getAttribute("id"));
                    Libros li = dao.listLib(id);%>
                <h1>Modificar Persona</h1>
                <form action="Controlador">

                    TITULO:<br>
                    <input class="form-control" type="text" name="txtTitulo"  value="<%= li.getTitulo()%>"><br>
                    EDITORIAL:<br>
                    <input class="form-control" type="text" name="txtEditorial"  value="<%= li.getEditorial()%>"><br>
                    AUTOR:<br>
                    <input class="form-control" type="text" name="txtAutor"  value="<%= li.getAutor()%>"><br>


                    <input type="hidden" name="txtid" value="<%= li.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="ActualizarLibro"> 
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
