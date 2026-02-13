package gianmarte.u5w2d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;
    private LocalDate dataRichiesta;
    private String note;
    private String preferenze;

    public Prenotazione(Viaggio viaggio, Dipendente dipendente, LocalDate dataRichiesta, String note, String preferenze) {
    this.viaggio = viaggio;
    this.dipendente = dipendente;
    this.dataRichiesta = dataRichiesta;
    this.note = note;
    this.preferenze = preferenze;
}}
