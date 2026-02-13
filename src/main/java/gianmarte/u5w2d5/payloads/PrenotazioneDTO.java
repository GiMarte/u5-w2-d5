package gianmarte.u5w2d5.payloads;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PrenotazioneDTO(

        @NotNull(message = "ID viaggio obbligatorio")
         Long viaggio,

        @NotNull(message = "ID dipendente obbligatorio")
         Long dipendente,

        @NotNull(message = "Data richiesta obbligatoria")
        @FutureOrPresent(message = "La data richiesta deve essere odierna o futura")
         LocalDate dataRichiesta,

        @Size(max = 100, message = "Note troppo lunghe")
         String note,

        @Size(max = 100, message = "Preferenze troppo lunghe")
         String preferenze

) {
}
