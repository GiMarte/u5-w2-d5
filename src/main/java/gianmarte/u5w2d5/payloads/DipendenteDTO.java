package gianmarte.u5w2d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record DipendenteDTO(
        String imgProfilo,

        @NotBlank(message = "L'username e' obbligatorio")
        @Size(min = 2, max = 12, message = "L'username e' compreso da 2 ad un massimo di 12 caratteri")
        String username,

        @NotBlank(message = "Il nome è un campo obbligatorio")
        @Size(min = 2, max = 15, message = "Il nome deve essere tra i 2 e i 15 caratteri")
        String nome,

        @NotBlank(message = "Il cognome e' obbligatorio")
        String cognome,

        @Email(message = "L'indirizzo email inserito non è nel formato corretto!")
        @NotBlank(message = "L'email è obbligatoria")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        String email
) {}


