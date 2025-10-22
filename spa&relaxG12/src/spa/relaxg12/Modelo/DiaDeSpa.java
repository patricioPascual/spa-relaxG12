/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Luza
 */
public class DiaDeSpa {
  private int idDiaDeSpa;
  private int idCliente;  
  private LocalDateTime fechaHoraCreacion;  
  private String preferencias;  
  private Double montoTotal;  
  private boolean estado;

    public DiaDeSpa() {
    }

    public DiaDeSpa(int idDiaDeSpa, int idCliente, LocalDateTime fechaHoraCreacion, String preferencias, Double montoTotal, boolean estado) {
        this.idDiaDeSpa = idDiaDeSpa;
        this.idCliente = idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        return "DiaDeSpa{" + "idDiaDeSpa=" + idDiaDeSpa + ", idCliente=" + idCliente + ", fechaHoraCreacion=" + fechaHoraCreacion + ", preferencias=" + preferencias + ", montoTotal=" + montoTotal + ", estado=" + estado + '}';
    }
  
}
