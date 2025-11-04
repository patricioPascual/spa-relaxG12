/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

import java.time.LocalDate;

import java.util.List;

/**
 *
 * @author Luza
 */
public class Sesion {

    private int idSesion;
    private Profesional profesional;
    private Consultorio consultorio;
    private Tratamiento tratamientos;
    private Instalacion instalacion;
    private LocalDate fechaInicio;
    private String hora;
    private double monto;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    private boolean estado;

    public Sesion() {
    }

    public Sesion(int idSesion, Profesional profesional, Consultorio consultorio, Tratamiento tratamientos, Instalacion instalacion, LocalDate fechaHoraInicio, String hora, boolean estado) {
        this.idSesion = idSesion;
        this.profesional = profesional;
        this.consultorio = consultorio;
        this.tratamientos = tratamientos;
        this.instalacion = instalacion;
        this.fechaInicio = fechaHoraInicio;
        this.hora = hora;
        this.estado = estado;
    }

    public Sesion(Profesional profesional, Consultorio consultorio, Tratamiento tratamientos, Instalacion instalacion, LocalDate fechaInicio, String hora, double monto) {
        this.profesional = profesional;
        this.consultorio = consultorio;
        this.tratamientos = tratamientos;
        this.instalacion = instalacion;
        this.fechaInicio = fechaInicio;
        this.hora = hora;
        this.monto= monto;
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

    public Tratamiento getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Tratamiento tratamientos) {
        this.tratamientos = tratamientos;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

   

    public String getHora() {
        return hora;
    }

    public void setFechaHoraFin(String hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sesion{" + "idSesion=" + idSesion + ", profesional=" + profesional + ", consultorio=" + consultorio + ", tratamientos=" + tratamientos + ", instalacion=" + instalacion + ", fechaHoraInicio=" + fechaInicio + ", fechaHoraFin=" + hora + ", estado=" + estado + '}';
    }

}
