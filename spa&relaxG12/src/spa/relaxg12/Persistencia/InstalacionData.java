package spa.relaxg12.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Instalacion;

public class InstalacionData {

    private static Connection con;

    public InstalacionData(Conexion miconexion) {
        InstalacionData.con = miconexion.buscarConexion();
    }
    
    public InstalacionData() {
    }
    
    public boolean guardarInstalacion(Instalacion instalacion) {
        String query = "INSERT INTO instalacion (nombre, detalleUso, precioPor30min, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, instalacion.getNombre());
            ps.setString(2, instalacion.getDetalleUso());
            Double precio = instalacion.getPrecioPor30min();
            ps.setDouble(3, precio == null ? 0.0 : precio);
            ps.setBoolean(4, instalacion.isEstado());

            int filas = ps.executeUpdate();
            return filas > 0 ;
        } catch (SQLException ex) {
            return false;
        }
    }

    public void actualizarInstalacion(Instalacion instalacion) {
        String query = "UPDATE instalacion SET nombre = ?, detalleUso = ?, precioPor30min = ?, estado = ? WHERE idInstalacion = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, instalacion.getNombre());
            ps.setString(2, instalacion.getDetalleUso());
            ps.setDouble(3, instalacion.getPrecioPor30min() == null ? 0.0 : instalacion.getPrecioPor30min());
            ps.setBoolean(4, instalacion.isEstado());
            ps.setInt(5, instalacion.getIdInstalacion());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Instalación actualizada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la instalación a actualizar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la instalación: " + ex.getMessage());
        }
    }

    public void eliminarInstalacion(int id) {
        String query = "UPDATE instalacion SET estado = 0 WHERE idInstalacion = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Instalación eliminada (marcada como Inactiva).");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la instalación a eliminar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la instalación: " + ex.getMessage());
        }
    }

    public Instalacion buscarInstalacionPorId(int id) {
        String query = "SELECT * FROM instalacion WHERE idInstalacion = ?";
        Instalacion inst = null;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    inst = new Instalacion();
                    inst.setIdInstalacion(rs.getInt("idInstalacion"));
                    inst.setNombre(rs.getString("nombre"));
                    inst.setDetalleUso(rs.getString("detalleUso"));
                    inst.setPrecioPor30min(rs.getDouble("precioPor30min"));
                    inst.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar instalación: " + ex.getMessage());
        }
        return inst;
    }

    public List<Instalacion> listarInstalaciones() {
        String query = "SELECT * FROM instalacion";
        List<Instalacion> lista = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Instalacion inst = new Instalacion();
                inst.setIdInstalacion(rs.getInt("idInstalacion"));
                inst.setNombre(rs.getString("nombre"));
                inst.setDetalleUso(rs.getString("detalleUso"));
                inst.setPrecioPor30min(rs.getDouble("precioPor30min"));
                inst.setEstado(rs.getBoolean("estado"));
                lista.add(inst);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar instalacion: " + ex.getMessage());
        }
        return lista;
    }

    public List<Instalacion> listarInstalacionesActivas() {
        String query = "SELECT * FROM instalacion WHERE estado = 1";
        List<Instalacion> lista = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Instalacion inst = new Instalacion();
                inst.setIdInstalacion(rs.getInt("idInstalacion"));
                inst.setNombre(rs.getString("nombre"));
                inst.setDetalleUso(rs.getString("detalleUso"));
                inst.setPrecioPor30min(rs.getDouble("precioPor30min"));
                inst.setEstado(rs.getBoolean("estado"));
                lista.add(inst);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar instalaciones activas: " + ex.getMessage());
        }
        return lista;
    }
}