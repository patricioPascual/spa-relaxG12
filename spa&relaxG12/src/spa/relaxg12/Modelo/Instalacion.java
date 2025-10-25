/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

/**
 *
 * @author Luza
 */
public class Instalacion {
    private int idInstalacion;
    private String nombre;
    private String detalleUso;
    private Double precioPor30min;
    private boolean estado;

    public Instalacion() {
    }

    public Instalacion(String nombre, String detalleUso, Double precioPor30min, boolean estado) {
        this.nombre = nombre;
        this.detalleUso = detalleUso;
        this.precioPor30min = precioPor30min;
        this.estado = estado;
    }

    public Instalacion(int idInstalacion, String nombre, String detalleUso, Double precioPor30min, boolean estado) {
        this.idInstalacion = idInstalacion;
        this.nombre = nombre;
        this.detalleUso = detalleUso;
        this.precioPor30min = precioPor30min;
        this.estado = estado;
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalleUso() {
        return detalleUso;
    }

    public void setDetalleUso(String detalleUso) {
        this.detalleUso = detalleUso;
    }

    public Double getPrecioPor30min() {
        return precioPor30min;
    }

    public void setPrecioPor30min(Double precioPor30min) {
        this.precioPor30min = precioPor30min;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Instalaciones{" + "idInstalacion=" + idInstalacion + ", nombre=" + nombre + ", detalleUso=" + detalleUso + ", precioPor30min=" + precioPor30min + ", estado=" + estado + '}';
    }
    
}
