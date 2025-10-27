/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

/**
 *
 * @author Luza
 */
public class Profesional {

    private int idProfesional;
    private String matricula;
    private String nombreCompleto;
    private String telefono;
    private String especialidad;
    private boolean estado;

    public Profesional() {
    }

    public Profesional(String matricula, String nombreCompleto, String telefono, String especialidad, boolean estado) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Profesional(int idProfesional, String matricula, String nombreCompleto, String telefono, String especialidad, boolean estado) {
        this.idProfesional = idProfesional;
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Profesional{" + "idProfesional=" + idProfesional + ", matricula=" + matricula + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }

}
