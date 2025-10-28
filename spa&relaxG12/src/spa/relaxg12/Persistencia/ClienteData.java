/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class ClienteData {

    private static Connection con;

    public ClienteData() {
    }

    public ClienteData(Conexion miconexion) {
        this.con = miconexion.buscarConexion();
    }

    public void crearCliente(Cliente cliente) {
        String query = "INSERT INTO cliente (dni,nombre,apellido,edad,telefono,afecciones,estado) VALUES (?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());            
            ps.setInt(4, cliente.getEdad());
            ps.setLong(5, cliente.getTelefono());
            ps.setString(6, cliente.getAfecciones());
            ps.setBoolean(7, true);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Cliente agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Cliente");
        }

    }

    public void modificarCliente(Cliente c) {
        String query = "UPDATE cliente SET  dni=?,nombre=?,apellido=?,edad=?,telefono=?,afecciones=?  WHERE dni=?  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getNombre());
            ps.setInt(4, c.getEdad());
            ps.setLong(5, c.getTelefono());
            ps.setString(6, c.getAfecciones());
            ps.setInt(7, c.getDni());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Cliente modificado con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }
    
    public Cliente buscarClienteDni(int dni) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE dni=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(dni);
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setAfecciones(rs.getString("afecciones"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                cliente.setEstado(estado);
                ps.close();

            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al acceder a la Base de Datos");
        }
        return cliente;
    }
    
    public void darBajaCliente(int dni) {

        try {
            String sql = "UPDATE  cliente SET  estado = 0 WHERE dni = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Baja realizada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }

    public void darAltaCliente(int dni) {

        try {
            String sql = "UPDATE  cliente SET  estado = 1 WHERE dni = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alta realizada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }

    public ArrayList listarClientes() {
        ArrayList<Cliente> listado = new ArrayList();
        try {
            String query = "SELECT * FROM cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setAfecciones(rs.getString("afecciones"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                cliente.setEstado(estado);
                listado.add(cliente);
                ps.close();
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }

    public ArrayList listarClientesActivos() {
        ArrayList<Cliente> listado = new ArrayList();
        try {
            String query = "SELECT * FROM cliente WHERE estado=1";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setAfecciones(rs.getString("afecciones"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                cliente.setEstado(estado);
                listado.add(cliente);
                ps.close();
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }
    
    public ArrayList listarClientesInactivos() {
        ArrayList<Cliente> listado = new ArrayList();
        try {
            String query = "SELECT * FROM cliente WHERE estado=0";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setAfecciones(rs.getString("afecciones"));
                int estadoInt = rs.getInt("estado");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                cliente.setEstado(estado);
                listado.add(cliente);
                ps.close();
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }
    
}
