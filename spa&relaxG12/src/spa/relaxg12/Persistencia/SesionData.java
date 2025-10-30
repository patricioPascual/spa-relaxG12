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
import spa.relaxg12.Modelo.Consultorio;
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

    public ArrayList buscarProfesionalesLibres(LocalDate fecha, String hora, String especialidad) throws SQLException {

        ArrayList<Profesional> listado = new ArrayList();

        try {
            String query = "SELECT idProfesional,matricula,nombre,apellido,telefono,especialidad,estado FROM profesional AS P WHERE P.especialidad=? AND P.idProfesional NOT IN(SELECT P.idProfesional FROM profesional AS P JOIN sesion AS S ON S.idProfesional= P.idProfesional WHERE S.fecha =? AND HoraInicio =?  AND P.especialidad =?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, especialidad);
            ps.setDate(2, Date.valueOf(fecha));
            ps.setString(3, hora);
            ps.setString(4, especialidad);
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

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Listado");

        }
        return listado;
    }

    public ArrayList buscarConsultoriosDisponibles(LocalDate fecha, String hora, String apto) {
        ArrayList<Consultorio> listado = new ArrayList();

        try {
            String query = "SELECT idConsultorio,numeroConsultorio,equipamiento,aptoPara,estado FROM consultorio AS C WHERE C.aptoPara=? AND C.idConsultorio NOT IN (SELECT C.idConsultorio FROM consultorio as C JOIN sesion AS S  on C.idConsultorio = S.idConsultorio AND S.fecha=? AND S.HoraInicio=? AND C.aptoPara=?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, apto);
            ps.setDate(2, Date.valueOf(fecha));
            ps.setString(3, hora);
            ps.setString(4, apto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Consultorio consultorio = new Consultorio();
                consultorio.setIdConsultorio(rs.getInt("idConsultorio"));
                consultorio.setNumeroConsultorio(rs.getString("numeroConsultorio"));
                consultorio.setAptoPara(rs.getString("aptoPara"));
                consultorio.setEquipamiento(rs.getString("equipamiento"));

                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                consultorio.setEstado(estado);
                listado.add(consultorio);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Listado");

        }
        return listado;
    }
}
