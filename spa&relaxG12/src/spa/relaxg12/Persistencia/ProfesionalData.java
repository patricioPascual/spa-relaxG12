/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import spa.relaxg12.Modelo.Profesional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class ProfesionalData {

    private static Connection con;

    public ProfesionalData() {
    }

    public ProfesionalData(Conexion miconexion) {
        this.con = miconexion.buscarConexion();
    }

    public void crearProfesional(Profesional profesional) {
        String query = "INSERT INTO profesional (matricula,nombre,apellido,telefono,especialidad,estado) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, profesional.getMatricula());
            ps.setString(2, profesional.getNombre());
            ps.setString(3, profesional.getApellido());
            ps.setString(4, profesional.getTelefono());
            ps.setString(5, profesional.getEspecialidad());
            ps.setBoolean(6, true);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Profesional agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Cliente");
        }

    }

    public void modificarProfesional(Profesional p) {
        String query = "UPDATE profesional SET  matricula=?,nombre=?,apellido=?,telefono=?,especialidad=?  WHERE matricula=?  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p.getMatricula());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getEspecialidad());
            ps.setString(6, p.getMatricula());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Profesional modificado con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }

    public Profesional buscarProfesionalPorMatricula(String matricula) {
        Profesional prof = null;
        try {
            String sql = "SELECT * FROM profesional WHERE matricula=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prof = new Profesional();
                prof.setIdProfesional(rs.getInt("idProfesional"));
                prof.setMatricula(matricula);
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
                ps.close();

            } else {
                JOptionPane.showMessageDialog(null, "Profesional no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al acceder a la Base de Datos");
        }
        return prof;
    }

    public void darBajaProfesional(String matricula) {

        try {
            String sql = "UPDATE  profesional SET  estado = 0 WHERE matricula = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Baja realizada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }

    public void darAltaProfesional(String matricula) {

        try {
            String sql = "UPDATE  profesional SET  estado = 1 WHERE matricula = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alta realizada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }

    public ArrayList listarProfesionales() {
        ArrayList<Profesional> listado = new ArrayList();
        try {
            String query = "SELECT * FROM profesional";
            PreparedStatement ps = con.prepareStatement(query);
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

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }

    public ArrayList listarEspecialidades() {
        ArrayList<String> listado = new ArrayList<>();
        try {
            String query = "SELECT especialidad FROM profesional";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            String especialidad;
            while (rs.next()) {
                especialidad = rs.getString("especialidad");
                listado.add(especialidad);
                ps.close();
            }
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }

    public ArrayList listarProfesionalesPorEspecialidad(String especialidad) {
        ArrayList<Profesional> listado = new ArrayList();
        try {
            String query = "SELECT * FROM profesional WHERE especialidad=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, especialidad);
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

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }

    public ArrayList listarProfesionalesActivos() {
        ArrayList<Profesional> listado = new ArrayList();
        try {
            String query = "SELECT * FROM profesional WHERE estado=1";
            PreparedStatement ps = con.prepareStatement(query);
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

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }

    public ArrayList listarProfesionalesInactivos() {
        ArrayList<Profesional> listado = new ArrayList();
        try {
            String query = "SELECT * FROM profesional WHERE estado=0";
            PreparedStatement ps = con.prepareStatement(query);
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

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }
}
