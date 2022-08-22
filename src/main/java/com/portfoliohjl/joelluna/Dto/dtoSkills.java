package com.portfoliohjl.joelluna.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    @NotBlank
    private String estilo;
    @NotBlank
    private String icono;

    /* Constructor del DTO */
    public dtoSkills() {
    }

    public dtoSkills(String nombre, int porcentaje, String estilo, String icono) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.estilo = estilo;
        this.icono = icono;
    }
    
    /* Getters y setters */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
}
