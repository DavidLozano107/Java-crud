
package ModeloDAO;

import Config.Conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();
    
    
    
    public List listar(){
        List<Persona>datos=new ArrayList();
        String sql ="select * from persona";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Persona per = new Persona();
                
                per.setId(rs.getInt(1));
                per.setNom(rs.getString(2));
                per.setCorreo(rs.getString(3));
                per.setTel(rs.getString(4));
                per.setDni(rs.getString(5));
                datos.add(per);      
            }
        }catch(Exception e){
            
        }
        return datos;
    }    
    
     public Persona list(int id) {
        String sql="select * from persona where id="+id;
        try {
          con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
           
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
                p.setDni(rs.getString(5));
                
                
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    
    
    
    public boolean agregar(Persona p){
        String sql ="INSERT INTO persona (nombre, correo, telefono, Dni) VALUES ('"+ p.getNom()+"','"+ p.getCorreo()+"','"+ p.getTel()+"', '"+ p.getDni()+"' )";                             
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.executeUpdate();         
            
        }catch (Exception e){
            
        }
        return false;
    }
    
    public boolean actualizar(Persona p){        
         String sql="update persona set Dni='"+p.getDni()+"',nombre='"+p.getNom()+"', correo='"+p.getCorreo()+"',telefono='"+p.getTel()+"' where id="+p.getId();

        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();

       
        }catch(Exception e){
         
        }
        
        return false;
    
    }
    
    public boolean delete (int id){
        String sql ="DELETE FROM persona WHERE id="+id;
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
        return false;
    }
    
    
    
    
}
