package gianmarte.u5w2d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    private String nome;
    private String cognome;
    @Column(unique = true, nullable = false)
    private String email;

    public Dipendente(String username, String nome, String cognome, String email) {
    this.username = username;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;

}}
