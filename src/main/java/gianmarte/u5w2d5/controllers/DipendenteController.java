package gianmarte.u5w2d5.controllers;


import gianmarte.u5w2d5.entities.Dipendente;
import gianmarte.u5w2d5.exceptions.ValidationException;
import gianmarte.u5w2d5.payloads.DipendenteDTO;
import gianmarte.u5w2d5.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public Dipendente creoDipendente(@RequestBody @Validated DipendenteDTO payload, BindingResult validation ){
        if (validation.hasErrors())  throw new ValidationException("");
        else return this.dipendenteService.save(payload);
    }
}
