package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LibreriaDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarLibros(){
        
        List<Libros>datos = new ArrayList();
        String sql ="select * from libros";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Libros l = new Libros();
                
                l.setId(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setEditorial(rs.getString(3));
                l.setAutor(rs.getString(4));
                datos.add(l);      
            }
        }catch(Exception e){
            
        }
        return datos;
    }    
    
        public List listarClientes(){
        
        List<Clientes>datos = new ArrayList();
        String sql ="SELECT idPedido,nombres,correoCliente,idLibro,libroPrestado,Estado FROM cliente INNER JOIN libros ON idLibro = libros.id";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Clientes c = new Clientes();
                
                c.setIdPedido(rs.getInt(1));
                c.setNombres(rs.getString(2));
                c.setCorreo(rs.getString(3));
                c.setIdLibro(rs.getInt(4));
                c.setNombreLibroPrestado(rs.getString(5));
                c.setEstado(rs.getString(6));
                
                
                datos.add(c);      
            }
        }catch(Exception e){
            
        }
        return datos;
    }  
    
    
    
    
    
    public int agregar(Libros l){
        String sql ="INSERT INTO libros (titulo, editorial, autor) VALUES (?,?,?)";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getEditorial());
            ps.setString(3, l.getEditorial());
            
            ps.executeUpdate();         
            
        }catch (Exception e){
            
        }
        return 1;
    }
    
       
    public int agregarCliente(Clientes c){
        String sql ="INSERT INTO cliente (nombres, correoCliente,telefono,idLibro,idPersona,Estado, libroPrestado)  VALUES (?,?,?,?,?,?,?)";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getCorreo());
            ps.setString(3, c.getTelefono());
            ps.setInt(4, c.getIdLibro());
            ps.setInt(5, c.getIdPersona());
            ps.setString(6, c.getEstado());
            ps.setString(7, c.getIdLibroPrestado());
           
            
            ps.executeUpdate();         
            
        }catch (Exception e){
            
        }
        return 1;
    }
    
    public int actualizar(Persona p){
        int r=0;
        
        String sql ="update persona set nombre=?, correo=?, telefono=?, where id=?";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, p.getNom());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTel());
            ps.setInt(4, p.getId());
            r = ps.executeUpdate();
             if(r == 1){
                return 1;
             } else{
                 return 0;
             }
            
          
        
        }catch(Exception e){
            
        }
        
        return r;
    
    }
    
    public void delete (int id){
        String sql ="DELETE FROM libros WHERE id="+id;
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
    }
    
     public void ActualizarEstado (int id){
        String sql ="UPDATE cliente SET Estado ='Entregado' WHERE idPedido=?";
        try{    
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            
        }catch(Exception e){
           
        }
    }
    
      
        public List BusquedaId(int id){
            
        List<Persona>datos=new ArrayList();
        String sql ="select * from persona where id="+id;
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Persona p = new Persona();
                
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
                datos.add(p);      
            }
        }catch(Exception e){
            
        }
        return datos;
    }  

    
    
    
}
