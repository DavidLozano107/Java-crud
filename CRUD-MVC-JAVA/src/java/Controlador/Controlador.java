package Controlador;

import Modelo.Clientes;
import Modelo.Persona;
import ModeloDAO.LibreriaDAO;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Libros;

public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    String index = "index.jsp";
    String addLibro = "vistas/addLibro.jsp";
    String editLibro = "vistas/editLibro.jsp";
    String addCliente = "vistas/addCliente.jsp";
    String addCliente2 = "vistas/addCliente2.jsp";

    int idLibro;

    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();
    Clientes cli = new Clientes();

    Libros l = new Libros();
    LibreriaDAO daoLibro = new LibreriaDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {

            String dni = request.getParameter("txtDni");
            String nom = request.getParameter("txtNom");
            String correo = request.getParameter("txtCorreo");
            String tel = request.getParameter("txtTelefono");
            p.setDni(dni);
            p.setNom(nom);
            p.setCorreo(correo);
            p.setTel(tel);

            dao.agregar(p);
            acceso = listar;

        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Alta")) {

            int idPerAlt = Integer.parseInt(request.getParameter("id"));
            daoLibro.ActualizarEstado(idPerAlt);

            acceso = listar;
        } else if (action.equalsIgnoreCase("editarLibro")) {
            request.setAttribute("id", request.getParameter("id"));
            acceso = editLibro;
        } else if (action.equalsIgnoreCase("Actualizar")) {

            id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("txtDni");
            String nom = request.getParameter("txtNom");
            String correo = request.getParameter("txtCorreo");
            String tel = request.getParameter("txtTelefono");

            p.setId(id);
            p.setDni(dni);
            p.setNom(nom);
            p.setCorreo(correo);
            p.setTel(tel);

            dao.actualizar(p);

            acceso = listar;

        } else if (action.equalsIgnoreCase("ActualizarLibro")) {

            id = Integer.parseInt(request.getParameter("txtid"));
            String titulo = request.getParameter("txtTitulo");
            String editorial = request.getParameter("txtEditorial");
            String autor = request.getParameter("txtAutor");

            l.setId(id);
            l.setAutor(autor);
            l.setEditorial(editorial);
            l.setTitulo(titulo);

            daoLibro.edit(l);

            acceso = listar;

        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.delete(id);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminarLibro")) {
            id = Integer.parseInt(request.getParameter("id"));
            l.setId(id);
            daoLibro.delete(id);
            acceso = listar;
        } else if (action.equalsIgnoreCase("index")) {
            acceso = index;
        } else if (action.equalsIgnoreCase("addLibro")) {
            acceso = addLibro;
        } else if (action.equalsIgnoreCase("addCliente")) {
            acceso = addCliente;
        } else if (action.equalsIgnoreCase("AgregarLibro")) {
            String titulo = request.getParameter("txtTitulo");
            String editorial = request.getParameter("txtEditorial");
            String autor = request.getParameter("txtAutor");

            l.setAutor(autor);
            l.setEditorial(editorial);
            l.setTitulo(titulo);

            daoLibro.agregar(l);
            acceso = listar;
        } else if (action.equalsIgnoreCase("Buscar")) {

            acceso = addCliente2;

        } else if (action.equalsIgnoreCase("RegistrarCliente")) {

            int idp = Integer.parseInt(request.getParameter("txtId"));
            int idLibroC = Integer.parseInt(request.getParameter("txtIdLibro"));

            String nom = request.getParameter("txtNom");
            String correo = request.getParameter("txtCorreo");
            String tel = request.getParameter("txtTelefono");
            String titulo = request.getParameter("txtTitulo");

            cli.setNombres(nom);
            cli.setCorreo(correo);
            cli.setTelefono(tel);
            cli.setIdLibro(idLibroC);
            cli.setIdPersona(idp);
            cli.setNombreLibroPrestado(titulo);

            daoLibro.agregarCliente(cli);

            acceso = listar;

        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
