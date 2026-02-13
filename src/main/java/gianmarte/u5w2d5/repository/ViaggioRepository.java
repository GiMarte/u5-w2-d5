package gianmarte.u5w2d5.repository;

import gianmarte.u5w2d5.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
    boolean existsByDestinazioneAndData(String destinazione, LocalDate data);
}
