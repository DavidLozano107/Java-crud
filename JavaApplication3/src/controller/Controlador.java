package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Vista;
import model.Persona;
import model.LibreriaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.Libros;
import view.AggLibro;
import view.Usuario;
import view.aggCliente;

public class Controlador implements ActionListener {

    LibreriaDAO dao = new LibreriaDAO();
    Persona p = new Persona();
    Vista vista = new Vista();
    Usuario usuarioView = new Usuario();

    Libros l = new Libros();
    AggLibro agregarLibro = new AggLibro();

    aggCliente agregarCliente = new aggCliente();

    DefaultTableModel modelo1 = new DefaultTableModel();
    
    DefaultTableModel modelo2 = new DefaultTableModel();
    

    public Controlador(Vista v) {
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnAlta.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnAggCliente.addActionListener(this);
        this.vista.btnUsers.addActionListener(this);

        //Agregar nuevo Cliente
        this.agregarCliente.btnBuscar.addActionListener(this);
        
        //Users btnUsers
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == vista.btnAgregar) {
            AggLibro libronew = new AggLibro();
            libronew.setVisible(true);
            vista.dispose();
        }

        if (e.getSource() == vista.btnEliminar) {
            deleteTablaLibro();
           limpiarTablaLibros();
           limpiarTablaClientes();
           listarLibros(vista.tablaLibros);

        }

        if (e.getSource() == vista.btnAlta) {
            altaEstadoLibro();
            limpiarTablaClientes();
            listarClientes(vista.tablaClientes);
        }
//Agregrar cliente        
        if (e.getSource() == vista.btnAggCliente) {
            aggCliente cliente = new aggCliente();
            cliente.setVisible(true);
            vista.dispose();
        }
        
        if(e.getSource() ==vista.btnUsers){
            Usuario u = new Usuario();
            Controlador2 c2 = new Controlador2(u);
            u.setVisible(true);
            vista.dispose();
        }

    }
    
    
    
    
    
    
    
    
    

    public void listarLibros(JTable tabla) {
        modelo1 = (DefaultTableModel) tabla.getModel();
        List<Libros> lista = dao.listarLibros();
        Object[] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getTitulo();
            object[2] = lista.get(i).getEditorial();
            object[3] = lista.get(i).getAutor();
            modelo1.addRow(object);
        }
        vista.tablaLibros.setModel(modelo1);
        
        listarClientes(vista.tablaClientes);

    }

    public void listarClientes(JTable tabla) {
        modelo2 = (DefaultTableModel) tabla.getModel();
        List<Clientes> lista = dao.listarClientes();
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getIdPedido();
            object[1] = lista.get(i).getNombres();
            object[2] = lista.get(i).getCorreo();
            object[3] = lista.get(i).getIdLibroPrestado();
            object[4] = lista.get(i).getEstado();
            modelo2.addRow(object);
        }
        vista.tablaClientes.setModel(modelo2);

    }


//Tabla Libro
    public void limpiarTablaClientes() {
        for (int i = 0; i < vista.tablaClientes.getRowCount(); i++) {
            modelo2.removeRow(i);
            i = i - 1;
        }
        
    }
    
    public void limpiarTablaLibros(){
         for (int i = 0; i < vista.tablaLibros.getRowCount(); i++) {
            modelo1.removeRow(i);
            i = i - 1;
        }
    }
    
       

    public void deleteTablaLibro() {
        int fila = vista.tablaLibros.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un Libro");
        } else {
            int id = Integer.parseInt((String) vista.tablaLibros.getValueAt(fila, 0).toString());
            dao.delete(id);
            JOptionPane.showMessageDialog(vista, "Libro eliminado");
        }
    }

//----------------------------------------------------------------------------------
    public void altaEstadoLibro() {
        int fila = vista.tablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario");
        } else {
            int id = Integer.parseInt((String) vista.tablaClientes.getValueAt(fila, 0).toString());
            dao.ActualizarEstado(id);
            JOptionPane.showMessageDialog(vista, "Usuario con el " + id + " Actualizado");
        }
    }
    
    
    //Agregrar Cliente 
    public void buscarCliente(){
       int idCli = Integer.parseInt((String) agregarCliente.txtIdBuscar.getText());
       JOptionPane.showMessageDialog(agregarCliente, "El id es: " + idCli);
      
            
    }

}
