package com.portfoliohjl.joelluna.Repository;

import com.portfoliohjl.joelluna.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Long> {
    public Optional<Proyectos> findByNombreP(String nombre);
    public boolean existsByNombreP(String nombre);
    public boolean existsByLinkP(String link);
}
