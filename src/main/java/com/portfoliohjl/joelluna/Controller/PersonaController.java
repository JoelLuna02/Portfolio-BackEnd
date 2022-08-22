package com.portfoliohjl.joelluna.Controller;

import com.portfoliohjl.joelluna.Entity.Persona;
import com.portfoliohjl.joelluna.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("personas/listar")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue guardada con éxito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada con éxito de la base de datos.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("oficio") String newoffice,
                               @RequestParam("descripcion") String newdesc,
                               @RequestParam("edad") int newage,
                               @RequestParam("email") String newmail,
                               @RequestParam("localidad") String newlocate,
                               @RequestParam("hobbies") String newhobbie){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setOficio(newoffice);
        persona.setDescripcion(newdesc);
        persona.setEdad(newage);
        persona.setEmail(newmail);
        persona.setLocalidad(newlocate);
        persona.setHobbies(newhobbie);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("personas/listar/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
   
}
