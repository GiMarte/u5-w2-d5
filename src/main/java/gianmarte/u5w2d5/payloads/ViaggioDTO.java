package gianmarte.u5w2d5.payloads;

import gianmarte.u5w2d5.enums.StatoViaggio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record ViaggioDTO(
        @NotBlank(message = "Destinazione obbligatoria")
        String destinazione,

        @NotNull(message = "Data obbligatoria")
        @NotBlank(message = "La data deve essere odierna o futura")
        LocalDate data,

        @NotNull(message = "Stato obbligatorio")
        StatoViaggio stato
) {
}
