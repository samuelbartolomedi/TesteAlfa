package com.TesteAlfa.TicketAPI.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ticket")
public class Ticket {
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String titulo;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;
}

