/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Producto;
import spa.relaxg12.Modelo.Tratamiento;
import java.sql.ResultSet;

/**
 *
 * @author patri
 */

 
public class TratamientoData {

     private static Connection con;
    
    
    public TratamientoData(Conexion miconexion) {
        this.con= miconexion.buscarConexion();
    }

    public TratamientoData() {
    }
    
    
    public void guardarTratamiento(Tratamiento tratamiento){
        String query = "INSERT INTO tratamiento (nombre,especialidad,detalle,duracion,costo,activo) VALUES (?,?,?,?,?,?) ";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tratamiento.getNombre());
            ps.setString(2, tratamiento.getEspecialidad());
            ps.setString(3, tratamiento.getDetalle());            
            ps.setInt(4, 30);
            ps.setDouble(5, tratamiento.getCosto());
            ps.setBoolean(6, true);
            int exito = ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idGenerado = rs.getInt(1); 
            
          
            tratamiento.setIdTratamiento(idGenerado); 
        }
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tratamiento agregado con exito");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar tratamiento");
        }
        
    }
    
    public boolean cargarTratamientoProducto( Producto producto, Tratamiento tratamiento){
        boolean guardado=false;
        String query = "INSERT INTO tratamiento_producto (id_producto,idTratamiento) VALUES (?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, producto.getIdProducto());
            ps.setInt(2, tratamiento.getIdTratamiento());
            
            int exito = ps.executeUpdate();
           
               
                return true;
            

         
        } catch (SQLException ex) {
           return false;
        }
       
    }
    
   public  ArrayList listarTratamientos(String especialidad) {
        ArrayList<Tratamiento> listado = new ArrayList();
        try {
            String query = "SELECT * FROM tratamiento WHERE especialidad=? AND activo=1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, especialidad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setIdTratamiento(rs.getInt("idTratamiento"));
                tratamiento.setNombre(rs.getString("nombre"));
                tratamiento.setEspecialidad(rs.getString("especialidad"));
                tratamiento.setDetalle(rs.getString("detalle"));
                tratamiento.setDuracion(30);
                tratamiento.setCosto((Double)rs.getDouble("costo"));
                
                tratamiento.setActivo(true);
                listado.add(tratamiento);
                ps.close();
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }

        return listado;
    }
     public  void modificarTratamiento(Tratamiento tratamiento) {
       
        String query = "UPDATE  tratamiento SET  nombre=?, especialidad=?,detalle=?,duracion=?,costo=?,activo=?  WHERE nombre=?  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, tratamiento.getNombre());
            ps.setString(2, tratamiento.getEspecialidad());
            ps.setString(3, tratamiento.getDetalle());
            ps.setInt(4, (tratamiento.getDuracion()));
            ps.setDouble(5, tratamiento.getCosto());
            ps.setBoolean(6, true);
            ps.setString(7, tratamiento.getNombre());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "tratamiento modificado con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }

    }
      public void bajaTratamiento(Tratamiento tratamiento) {

        try {
            String sql = "UPDATE tratamiento SET  activo = 0 WHERE nombre = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tratamiento.getNombre());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Baja realizada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }
 public void altaTratamiento(Tratamiento tratamiento) {

        try {
            String sql = "UPDATE tratamiento SET  activo = 1 WHERE nombre = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tratamiento.getNombre());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alta realizada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Accer a la Base de datos");
        }
    }
 public  Tratamiento buscarTratramiento(String nombre) {

        Tratamiento tratamiento = null;
        try {
            String sql = "SELECT * FROM tratamiento WHERE nombre=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tratamiento = new Tratamiento();
                tratamiento.setIdTratamiento(rs.getInt("idTratamiento"));
                tratamiento.setNombre(rs.getString("nombre"));
                tratamiento.setEspecialidad(rs.getString("especialidad"));
                tratamiento.setDetalle(rs.getString("detalle"));
                tratamiento.setDuracion(rs.getInt("duracion"));
                tratamiento.setCosto(rs.getDouble("costo"));
                int estadoInt = rs.getInt("activo");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                tratamiento.setActivo(estado);
                ps.close();
              
            } else {
                JOptionPane.showMessageDialog(null, "tratamiento no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al acceder a la Base de Datos");
        }

        return tratamiento;

    }

   public  Tratamiento buscarTratramientoId(int id) {

        Tratamiento tratamiento = null;
        try {
            String sql = "SELECT * FROM tratamiento WHERE idTratamiento=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tratamiento = new Tratamiento();
                tratamiento.setIdTratamiento(rs.getInt("idTratamiento"));
                tratamiento.setNombre(rs.getString("nombre"));
                tratamiento.setEspecialidad(rs.getString("especialidad"));
                tratamiento.setDetalle(rs.getString("detalle"));
                tratamiento.setDuracion(rs.getInt("duracion"));
                tratamiento.setCosto(rs.getDouble("costo"));
                int estadoInt = rs.getInt("activo");
                boolean estado;
                if (estadoInt == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
                tratamiento.setActivo(estado);
                ps.close();
              
            } else {
                JOptionPane.showMessageDialog(null, "tratamiento no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al acceder a la Base de Datos");
        }

        return tratamiento;
   }
    
}
