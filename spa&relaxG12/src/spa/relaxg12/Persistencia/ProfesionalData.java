/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import spa.relaxg12.Modelo.Profesional;

/**
 *
 * @author Luza
 */
public class ProfesionalData {

    private static Connection con;

    public ProfesionalData() {
    }

    public ProfesionalData(Conexion miconexion) {
        ProfesionalData.con = miconexion.buscarConexion();
    }

    public void guardarProfesional(Profesional profesional) {
        String query = "INSERT INTO profesional (matricula,nombreCompleto,telefono,especialidad,estado) VALUES (?,?,?,?,?) ";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, profesional.getMatricula());
            ps.setString(2, profesional.getNombreCompleto());
            ps.setString(3, profesional.getTelefono());
            ps.setString(4, profesional.getEspecialidad());          
            ps.setBoolean(5, true);
            int exito = ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);

                profesional.setIdProfesional(idGenerado);
            }
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Profesional agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Profesional");
        }

    }

}
