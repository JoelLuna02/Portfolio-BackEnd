package com.portfoliohjl.joelluna.Service;

import com.portfoliohjl.joelluna.Entity.Persona;
import com.portfoliohjl.joelluna.Repository.IPersonaRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    @Autowired
    IPersonaRepo ipersonarepo;
    
    public List<Persona> getPersona() {
        return ipersonarepo.findAll();
    }
    public Optional<Persona> getOne(int id) {
        return ipersonarepo.findById(id);
    }
    public Optional<Persona> getByNombre(String nombre) {
        return ipersonarepo.findByNombre(nombre);
    }
    public void save(Persona persona) {
        ipersonarepo.save(persona);
    }
    public void delete(int id) {
        ipersonarepo.deleteById(id);
    }
    public boolean existsById(int id) {
        return ipersonarepo.existsById(id);
    }
    public boolean existsByNombre(String nombre) {
        return ipersonarepo.existsByNombre(nombre);
    }
}
