/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spa.relaxg12.Modelo;

/**
 *
 * @author Luza
 */
public class Consultorio {

    private int idConsultorio;
    private String numeroConsultorio;
    private String equipamiento;
    private String aptoPara;
    private boolean estado;

    public Consultorio() {
    }

    public Consultorio(String numeroConsultorio, String equipamiento, String aptoPara, boolean estado) {
        this.numeroConsultorio = numeroConsultorio;
        this.equipamiento = equipamiento;
        this.aptoPara = aptoPara;
        this.estado = estado;
    }

    public Consultorio(int idConsultorio, String numeroConsultorio, String equipamiento, String aptoPara, boolean estado) {
        this.idConsultorio = idConsultorio;
        this.numeroConsultorio = numeroConsultorio;
        this.equipamiento = equipamiento;
        this.aptoPara = aptoPara;
        this.estado = estado;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(String numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public String getAptoPara() {
        return aptoPara;
    }

    public void setAptoPara(String aptoPara) {
        this.aptoPara = aptoPara;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "idConsultorio=" + idConsultorio + ", numeroConsultorio=" + numeroConsultorio + ", equipamiento=" + equipamiento + ", aptoPara=" + aptoPara + ", estado=" + estado + '}';
    }

}
