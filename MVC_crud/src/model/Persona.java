package model;

public class Persona {
    
    int id;
    String nom;
    String correo;
    String tel;
    
    
    public Persona(int id, String nom, String correo, String tel){
        this.id = id;
        this.nom = nom;
        this.correo = correo;
        this.tel = tel;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
   
    
    
}
