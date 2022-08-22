package com.portfoliohjl.joelluna.Repository;

import com.portfoliohjl.joelluna.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepo extends JpaRepository<Habilidades, Integer> {
    public Optional<Habilidades> findByNombre(String skill);
    public boolean existsByNombre(String skill);
}
