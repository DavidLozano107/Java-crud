<%-- 
    Document   : addLibro
    Created on : 12/08/2020, 01:17:41 AM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
       
        <title>JSP Page</title>
    </head>
    <body>
               <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Libro</h1>
                <form action="Controlador">
                    TITULO:<br>
                    <input class="form-control" type="text" name="txtTitulo"><br>
                    EDITORIAL:<br>
                    <input class="form-control" type="text" name="txtEditorial"><br>
                    AUTOR:<br>
                    <input class="form-control" type="text" name="txtAutor"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="AgregarLibro">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
