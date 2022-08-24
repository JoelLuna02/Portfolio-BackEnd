package com.portfoliohjl.joelluna.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private int periodoE;
    private String descripcionE;
    private String img;
    
    //Constructor de la clase

    public Experiencia() {
    }

    public Experiencia(String nombreE, int periodoE, String descripcionE, String img) {
        this.nombreE = nombreE;
        this.periodoE = periodoE;
        this.descripcionE = descripcionE;
        this.img = img;
    }
    
    //Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public int getPeriodoE() {
        return periodoE;
    }

    public void setPeriodoE(int periodoE) {
        this.periodoE = periodoE;
    }
    
    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
