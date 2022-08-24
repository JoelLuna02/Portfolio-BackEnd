
package com.portfoliohjl.joelluna.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private int periodoE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String img;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, int periodoE, String descripcionE, String img) {
        this.nombreE = nombreE;
        this.periodoE = periodoE;
        this.descripcionE = descripcionE;
        this.img = img;
    }
    
        //Getters y Setters de la clase dto

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
