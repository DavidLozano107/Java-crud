<%-- 
    Document   : addCliente
    Created on : 12/08/2020, 12:25:53 PM
    Author     : david
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.LibreriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./../css/stylo.css">
    </head>
    <body>
        <div class="container">
            <h1>Agregar Cliente </h1>
            <form action="Controlador" method="get">
                <fieldset>
                    <legend>Buscar</legend>
                    <input class="form-control" id="Buscar" type="text" name="txtDni"><input class="btn btn-success" type="submit" name="accion" value="Buscar"> 

                </fieldset>

            </form>
            <br>
            <br>
            <a class="btn btn-primary" href="Controlador?accion=listar">Regresar</a> 
        </div>

    </body>
</html>
