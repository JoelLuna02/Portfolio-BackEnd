package com.portfoliohjl.joelluna.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String oficio;
    @NotBlank
    private String descripcion;
    @NotBlank
    private int edad;
    @NotBlank
    private String email;
    @NotBlank
    private String localidad;
    @NotBlank
    private String hobbies;
    
    /* Construcción del dto */

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String oficio, String descripcion, int edad, String email, String localidad, String hobbies) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.oficio = oficio;
        this.descripcion = descripcion;
        this.edad = edad;
        this.email = email;
        this.localidad = localidad;
        this.hobbies = hobbies;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    
}
