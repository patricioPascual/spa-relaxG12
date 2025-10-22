/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

/**
 *
 * @author patri
 */
public class Cliente {
    private int id_cliente;
    private int dni;
    private String nombre; 
    private String apellido;
    private long telefono; 
    private String afecciones;
    private boolean estado;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String apellido, long telefono, String afecciones, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.afecciones = afecciones;
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getAfecciones() {
        return afecciones;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
}
