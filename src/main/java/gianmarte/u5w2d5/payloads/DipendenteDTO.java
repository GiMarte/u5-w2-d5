package gianmarte.u5w2d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record DipendenteDTO(
        Long id,
        String imgProfilo,

        @NotBlank(message = "L'username e' obbligatorio")
        @Size(min = 2, max = 30, message = "L'username e' compreso da 2 ad un massimo di 30 caratteri")
        String username,

        @NotBlank(message = "Il nome è un campo obbligatorio")
        @Size(min = 2, max = 15, message = "Il nome deve essere tra i 2 e i 15 caratteri")
        String nome,

        @NotBlank(message = "Il cognome e' obbligatorio")
        String cognome,

        @Email(message = "L'indirizzo email inserito non è nel formato corretto!")
        @NotBlank(message = "L'email è obbligatoria")
        String email
) {}


