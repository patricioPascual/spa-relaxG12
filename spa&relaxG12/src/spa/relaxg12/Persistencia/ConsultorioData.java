/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import spa.relaxg12.Modelo.Consultorio;

/**
 *
 * @author Luza
 */
public class ConsultorioData {

    private static Connection con;

    public ConsultorioData(Conexion miconexion) {
        ConsultorioData.con = miconexion.buscarConexion();
    }

    public ConsultorioData() {
    }

    public boolean guardarConsultorio(Consultorio consultorio) {
        String query = "INSERT INTO consultorio (numeroConsultorio, equipamiento, aptoPara, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, consultorio.getNumeroConsultorio());
            ps.setString(2, consultorio.getEquipamiento());
            ps.setString(3, consultorio.getAptoPara());
            ps.setBoolean(4, true);

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean bajaConsultorio(String numeroConsultorio) {
        String query = "UPDATE consultorio SET estado = 0 WHERE numeroConsultorio = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, numeroConsultorio);

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean altaConsultorio(String numeroConsultorio) {
        String query = "UPDATE consultorio SET estado = 1 WHERE numeroConsultorio = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, numeroConsultorio);

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean modificarConsultorio(Consultorio consultorio) {
        String query = "UPDATE consultorio SET  equipamiento=?,aptoPara=?,estado=? WHERE numeroConsultorio= ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, consultorio.getEquipamiento());
            ps.setString(2, consultorio.getAptoPara());
            ps.setBoolean(3, true);
            ps.setString(4, consultorio.getNumeroConsultorio());
            
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

}
