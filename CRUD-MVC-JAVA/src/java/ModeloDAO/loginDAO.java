package ModeloDAO;

import Config.Conexion;
import Modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class loginDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int nivel;
    User user = new User();

    public int loguear(String correo, String contra) {
        String sql = "SELECT nivel FROM user WHERE correo = '" + correo + "' AND contra = '" + contra + "' ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                 nivel = rs.getInt(1);  
            }
            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return nivel;
    }
}
