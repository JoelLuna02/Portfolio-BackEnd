package com.portfoliohjl.joelluna.Controller;

import com.portfoliohjl.joelluna.Dto.dtoPersona;
import com.portfoliohjl.joelluna.Entity.Persona;
import com.portfoliohjl.joelluna.Security.Controller.Mensaje;
import com.portfoliohjl.joelluna.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    SPersona spersona;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> lista = spersona.getPersona();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @GetMapping("/perfil")
    public ResponseEntity<Persona> perfil() {
        Persona perfil = spersona.getOne((int)1).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!spersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona pers = spersona.getOne(id).get();
        return new ResponseEntity(pers, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!spersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        spersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada con éxito"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopers) {
        if (StringUtils.isBlank(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("Error: Nombre requerido"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopers.getApellido())) {
            return new ResponseEntity(new Mensaje("Error: Apellido requerido"), HttpStatus.BAD_REQUEST);
        }
        if (spersona.existsByNombre(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("Error: Nombre Existente"), HttpStatus.BAD_REQUEST);
        }
        Persona pers = new Persona(
                dtopers.getNombre(), dtopers.getApellido(), dtopers.getOficio(), dtopers.getDescripcion(),
                dtopers.getEdad(), dtopers.getEmail(), dtopers.getLocalidad(), dtopers.getHobbies()
        );
        spersona.save(pers);
        return new ResponseEntity(new Mensaje("Persona creada con éxito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopers) {
        if (!spersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("Error: ID inexistente"), HttpStatus.NOT_FOUND);
        }
        if (spersona.existsByNombre(dtopers.getNombre()) && spersona.getByNombre(dtopers.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Error: Nombre Existente"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("Error: Nombre requerido"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopers.getApellido())) {
            return new ResponseEntity(new Mensaje("Error: Apellido requerido"), HttpStatus.BAD_REQUEST);
        }
        
        Persona pers = spersona.getOne(id).get();
        pers.setNombre(dtopers.getNombre());
        pers.setApellido(dtopers.getApellido());
        pers.setOficio(dtopers.getOficio());
        pers.setDescripcion(dtopers.getDescripcion());
        pers.setEdad(dtopers.getEdad());
        pers.setEmail(dtopers.getEmail());
        pers.setLocalidad(dtopers.getLocalidad());
        pers.setHobbies(dtopers.getHobbies());
        
        spersona.save(pers);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
