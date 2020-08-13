<%@page import="Modelo.Clientes"%>
<%@page import="model.Libros"%>
<%@page import="ModeloDAO.LibreriaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/a69cc2f74e.js" crossorigin="anonymous"></script>
        <style>
            body {
                position: relative;
            }
            ul.nav-pills {
                top: 20px;
                position: fixed;
            }
            div.col-8 div {
                height: 500px;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body  data-spy="scroll" data-target="#myScrollspy" data-offset="1">
        <div class="container-fluid">
            <div class="row">

                <nav class="col-sm-3 col-4" id="myScrollspy">
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#section1">Usuarios Registrado</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#section2">Libros Registrados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#section3">Historial De Pedidos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#section4">Usuarios Pendientes</a>
                        </li>
                        <br>
                        <br>
                        <a class="btn btn-primary" href="Controlador?accion=index"> <i class="fas fa-home"></i> Inicio</a>
                    </ul>


                </nav>

                <div  class="col-sm-9 col-8">
                    <div id="section1" class="">    
                        <h1>Usuarios Registrados</h1>
                        <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo Usuario</a>
                        <br>
                        <br>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">ID</th>
                                    <th class="text-center">DNI</th>
                                    <th class="text-center">NOMBRES</th>
                                    <th class="text-center">CORREO</th>
                                    <th class="text-center">TELEFONO</th>
                                    <th class="text-center">ACCIONES</th>
                                </tr>
                            </thead>
                            <%
                                PersonaDAO dao = new PersonaDAO();
                                List<Persona> list = dao.listar();
                                Iterator<Persona> iter = list.iterator();
                                Persona per = null;
                                while (iter.hasNext()) {
                                    per = iter.next();

                            %>
                            <tbody>
                                <tr>
                                    <td class="text-center"><%= per.getId()%></td>
                                    <td class="text-center"><%= per.getDni()%></td>
                                    <td class="text-center"><%= per.getNom()%></td>
                                    <td class="text-center"><%= per.getCorreo()%></td>
                                    <td class="text-center"><%= per.getTel()%></td>
                                    <td class="text-center">
                                        <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getId()%>">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getId()%>">Eliminar</a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>

                    </div>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <div id="section2" class=""> 
                        <br>
                        <h1>Libros Registrados</h1>
                        <br>
                        <br>
                        <a class="btn btn-success" href="Controlador?accion=addLibro">Agregar Nuevo Libro</a>
                        <br>
                        <br>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">TITULO</th>
                                    <th class="text-center">EDITORIAL</th>
                                    <th class="text-center">AUTOR</th>
                                    <th class="text-center">ACCIONES</th>
                                </tr>
                            </thead>
                            <%
                                LibreriaDAO Libredao = new LibreriaDAO();

                                List<Libros> listLibros = Libredao.listarLibros();

                                Iterator<Libros> iterLibros = listLibros.iterator();
                                Libros l = null;
                                while (iterLibros.hasNext()) {
                                    l = iterLibros.next();

                            %>
                            <tbody>
                                <tr>
                                    <td class="text-center"><%=l.getTitulo()%></td>
                                    <td class="text-center"><%= l.getEditorial()%></td>
                                    <td><%= l.getAutor()%></td>
                                    <td class="text-center">
                                        <a class="btn btn-warning" href="Controlador?accion=editarLibro&id=<%= l.getId()%>">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?accion=eliminarLibro&id=<%= l.getId()%>">Eliminar</a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>




                    </div>  
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <div id="section3" class="">         
                        <h1>Historial De Pedidos</h1>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">DNI</th>
                                    <th class="text-center">ID PEDIDO</th>
                                    <th class="text-center">NOMBRES</th>
                                    <th class="text-center">CORREO</th>
                                    <th class="text-center">ID LIBRO</th>
                                    <th class="text-center">TITULO LIBRO</th>
                                    <th class="text-center">ESTADO</th>
                                </tr>
                            </thead>
                            <%
                                LibreriaDAO cliDao2 = new LibreriaDAO();
                                List<Clientes> listClientes = cliDao2.listarClientes();

                                Iterator<Clientes> iterCli = listClientes.iterator();
                                Clientes c = null;
                                while (iterCli.hasNext()) {
                                    c = iterCli.next();


                            %>
                            <tbody>
                                <tr>
                                    <td class="text-center"><%= c.getDni()%></td>
                                    <td class="text-center"><%= c.getIdPedido()%></td>
                                    <td class="text-center"><%= c.getNombres()%></td>
                                    <td class="text-center"><%= c.getCorreo()%></td>
                                    <td class="text-center"><%= c.getIdLibro()%></td>
                                    <td class="text-center"><%= c.getNombreLibroPrestado()%></td>
                                    <td class="text-center"><%= c.getEstado()%></td> 
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div> 
                    <br>
                    <br>

                    <div id="section4" class="">         
                        <h1>Clientes Pendientes</h1>
                        <br>
                        <a class="btn btn-success" href="Controlador?accion=addCliente">Agregar Nuevo Cliente</a>
                        <br><br><br>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">DNI</th>
                                    <th class="text-center">ID PEDIDO</th>
                                    <th class="text-center">NOMBRES</th>
                                    <th class="text-center">CORREO</th>
                                    <th class="text-center">ID LIBRO</th>
                                    <th class="text-center">TITULO LIBRO</th>
                                    <th class="text-center">ESTADO</th>
                                </tr>
                            </thead>
                            <%
                                LibreriaDAO cliDao1 = new LibreriaDAO();
                                List<Clientes> listClientesH = cliDao1.listarClientesP();
                                Iterator<Clientes> iterCliH = listClientesH.iterator();
                                Clientes cH = null;
                                while (iterCliH.hasNext()) {
                                    cH = iterCliH.next();
                            %>
                            <tbody>
                                <tr>
                                    <td class="text-center"><%= cH.getDni()%></td>
                                    <td class="text-center"><%= cH.getIdPedido()%></td>
                                    <td class="text-center"><%= cH.getNombres()%></td>
                                    <td class="text-center"><%= cH.getCorreo()%></td>
                                    <td class="text-center"><%= cH.getIdLibro()%></td>
                                    <td class="text-center"><%= cH.getNombreLibroPrestado()%></td>
                                    <td class="text-center"><%= cH.getEstado()%></td>

                                    <td class="text-center">
                                        <a class="btn btn-success" href="Controlador?accion=Alta&id=<%= c.getIdPedido()%>">Dar de alta</a> 
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>

                    </div>

                </div>

            </div>
        </div>








    </body>
</html>
