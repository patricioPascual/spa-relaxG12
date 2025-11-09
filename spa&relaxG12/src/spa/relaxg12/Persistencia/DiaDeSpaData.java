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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spa.relaxg12.Modelo.Cliente;

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

    public boolean guardarDiaDeSpa(DiaDeSpa diaDeSpa) {
        String query = "INSERT INTO diadespa (idCliente,fecha,preferencias,montoTotal,estado) VALUES (?,?,?,?,?) ";
        ResultSet rs = null;
        boolean valido = true;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, diaDeSpa.getCliente().getIdCliente());
            ps.setDate(2, Date.valueOf(diaDeSpa.getFecha()));

            ps.setString(3, diaDeSpa.getPreferencias());
            ps.setDouble(4, diaDeSpa.getMontoTotal());
            ps.setBoolean(5, true);
            int exito = ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);

                diaDeSpa.setIdDiaDeSpa(idGenerado);
            }
            ps.close();
            if (exito == 1) {
                valido = true;
            } else {
                valido = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Dia de Spa");
        }
        return valido;
    }

    public boolean cargarDiaDeSpaSesion(DiaDeSpa diaDeSpa, Sesion sesion) {
        String query = "INSERT INTO diadespa_sesion (idDiaDeSpa,idSesion) VALUES (?,?) ";
        boolean valido = true;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, diaDeSpa.getIdDiaDeSpa());
            ps.setInt(2, sesion.getIdSesion());
            int exito = ps.executeUpdate();
            ps.close();
            if (exito == 1) {
                valido = true;
            } else {
                valido = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar listado");
        }
        return valido;
    }

    public ArrayList buscarSesionesActivasPorDni(int dni) {
        ArrayList<Sesion> listado = new ArrayList<>();
        ConsultorioData consultorioData = new ConsultorioData();
        ProfesionalData profData = new ProfesionalData();
        TratamientoData tratData = new TratamientoData();
        try {
            String query = "SELECT * FROM sesion AS s JOIN diadespa_sesion AS ds ON ds.idSesion = s.idSesion JOIN diadespa AS d ON ds.idDiaDeSpa = d.idDiaDeSpa JOIN cliente AS c ON d.idCliente = c.idCliente WHERE c.dni = ? AND d.estado = 1 ORDER BY s.fecha ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sesion sesion = new Sesion();
                sesion.setIdSesion(rs.getInt("idSesion"));
                sesion.setConsultorio(consultorioData.buscarConsultorio(rs.getInt("idConsultorio")));
                sesion.setProfesional(profData.buscarProfesionalId(rs.getInt("idProfesional")));
                sesion.setMonto(rs.getDouble("monto"));
                sesion.setFechaHoraFin(rs.getString("hora"));
                sesion.setFechaInicio(rs.getDate("fecha").toLocalDate());
                sesion.setTratamientos(tratData.buscarTratramientoId(rs.getInt("idTratamiento")));
                sesion.setEstado(true);

                listado.add(sesion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar sesion");
        }
        return listado;
    }

    public ArrayList buscarSesionesInactivasPorDni(int dni) {
        ArrayList<Sesion> listado = new ArrayList<>();
        ConsultorioData consultorioData = new ConsultorioData();
        ProfesionalData profData = new ProfesionalData();
        TratamientoData tratData = new TratamientoData();
        try {
            String query = "SELECT * FROM sesion AS s JOIN diadespa_sesion AS ds ON ds.idSesion = s.idSesion JOIN diadespa AS d ON ds.idDiaDeSpa = d.idDiaDeSpa JOIN cliente AS c ON d.idCliente = c.idCliente WHERE c.dni = ? AND d.estado = 0 ORDER BY s.fecha ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sesion sesion = new Sesion();
                sesion.setIdSesion(rs.getInt("idSesion"));
                sesion.setConsultorio(consultorioData.buscarConsultorio(rs.getInt("idConsultorio")));
                sesion.setProfesional(profData.buscarProfesionalId(rs.getInt("idProfesional")));
                sesion.setMonto(rs.getDouble("monto"));
                sesion.setFechaHoraFin(rs.getString("hora"));
                sesion.setFechaInicio(rs.getDate("fecha").toLocalDate());
                sesion.setTratamientos(tratData.buscarTratramientoId(rs.getInt("idTratamiento")));
                sesion.setEstado(true);

                listado.add(sesion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar sesion");
        }
        return listado;
    }

    public ArrayList buscarSesionesActivasPorFecha(LocalDate fecha) {
        ArrayList<Sesion> listado = new ArrayList<>();
        ConsultorioData consultorioData = new ConsultorioData();
        ProfesionalData profData = new ProfesionalData();
        TratamientoData tratData = new TratamientoData();
        try {
            String query = "SELECT * FROM sesion s JOIN diadespa_sesion ds ON ds.idSesion=s.idSesion JOIN diadespa d ON d.idDiaDeSpa = ds.idDiaDeSpa WHERE d.fecha = ? AND d.estado = 1 ORDER BY d.idCliente";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sesion sesion = new Sesion();
                sesion.setIdSesion(rs.getInt("idSesion"));
                sesion.setConsultorio(consultorioData.buscarConsultorio(rs.getInt("idConsultorio")));
                sesion.setProfesional(profData.buscarProfesionalId(rs.getInt("idProfesional")));
                sesion.setMonto(rs.getDouble("monto"));
                sesion.setFechaHoraFin(rs.getString("hora"));
                sesion.setFechaInicio(rs.getDate("fecha").toLocalDate());
                sesion.setTratamientos(tratData.buscarTratramientoId(rs.getInt("idTratamiento")));
                sesion.setEstado(true);

                listado.add(sesion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar sesion");
        }
        return listado;
    }

    public ArrayList buscarSesionesInactivasPorFecha(LocalDate fecha) {
        ArrayList<Sesion> listado = new ArrayList<>();
        ConsultorioData consultorioData = new ConsultorioData();
        ProfesionalData profData = new ProfesionalData();
        TratamientoData tratData = new TratamientoData();
        try {
            String query = "SELECT * FROM sesion s JOIN diadespa_sesion ds ON ds.idSesion=s.idSesion JOIN diadespa d ON d.idDiaDeSpa = ds.idDiaDeSpa WHERE d.fecha = ? AND d.estado = 0 ORDER BY d.idCliente";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sesion sesion = new Sesion();
                sesion.setIdSesion(rs.getInt("idSesion"));
                sesion.setConsultorio(consultorioData.buscarConsultorio(rs.getInt("idConsultorio")));
                sesion.setProfesional(profData.buscarProfesionalId(rs.getInt("idProfesional")));
                sesion.setMonto(rs.getDouble("monto"));
                sesion.setFechaHoraFin(rs.getString("hora"));
                sesion.setFechaInicio(rs.getDate("fecha").toLocalDate());
                sesion.setTratamientos(tratData.buscarTratramientoId(rs.getInt("idTratamiento")));
                sesion.setEstado(true);

                listado.add(sesion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar sesion");
        }
        return listado;
    }

    public Cliente buscarClientePorSesion(int idSesion) {
        Cliente cliente = null;
        try {
            String query = "SELECT c.* FROM cliente c JOIN diadespa d ON d.idCliente = c.idCliente JOIN diadespa_sesion ds ON ds.idDiaDeSpa = d.idDiaDeSpa WHERE ds.idSesion = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idSesion);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setAfecciones(rs.getString("afecciones"));
                cliente.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente por sesión");
        }
        return cliente;
    }

    public void sesionFinalizada(int id) {
        try {
            String sql1 = "UPDATE spaentrededos.sesion SET estado = 0 WHERE idSesion = ?";
            String sql2 = "UPDATE spaentrededos.diadespa SET estado = 0 WHERE idDiaDeSpa = (SELECT idDiaDeSpa FROM spaentrededos.diadespa_sesion WHERE idSesion = ?)";

            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);

            ps1.setInt(1, id);
            ps2.setInt(1, id);

            int exito = ps1.executeUpdate();
            int exito2 = ps2.executeUpdate();
            if (exito == 1 && exito2 == 1) {
                JOptionPane.showMessageDialog(null, "Sesion finalizada!");
            }
            ps1.close();
            ps2.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja la sesion");
        }
    }

}
