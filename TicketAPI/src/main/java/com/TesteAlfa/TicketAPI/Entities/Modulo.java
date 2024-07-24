package com.TesteAlfa.TicketAPI.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "modulo_id", sequenceName = "modulo_id_seq", allocationSize = 1)
@Table(name = "Modulo")
public class Modulo {
    @Id
    @GeneratedValue(generator = "modulo_id", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
