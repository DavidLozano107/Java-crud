<%@page import="Modelo.Persona"%> <%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <!-- Latest compiled and minified CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
            integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
            crossorigin="anonymous"
        />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <% PersonaDAO dao = new PersonaDAO(); int idPer =
                Integer.parseInt((String) request.getAttribute("id")); Persona
                p=(Persona)dao.list(idPer); %>
                <h1>Modificar Persona</h1>
                <form action="Controlador">
                    DNI:<br />
                    <input
                        class="form-control"
                        type="text"
                        name="txtDni"
                        value="<%= p.getDni()%>"
                    /><br />
                    Nombres: <br />
                    <input
                        class="form-control"
                        type="text"
                        name="txtNom"
                        value="<%= p.getNom()%>"
                    /><br />
                    Correo:<br />
                    <input
                        class="form-control"
                        type="text"
                        name="txtCorreo"
                        value="<%= p.getCorreo()%>"
                    /><br />
                    Telefono:
                    <input
                        class="form-control"
                        type="text"
                        name="txtTelefono"
                        value="<%= p.getTel()%>"
                    /><br />

                 

                    <input type="hidden" name="txtid" value="<%= p.getId()%>" />
                    <input
                        class="btn btn-primary"
                        type="submit"
                        name="accion"
                        value="Actualizar"
                    />
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
