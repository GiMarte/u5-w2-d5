package gianmarte.u5w2d5.repository;

import gianmarte.u5w2d5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByEmail(String email);

    boolean existsByEmail(String email);
}
