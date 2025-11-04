/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import spa.relaxg12.Modelo.DiaDeSpa;
import spa.relaxg12.Modelo.Sesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import spa.relaxg12.Modelo.Tratamiento;
import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author patri
 */
public class DiaDeSpaData {
private static Connection con;

    public DiaDeSpaData(Conexion miconexion) {
        this.con = miconexion.buscarConexion();
    }


    public DiaDeSpaData() {
    }
    
    
      public void guardarDiaDeSpa(DiaDeSpa diaDeSpa){
        String query = "INSERT INTO diadespa (idCliente,fecha,preferencias,montoTotal,estado) VALUES (?,?,?,?,?) ";
        ResultSet rs =null;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, diaDeSpa.getCliente().getIdCliente());
            ps.setDate(2, Date.valueOf(diaDeSpa.getFecha()) );
         
            ps.setString(3, diaDeSpa.getPreferencias());
            ps.setDouble(4, diaDeSpa.getMontoTotal());
            ps.setBoolean(5, true);
            int exito = ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idGenerado = rs.getInt(1); 
            
          
            diaDeSpa.setIdDiaDeSpa(idGenerado); 
        }
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dia De Spa agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Dia de Spa");
        }
        
    }
      public void cargarDiaDeSpaSesion( DiaDeSpa diaDeSpa, Sesion sesion) {
        String query = "INSERT INTO diadespa_sesion (idDiaDeSpa,idSesion) VALUES (?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, diaDeSpa.getIdDiaDeSpa());
            ps.setInt(2, sesion.getIdSesion());
            
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
