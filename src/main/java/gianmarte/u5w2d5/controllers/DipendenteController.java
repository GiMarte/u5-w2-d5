package gianmarte.u5w2d5.controllers;


import gianmarte.u5w2d5.entities.Dipendente;
import gianmarte.u5w2d5.payloads.DipendenteDTO;
import gianmarte.u5w2d5.services.DipendenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    private final DipendenteService dipendenteService;

    @Autowired
    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteDTO creoDipendente(@Valid @RequestBody DipendenteDTO payload) {
        Dipendente salvato = dipendenteService.save(payload);
        return new DipendenteDTO(
                salvato.getId(),
                salvato.getUsername(),
                salvato.getNome(),
                salvato.getCognome(),
                salvato.getEmail(),
                salvato.getImgProfilo()
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.findAll();
    }
}