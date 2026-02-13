package gianmarte.u5w2d5.controllers;

import gianmarte.u5w2d5.entities.Prenotazione;
import gianmarte.u5w2d5.payloads.PrenotazioneDTO;
import gianmarte.u5w2d5.services.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    @Autowired
    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneDTO creoPrenotazione(@Valid @RequestBody PrenotazioneDTO payload) {
        Prenotazione salvato = prenotazioneService.save(payload);
        return new PrenotazioneDTO( salvato.getViaggio().getId(),salvato.getDipendente().getId(),salvato.getDataRichiesta(),salvato.getNote(),salvato.getPreferenze());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.findAll();
    }
}
