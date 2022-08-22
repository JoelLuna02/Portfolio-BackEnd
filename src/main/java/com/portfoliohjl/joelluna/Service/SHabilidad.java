package com.portfoliohjl.joelluna.Service;

import com.portfoliohjl.joelluna.Entity.Habilidades;
import com.portfoliohjl.joelluna.Repository.IHabilidadRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidad {
    @Autowired
    IHabilidadRepo repositorio;
    
    public List<Habilidades> list() {
        return repositorio.findAll();
    }
    public Optional<Habilidades> getOne(int id) {
        return repositorio.findById(id);
    }
    public Optional<Habilidades> getByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
    public void save(Habilidades skill) {
        repositorio.save(skill);
    }
    public void delete(int id) {
        repositorio.deleteById(id);
    }
    public boolean existsById(int id) {
        return repositorio.existsById(id);
    }
    public boolean existsByNombre(String skill) {
        return repositorio.existsByNombre(skill);
    }
}
