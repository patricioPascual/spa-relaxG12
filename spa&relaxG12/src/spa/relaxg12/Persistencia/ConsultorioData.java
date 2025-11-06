/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    public ArrayList listarConsultoriosActivos() {
        ArrayList<Consultorio> listado = new ArrayList();
        try {
            String query = "SELECT * FROM consultorio WHERE estado=1";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consultorio consultorio = new Consultorio();
                consultorio.setIdConsultorio(rs.getInt("idConsultorio"));
                consultorio.setEquipamiento(rs.getString("equipamiento"));
                consultorio.setNumeroConsultorio(rs.getString("numeroConsultorio"));
                consultorio.setAptoPara(rs.getString("aptoPara"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                consultorio.setEstado(estado);
                listado.add(consultorio);
                ps.close();
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }

    public Consultorio buscarConsultorio(int id) {
        Consultorio consultorio = null;
        try {         
            String query = "SELECT * FROM consultorio WHERE idConsultorio = ?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                consultorio = new Consultorio();
                consultorio.setIdConsultorio(rs.getInt("idConsultorio"));
                consultorio.setEquipamiento(rs.getString("equipamiento"));
                consultorio.setNumeroConsultorio(rs.getString("numeroConsultorio"));
                consultorio.setAptoPara(rs.getString("aptoPara"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                consultorio.setEstado(estado);

                ps.close();
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return consultorio;
    }

    public ArrayList listarConsultoriosInactivos() {
        ArrayList<Consultorio> listado = new ArrayList();
        try {
            String query = "SELECT * FROM consultorio WHERE estado=0";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consultorio consultorio = new Consultorio();
                consultorio.setIdConsultorio(rs.getInt("idConsultorio"));
                consultorio.setEquipamiento(rs.getString("equipamiento"));
                consultorio.setNumeroConsultorio(rs.getString("numeroConsultorio"));
                consultorio.setAptoPara(rs.getString("aptoPara"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                consultorio.setEstado(estado);
                listado.add(consultorio);
                ps.close();
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }
}
