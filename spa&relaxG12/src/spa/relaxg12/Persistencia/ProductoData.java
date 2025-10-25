/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import spa.relaxg12.Modelo.Cliente;
import spa.relaxg12.Modelo.Producto;

/**
 *
 * @author patri
 */
public class ProductoData {
    
     private static Connection con;

    public ProductoData(Conexion miconexion) {
        this.con= miconexion.buscarConexion();
    }

    public ProductoData() {
    }
    
     public ArrayList cargarProductos(){
         
        ArrayList<Producto> listado = new ArrayList();
        try {
            String query = "SELECT nombre,detalle,stock FROM producto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setDetalle(rs.getString("detalle"));
                producto.setStock(rs.getInt("stock"));
               
            }      
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        return listado;
    }

     
     
}
