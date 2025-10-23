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
public class DiaDeSpa {
  private int idDiaDeSpa;
  private Cliente cliente;  
  private LocalDateTime fechaHoraCreacion; /* Podemos usar ZonedDataTime*/
  private List<Sesion> sesiones;
  private String preferencias;
  private Double montoTotal;  
  private boolean estado;

    public DiaDeSpa() {
    }

    public DiaDeSpa(int idDiaDeSpa, int idCliente, LocalDateTime fechaHoraCreacion, String preferencias, Double montoTotal, boolean estado) {
        this.idDiaDeSpa = idDiaDeSpa;
        this.cliente = cliente;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.preferencias = preferencias;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public int getIdDiaDeSpa() {
        return idDiaDeSpa;
    }

    public void setIdDiaDeSpa(int idDiaDeSpa) {
        this.idDiaDeSpa = idDiaDeSpa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesion> sesiones) {
        this.sesiones = sesiones;
    }



    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DiaDeSpa{" + "idDiaDeSpa=" + idDiaDeSpa + ", cliente=" + cliente + ", fechaHoraCreacion=" + fechaHoraCreacion + ", sesiones=" + sesiones + ", preferencias=" + preferencias + ", montoTotal=" + montoTotal + ", estado=" + estado + '}';
    }

}
