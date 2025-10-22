/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luza
 */
public class Sesion {

    private int idSesion;
    private int idMasajista;
    private int idConsultorio;
    private Tratamiento tratamiento;
    private List<Instalaciones> instalacion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private boolean estado;

    public Sesion() {
    }

    public Sesion(int idSesion, int idMasajista, int idConsultorio, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, boolean estado) {
        this.idSesion = idSesion;
        this.idMasajista = idMasajista;
        this.idConsultorio = idConsultorio;
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

    public int getIdMasajista() {
        return idMasajista;
    }

    public void setIdMasajista(int idMasajista) {
        this.idMasajista = idMasajista;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public List<Instalaciones> getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(List<Instalaciones> instalacion) {
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
        return "Sesion{" + "idSesion=" + idSesion + ", idMasajista=" + idMasajista + ", idConsultorio=" + idConsultorio + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", estado=" + estado + '}';
    }

}
