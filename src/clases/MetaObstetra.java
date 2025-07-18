/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author moise
 */

public class MetaObstetra {
    private int id;
    private int idMeta;
    private int idObstetra;
    private int avance;
    private int objetivo;

    private String nombreObstetra;
    private String nombreMeta;

    public MetaObstetra(int id, int idMeta, int idObstetra, int avance, int objetivo, String nombreObstetra, String nombreMeta) {
        this.id = id;
        this.idMeta = idMeta;
        this.idObstetra = idObstetra;
        this.avance = avance;
        this.objetivo = objetivo;
        this.nombreObstetra = nombreObstetra;
        this.nombreMeta = nombreMeta;
    }

    public double getPorcentaje() {
        if (objetivo == 0) return 0;
        return (avance * 100.0) / objetivo;
    }

    // Getters y Setters aquí

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public int getIdObstetra() {
        return idObstetra;
    }

    public void setIdObstetra(int idObstetra) {
        this.idObstetra = idObstetra;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }

    public String getNombreObstetra() {
        return nombreObstetra;
    }

    public void setNombreObstetra(String nombreObstetra) {
        this.nombreObstetra = nombreObstetra;
    }

    public String getNombreMeta() {
        return nombreMeta;
    }

    public void setNombreMeta(String nombreMeta) {
        this.nombreMeta = nombreMeta;
    }

}

