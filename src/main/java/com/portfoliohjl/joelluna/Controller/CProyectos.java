package com.portfoliohjl.joelluna.Controller;

import com.portfoliohjl.joelluna.Dto.dtoProyecto;
import com.portfoliohjl.joelluna.Entity.Proyectos;
import com.portfoliohjl.joelluna.Security.Controller.Mensaje;
import com.portfoliohjl.joelluna.Service.SProyectos;
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
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyectos {
    @Autowired
    SProyectos sproyecto;
    
    @GetMapping("/listado")
    public ResponseEntity<List<Proyectos>> listar() {
        List<Proyectos> listado = sproyecto.lista();
        return new ResponseEntity(listado, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") Long id) {
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("Proyecto no encontrado"), HttpStatus.NOT_FOUND);
        }
        Proyectos retornar = sproyecto.getOne(id).get();
        return new ResponseEntity(retornar, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("Proyecto no encontrado"), HttpStatus.NOT_FOUND);
        }
        sproyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado de la base de datos"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproject) {
        if (StringUtils.isEmpty(dtoproject.getNombreP())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sproyecto.existsByNombreP(dtoproject.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya está en uso"), HttpStatus.BAD_REQUEST);
        }
        Proyectos nuevo = new Proyectos(dtoproject.getNombreP(), dtoproject.getFechaP(), dtoproject.getDescripcionP(),
            dtoproject.getLinkP(), dtoproject.getImagen());
        sproyecto.save(nuevo);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoProyecto dtopro) {
        if (StringUtils.isEmpty(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sproyecto.existsByNombreP(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya está en uso"), HttpStatus.BAD_REQUEST);
        }
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("Proyecto no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        Proyectos nuevo = sproyecto.getOne(id).get();
        nuevo.setNombreP(dtopro.getNombreP());
        nuevo.setFechaP(dtopro.getFechaP());
        nuevo.setDescripcionP(dtopro.getDescripcionP());
        nuevo.setLink(dtopro.getLinkP());
        nuevo.setImagen(dtopro.getImagen());
        
        sproyecto.save(nuevo);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
