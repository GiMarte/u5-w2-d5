package gianmarte.u5w2d5.repository;

import gianmarte.u5w2d5.entities.Dipendente;
import gianmarte.u5w2d5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);


}
