/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

import java.time.LocalDateTime;

import java.util.List;

/**
 *
 * @author Luza
 */
public class Sesion {

    private int idSesion;
    private Profesional profesional;
    private Consultorio consultorio;
    private List<Tratamiento> tratamientos;
    private List<Instalacion> instalacion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private boolean estado;

    public Sesion() {
    }

    public Sesion(int idSesion, Profesional profesional, Consultorio consultorio, List<Tratamiento> tratamientos, List<Instalacion> instalacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, boolean estado) {
        this.idSesion = idSesion;
        this.profesional = profesional;
        this.consultorio = consultorio;
        this.tratamientos = tratamientos;
        this.instalacion = instalacion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.estado = estado;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public List<Instalacion> getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(List<Instalacion> instalacion) {
        this.instalacion = instalacion;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sesion{" + "idSesion=" + idSesion + ", profesional=" + profesional + ", consultorio=" + consultorio + ", tratamientos=" + tratamientos + ", instalacion=" + instalacion + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", estado=" + estado + '}';
    }

}
