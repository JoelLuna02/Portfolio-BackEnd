/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfoliohjl.joelluna.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String orientacionEdu;
    @NotBlank
    private int periodoEdu;
    @NotBlank
    private String carreraEdu;
    @NotBlank
    private String estado;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String orientacionEdu, int periodoEdu, String carreraEdu, String estado) {
        this.nombreEdu = nombreEdu;
        this.orientacionEdu = orientacionEdu;
        this.periodoEdu = periodoEdu;
        this.carreraEdu = carreraEdu;
        this.estado = estado;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getOrientacionEdu() {
        return orientacionEdu;
    }

    public void setOrientacionEdu(String orientacionEdu) {
        this.orientacionEdu = orientacionEdu;
    }

    public int getPeriodoEdu() {
        return periodoEdu;
    }

    public void setPeriodoEdu(int periodoEdu) {
        this.periodoEdu = periodoEdu;
    }

    public String getCarreraEdu() {
        return carreraEdu;
    }

    public void setCarreraEdu(String carreraEdu) {
        this.carreraEdu = carreraEdu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
