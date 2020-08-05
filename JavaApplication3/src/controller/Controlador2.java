/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import model.PersonaDAO;
import view.Usuario;
import view.Vista;

/**
 *
 * @author david
 */


public class Controlador2 implements ActionListener{
    
    PersonaDAO dao = new PersonaDAO();
    Persona p= new Persona();
    Usuario u = new Usuario();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador2 (Usuario user){
        this.u=user;
        this.u.btnListar.addActionListener(this);
        this.u.btnGuardar.addActionListener(this);
        this.u.btnEditar.addActionListener(this);
        this.u.btnOk.addActionListener(this);
        this.u.btnEliminar.addActionListener(this);
        listar(u.tabla);
    }

    @Override
  public void actionPerformed(ActionEvent e) {
        if (e.getSource() == u.btnListar) {
           limpiarTabla();
           listar(u.tabla);
        }
        
        if(e.getSource() == u.btnGuardar){
            agregar();
            limpiarTabla();
            listar(u.tabla);
        }
        
        if(e.getSource()==u.btnEditar){
            int fila = u.tabla.getSelectedRow();
            if(fila ==1){
                JOptionPane.showMessageDialog(u, "Debe de seleccionar una fila");
            } else {
                int id=Integer.parseInt((String)u.tabla.getValueAt(fila, 0).toString());
                String nom=(String)u.tabla.getValueAt(fila, 1);
                String correo=(String)u.tabla.getValueAt(fila, 2);
                String tel=(String)u.tabla.getValueAt(fila,3);
                
                u.txtId.setText(""+id);
                u.txtNombres.setText(nom);
                u.txtCorreo.setText(correo);
                u.txtTelefono.setText(tel);
            }
       
        }
            if(e.getSource()==u.btnOk){
                Actualizar();
                limpiarTabla();
                listar(u.tabla);
            }
            
            if(e.getSource() == u.btnEliminar){
                delete();
                
                limpiarTabla();
                listar(u.tabla);
                
            }
     
}
   
public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Persona> lista = dao.listar();
        Object[] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNom();
            object[2] = lista.get(i).getCorreo();
            object[3] = lista.get(i).getTel();
            modelo.addRow(object);
        }
        u.tabla.setModel(modelo);
  
}

public void agregar(){
    String nom = u.txtNombres.getText();
    String correo=u.txtCorreo.getText();
    String tel=u.txtTelefono.getText();
    
    p.setNom(nom);
    p.setCorreo(correo);
    p.setTel(tel);
    
    int r=dao.agregar(p);
    
    if(r==1){
        JOptionPane.showMessageDialog(u, "Usuario agregado correctamente");
    }else{
        JOptionPane.showMessageDialog(u, "Error");
    }
    
}

public void Actualizar() {
    int id=Integer.parseInt(u.txtId.getText());
    
    String nom=u.txtNombres.getText();
    
    String correo=u.txtCorreo.getText();
    
    String tel=u.txtTelefono.getText();
    
    p.setId(id);
    p.setNom(nom);
    p.setCorreo(correo);
    p.setTel(tel);
    
    int r = dao.actualizar(p);
    
    if(r==1){
        JOptionPane.showMessageDialog(u, "Usuario actualizado con éxito");
    }else{
        JOptionPane.showMessageDialog(u, "Error");
    }
    
}

public void limpiarTabla(){
    for(int i=0; i < u.tabla.getRowCount(); i++){
        modelo.removeRow(i);
        i=i-1;
    }
}


public void delete(){
    int fila = u.tabla.getSelectedRow();
    if(fila==-1){
        JOptionPane.showMessageDialog(u, "Debe seleccionar un usuario");
    }else{
        int id=Integer.parseInt((String)u.tabla.getValueAt(fila,0).toString() );
        dao.delete(id);
        JOptionPane.showMessageDialog(u, "Usuario eliminado");
    }
}

}

