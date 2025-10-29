/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Profesional;

/**
 *
 * @author patri
 */
public class SesionData {

    private static Connection con;

    public SesionData(Conexion miconexion) {
        this.con = miconexion.buscarConexion();
    }

    public SesionData() {
    }

    public ArrayList buscarProfesionalesLibres(LocalDate fecha ,String hora,String especialidad) throws SQLException {

        ArrayList<Profesional> listado = new ArrayList();
 
       
        try {
            String query = "SELECT * from profesional - (SELECT idProfesional FROM sesion AS S JOIN profesional AS P  WHERE S.fecha =? AND HoraInicio =?  P.especialidad =?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1,Date.valueOf(fecha) );
            ps.setString(2, especialidad);
            ResultSet rs = ps.executeQuery();
            Profesional prof;
            while (rs.next()) {
                prof = new Profesional();
                prof.setIdProfesional(rs.getInt("idProfesional"));
                prof.setMatricula(rs.getString("matricula"));
                prof.setApellido(rs.getString("apellido"));
                prof.setNombre(rs.getString("nombre"));
                prof.setTelefono(rs.getString("telefono"));
                prof.setEspecialidad(rs.getString("especialidad"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                prof.setEstado(estado);
                listado.add(prof);
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Listado");

        }
        return listado;
    }
    
}
