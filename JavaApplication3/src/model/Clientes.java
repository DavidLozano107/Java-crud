
package model;

public class Clientes {
    int idPedido;
    String nombres; 
    String correo;
    String telefono;
    int idLibro;
    int idPersona;
    String NombreLibroPrestado;
    String estado;

    public String getIdLibroPrestado() {
        return NombreLibroPrestado;
    }

    public void setNombreLibroPrestado(String NombreLibroPrestado) {
        this.NombreLibroPrestado = NombreLibroPrestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Clientes(){
        
    }
    
    public Clientes(int idPedido,String nombres, String correo, String telefono, int idLibro, int idPersona){
        this.idPedido = idPedido;
        this.nombres = nombres;
        this.correo = correo;
        this.telefono = telefono;
        this.idLibro = idLibro;
        this.idPersona = idPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
    
}
