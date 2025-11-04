/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Luza
 */
public class DiaDeSpa {
  private int idDiaDeSpa;
  private Cliente cliente;  
  private LocalDate fecha; 
  private Sesion sesiones;
  private String preferencias;
  private Double montoTotal;  
  private boolean estado;

    public DiaDeSpa() {
    }

  

    public DiaDeSpa(int idDiaDeSpa, int idCliente, LocalDate fecha, String preferencias, Double montoTotal, boolean estado) {
        this.idDiaDeSpa = idDiaDeSpa;
        this.cliente = cliente;
        this.fecha = fecha;
 
        this.preferencias = preferencias;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public DiaDeSpa(Cliente cliente, LocalDate fecha, String preferencias, Double montoTotal, boolean estado) {
        this.cliente = cliente;
        this.fecha = fecha;
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

    public Sesion getSesiones() {
        return sesiones;
    }

    public void setSesiones(Sesion sesiones) {
        this.sesiones = sesiones;
    }



    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha (LocalDate fecha) {
        this.fecha = fecha;
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
        return "DiaDeSpa{" + "idDiaDeSpa=" + idDiaDeSpa + ", cliente=" + cliente + ", fechaHoraCreacion=" + fecha + ", sesiones=" + sesiones + ", preferencias=" + preferencias + ", montoTotal=" + montoTotal + ", estado=" + estado + '}';
    }

}
