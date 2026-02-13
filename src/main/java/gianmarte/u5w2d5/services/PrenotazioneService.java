package gianmarte.u5w2d5.services;

import gianmarte.u5w2d5.entities.Prenotazione;
import gianmarte.u5w2d5.exceptions.BadRequestException;
import gianmarte.u5w2d5.payloads.PrenotazioneDTO;
import gianmarte.u5w2d5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final ViaggioService viaggioService;
    private final DipendenteService dipendenteService;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, ViaggioService viaggioService, DipendenteService dipendenteService) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.viaggioService = viaggioService;
        this.dipendenteService = dipendenteService;
    }

    public Prenotazione save(PrenotazioneDTO dto) {
        if (this.prenotazioneRepository.existsByDipendenteAndDataRichiesta(this.dipendenteService.findById(dto.dipendenteId()), dto.dataRichiesta()) ){
            throw new BadRequestException("La prenotazione e' gia' occupata");
        }
        Prenotazione nuovoPrenotazione = new Prenotazione(this.viaggioService.findById(dto.viaggioId()), this.dipendenteService.findById(dto.dipendenteId()), dto.dataRichiesta(), dto.note(), dto.preferenze());
        return this.prenotazioneRepository.save(nuovoPrenotazione);
    }

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }


}
