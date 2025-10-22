/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

/**
 *
 * @author Luza
 */
public class Tratamiento {

    private int idTratamiento;
    private String nombre;
    private String especialidad;
    private String detalle;
    private Integer duracion;
    private Double costo;
    private boolean activo;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String nombre, String especialidad, String detalle, Integer duracion, Double costo, boolean activo) {
        this.idTratamiento = idTratamiento;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.detalle = detalle;
        this.duracion = duracion;
        this.costo = costo;
        this.activo = activo;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamiento=" + idTratamiento + ", nombre=" + nombre + ", especialidad=" + especialidad + ", detalle=" + detalle + ", duracion=" + duracion + ", costo=" + costo + ", activo=" + activo + '}';
    }
    
    
}
