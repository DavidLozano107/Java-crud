package ModeloDAO;

import Config.Conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Clientes;
import model.Libros;

public class LibreriaDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Libros l = new Libros();

    public List listarLibros() {
        ArrayList<Libros> datos = new ArrayList<>();
        String sql = "select * from libros";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Libros l = new Libros();

                l.setId(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setEditorial(rs.getString(3));
                l.setAutor(rs.getString(4));
                datos.add(l);
            }
        } catch (Exception e) {

        }
        return datos;
    }

    public List listarClientes() {
        ArrayList<Clientes> datos = new ArrayList<>();
        String sql = " SELECT persona.Dni, idPedido, nombres ,correoCliente,idLibro, libroPrestado, Estado FROM cliente INNER JOIN libros ON idLibro = libros.id INNER JOIN persona on correo = cliente.correoCliente";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();

                c.setDni(rs.getString(1));
                c.setIdPedido(rs.getInt(2));
                c.setNombres(rs.getString(3));
                c.setCorreo(rs.getString(4));
                c.setIdLibro(rs.getInt(5));
                c.setNombreLibroPrestado(rs.getString(6));
                c.setEstado(rs.getString(7));

                datos.add(c);
            }
        } catch (Exception e) {

        }
        return datos;
    }

    public List listarClientesP() {
        ArrayList<Clientes> datos = new ArrayList<>();
        String sql = "SELECT persona.Dni, idPedido, nombres ,correoCliente,idLibro, libroPrestado, Estado FROM cliente INNER JOIN libros ON idLibro = libros.id INNER JOIN persona on nombre = cliente.nombres WHERE Estado = 'Pendiente'";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();

                c.setDni(rs.getString(1));
                c.setIdPedido(rs.getInt(2));
                c.setNombres(rs.getString(3));
                c.setCorreo(rs.getString(4));
                c.setIdLibro(rs.getInt(5));
                c.setNombreLibroPrestado(rs.getString(6));
                c.setEstado(rs.getString(7));

                datos.add(c);
            }
        } catch (Exception e) {

        }
        return datos;
    }

    public int agregar(Libros l) {
        String sql = "INSERT INTO libros (titulo, editorial, autor) VALUES (?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getEditorial());
            ps.setString(3, l.getEditorial());

            ps.executeUpdate();

        } catch (Exception e) {

        }
        return 1;
    }

    public boolean agregarCliente(Clientes c) {
        String sql = "INSERT INTO cliente (nombres, correoCliente,telefono,idLibro,idPersona,Estado, libroPrestado)  VALUES ('" + c.getNombres() + "','" + c.getCorreo() + "','" + c.getTelefono() + "'," + c.getIdLibro() + "," + c.getIdPersona() + ",'Pendiente','" + c.getNombreLibroPrestado()+ "')";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            

        }
        return false;
    }

    public int actualizar(Persona p) {
        int r = 0;

        String sql = "update persona set nombre=?, correo=?, telefono=?, where id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, p.getNom());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTel());
            ps.setInt(4, p.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {

        }

        return r;

    }

    public void delete(int id) {
        String sql = "DELETE FROM libros WHERE id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public Libros listLib(int id) {

        String sql = "select * from libros where Id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                l.setId(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setEditorial(rs.getString(3));
                l.setAutor(rs.getString(4));

            }
        } catch (Exception e) {

        }
        return l;
    }

    public boolean edit(Libros l) {
        String sql = "update libros set id='" + l.getId() + "',titulo='" + l.getTitulo() + "' ,editorial='" + l.getEditorial() + "',autor='" + l.getAutor() + "' where id=" + l.getId();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public void ActualizarEstado(int id) {

        String sql = "UPDATE cliente SET Estado ='Entregado' WHERE idPedido=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public List BusquedaDni(String dni) {

        List<Persona> datos = new ArrayList();
        String sql = "select * from persona where Dni=" + dni;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Persona p = new Persona();

                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
                p.setDni(rs.getString(5));
                datos.add(p);
            }
        } catch (Exception e) {

        }
        return datos;
    }

}
