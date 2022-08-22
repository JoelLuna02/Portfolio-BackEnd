/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfoliohjl.joelluna.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String orientacionEdu;
    private int periodoEdu;
    private String carreraEdu;
    private String estado;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String orientacionEdu, int periodoEdu, String carreraEdu, String estado) {
        this.nombreEdu = nombreEdu;
        this.orientacionEdu = orientacionEdu;
        this.periodoEdu = periodoEdu;
        this.carreraEdu = carreraEdu;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreE) {
        this.nombreEdu = nombreE;
    }

    public String getCarreraEdu() {
        return carreraEdu;
    }

    public void setCarreraEdu(String descripcionE) {
        this.carreraEdu = descripcionE;
    }
    
    
}
