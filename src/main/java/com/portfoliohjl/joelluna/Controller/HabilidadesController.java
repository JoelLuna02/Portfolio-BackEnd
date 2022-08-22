package com.portfoliohjl.joelluna.Controller;

import com.portfoliohjl.joelluna.Dto.dtoSkills;
import com.portfoliohjl.joelluna.Entity.Habilidades;
import com.portfoliohjl.joelluna.Security.Controller.Mensaje;
import com.portfoliohjl.joelluna.Service.SHabilidad;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadesController {
    @Autowired
    SHabilidad shabilidad;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> listado = shabilidad.list();
        return new ResponseEntity(listado, HttpStatus.OK);
    } 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!shabilidad.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidades experiencia = shabilidad.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shabilidad.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada de la base de datos."), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(shabilidad.existsByNombre(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Habilidades guardar = new Habilidades(dtoexp.getNombre(), dtoexp.getPorcentaje(), dtoexp.getEstilo(), dtoexp.getIcono());
        shabilidad.save(guardar);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill){
        if(!shabilidad.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(shabilidad.existsByNombre(dtoskill.getNombre()) && shabilidad.getByNombre(dtoskill.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Habilidades skill = shabilidad.getOne(id).get();
        skill.setNombre(dtoskill.getNombre());
        skill.setPorcentaje(dtoskill.getPorcentaje());
        skill.setEstilo(dtoskill.getEstilo());
        skill.setIcono(dtoskill.getIcono());
        shabilidad.save(skill);
        
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}
