package gianmarte.u5w2d5.services;

import com.cloudinary.Cloudinary;
import gianmarte.u5w2d5.entities.Dipendente;
import gianmarte.u5w2d5.payloads.DipendenteDTO;
import gianmarte.u5w2d5.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {
    private final Cloudinary cloudinaryUploader;
    private final DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteService(Cloudinary cloudinaryUploader, DipendenteRepository dipendenteRepository) {
    this.cloudinaryUploader = cloudinaryUploader;
    this.dipendenteRepository = dipendenteRepository;
}
    public Dipendente save(DipendenteDTO dto) {
       Dipendente nuovoDipendente = new Dipendente(dto.username(),dto.nome(),dto.cognome(),dto.email());
        nuovoDipendente.setImgProfilo("https://ui-avatars.com/api?name=" + dto.nome() + "+" + dto.cognome());
        System.out.println(nuovoDipendente.getId() + "Salvato");
        return this.dipendenteRepository.save(nuovoDipendente);
    }

}
