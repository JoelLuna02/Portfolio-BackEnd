package com.portfoliohjl.joelluna.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min=1, max=60, message="Máx de caracteres: 50")
    private String oficio;
    
    @NotNull
    @Size(min=0, max=500, message="Sólo disponible hasta 500 caracteres.")
    private String descripcion;
    
    @NotNull
    private int edad;
    
    @NotNull
    @Size(min=1, max=60, message="Máx de caracteres: 50")
    private String email;
    
    @NotNull
    @Size(min=1, max=30, message="Máx de caracteres: 30")
    private String localidad;
    
    @NotNull
    @Size(min=1, max=60, message="Máx de caracteres: 50")
    private String hobbies;    
    
}
