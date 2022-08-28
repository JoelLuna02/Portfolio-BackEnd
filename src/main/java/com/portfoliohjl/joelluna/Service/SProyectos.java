package com.portfoliohjl.joelluna.Service;

import com.portfoliohjl.joelluna.Entity.Proyectos;
import com.portfoliohjl.joelluna.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyectos rproyecto;
    
    public List<Proyectos> lista() {
        return rproyecto.findAll();
    }
    public Optional<Proyectos> getOne(Long id) {
        return rproyecto.findById(id);
    }
    public Optional<Proyectos> getByNombreP(String buscar) {
        return rproyecto.findByNombreP(buscar);
    }
    public void save(Proyectos project) {
        rproyecto.save(project);
    }
    public void delete(Long id) {
        rproyecto.deleteById(id);
    }
    public boolean existsById(Long id) {
        return rproyecto.existsById(id);
    }
    public boolean existsByNombreP(String nombre) {
        return rproyecto.existsByNombreP(nombre);
    }
    public boolean existsByLinkP(String enlace) {
        return rproyecto.existsByLinkP(enlace);
    }
}
