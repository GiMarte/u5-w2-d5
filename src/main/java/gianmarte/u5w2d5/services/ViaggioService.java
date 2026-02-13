package gianmarte.u5w2d5.services;


import gianmarte.u5w2d5.entities.Viaggio;
import gianmarte.u5w2d5.exceptions.BadRequestException;
import gianmarte.u5w2d5.payloads.ViaggioDTO;
import gianmarte.u5w2d5.repository.ViaggioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ViaggioService {
    private final ViaggioRepository viaggioRepository;

    public ViaggioService(ViaggioRepository viaggioRepository) {
        this.viaggioRepository = viaggioRepository;
    }

    public Viaggio save(ViaggioDTO dto) {
        if(viaggioRepository.existsByDestinazioneAndData(dto.destinazione(),dto.data())) throw new BadRequestException("Esiste gia un viaggio per questa destinazione nella stessa data");
        Viaggio nuovoViaggio = new Viaggio(dto.destinazione(), dto.data(),dto.stato());
        return this.viaggioRepository.save(nuovoViaggio);
    }

    public List<Viaggio> findAll() {
        return viaggioRepository.findAll();
    }

}
