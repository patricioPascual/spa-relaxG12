/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Tratamiento;

/**
 *
 * @author patri
 */
public class TratamientoData {

     private static Connection con;
    
    
    public TratamientoData() {
    }
    
    
    public void cargarTratamiento(Tratamiento tratamiento){
        String query = "INSERT INTO tratamiento (nombre,especialidad,detalle,duracion,costo,estado) VALUES (?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, tratamiento.getNombre());
            ps.setString(2, tratamiento.getEspecialidad());
            ps.setString(3, tratamiento.getDetalle());            
            ps.setInt(4, 30);
            ps.setDouble(5, tratamiento.getCosto());
            ps.setBoolean(6, true);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tratamiento agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar tratamiento");
        }
        
    }
    
   
}
