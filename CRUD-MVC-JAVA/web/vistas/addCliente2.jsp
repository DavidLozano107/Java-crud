<%-- 
    Document   : addCliente2
    Created on : 12/08/2020, 01:44:25 PM
    Author     : david
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.LibreriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/a69cc2f74e.js" crossorigin="anonymous"></script>
        <style>
            .form-control{
                width: 70%

            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar un nuevo usuario</h1>
                <br>
                <%
                    LibreriaDAO daoL = new LibreriaDAO();
                    String dni = request.getParameter("txtDni");
                    List<Persona> list = daoL.BusquedaDni(dni);
                    
                    Iterator<Persona> iter = list.iterator();
                    Persona per = null;
                    while (iter.hasNext()) {
                        per = iter.next();

                %>

                <form action="Controlador">
                    ID:<br />
                    <input  class="form-control" type="text" name="txtId" id="" value="<%= per.getId()%>" /> 
                    DNI:<br />
                    <input  class="form-control" type="text" id="" value="<%= per.getDni()%>" /> 
                    NOMBRE:<br />
                    <input class="form-control" type="text" name="txtNom" id="" value="<%= per.getNom()%>" />
                    CORREO:<br />
                    <input class="form-control" type="text" name="txtCorreo" id="" value="<%= per.getCorreo()%>" /> 
                    TELEFONO:<br />
                    <input class="form-control" type="text" name="txtTelefono" id="" value="<%= per.getTel()%>" /> 
                    <br><br>
                    <h1>LIBRO:  </h1>
                    <hr>
                    <br><br>
                    ID LIBRO:<br>
                    <input class="form-control" type="text" name="txtIdLibro"><br>
                     NOMBRE LIBRO: <br>
                    <input class="form-control" type="text" name="txtTitulo"><br>
                    
                    <input type="text" name="Estado" id="" value="Pendiente" hidden>
                    
                    <input class="btn btn-success" type="submit" name="accion" value="RegistrarCliente">
                </form>

                <%
                    }
                %>
                <br>
                <a class="btn btn-danger" href="Controlador?accion=listar">Cancelar</a>
                
            </div>
        </div>
    </body>
</html>
