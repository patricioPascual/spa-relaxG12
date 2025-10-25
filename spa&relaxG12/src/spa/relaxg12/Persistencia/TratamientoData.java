/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Producto;
import spa.relaxg12.Modelo.Tratamiento;
import java.sql.ResultSet;

/**
 *
 * @author patri
 */
public class TratamientoData {

     private static Connection con;
    
    
    public TratamientoData(Conexion miconexion) {
        this.con= miconexion.buscarConexion();
    }

    public TratamientoData() {
    }
    
    
    public void cargarTratamiento(Tratamiento tratamiento){
        String query = "INSERT INTO tratamiento (nombre,especialidad,detalle,duracion,costo,activo) VALUES (?,?,?,?,?,?) ";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tratamiento.getNombre());
            ps.setString(2, tratamiento.getEspecialidad());
            ps.setString(3, tratamiento.getDetalle());            
            ps.setInt(4, 30);
            ps.setDouble(5, tratamiento.getCosto());
            ps.setBoolean(6, true);
            int exito = ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idGenerado = rs.getInt(1); 
            
          
            tratamiento.setIdTratamiento(idGenerado); 
        }
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tratamiento agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar tratamiento");
        }
        
    }
    
    public void cargarTratamientoProducto( Producto producto, Tratamiento tratamiento){
        String query = "INSERT INTO tratamiento_producto (id_producto,idTratamiento) VALUES (?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, producto.getIdProducto());
            ps.setInt(2, tratamiento.getIdTratamiento());
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Listado  agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar listado");
        }
        
    }
    
   
}
