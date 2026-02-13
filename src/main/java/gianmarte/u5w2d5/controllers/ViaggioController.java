package gianmarte.u5w2d5.controllers;

import gianmarte.u5w2d5.entities.Viaggio;
import gianmarte.u5w2d5.payloads.ViaggioDTO;
import gianmarte.u5w2d5.services.ViaggioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    private final ViaggioService viaggioService;

    @Autowired
    public ViaggioController(ViaggioService viaggioService) {
        this.viaggioService = viaggioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioDTO creoViaggio(@Valid @RequestBody ViaggioDTO payload) {
        Viaggio salvato = viaggioService.save(payload);
        return new ViaggioDTO(payload.destinazione(),payload.data(),payload.stato());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Viaggio> getAllDipendenti() {
        return viaggioService.findAll();
    }
}