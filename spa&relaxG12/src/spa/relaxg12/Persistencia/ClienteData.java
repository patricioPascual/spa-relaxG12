/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author patri
 */
public class ClienteData {
    
    
     private static Connection con;

    public ClienteData() {
    }

     
    public ClienteData(Conexion miconexion) {
        this.con= miconexion.buscarConexion();
    }

     
    public void crearCliente(Cliente cliente){
         String query = "INSERT INTO clientes (dni,apellido,nombre,telefono,afecciones,estado) VALUES (?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getNombre());
            ps.setLong(4,cliente.getTelefono());
            ps.setString(5, cliente.getAfecciones());
            ps.setBoolean(6, true);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Alumno");
        }

    }
    }
     

