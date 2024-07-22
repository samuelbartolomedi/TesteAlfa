package com.TesteAlfa.TicketAPI.DTOs;

import com.TesteAlfa.TicketAPI.Entities.Ticket;

import java.time.LocalDate;

public class TicketDTO {
    private Long id;
    private String Titulo;
    private LocalDate DataAbertura;
    private LocalDate DataEncerramento;

    public TicketDTO() {
    }

    public TicketDTO(Long id, String titulo, LocalDate dataAbertura, LocalDate dataEncerramento, Long CodCliente, Long CodModulo) {
        this.id = id;
        this.Titulo = titulo;
        this.DataAbertura = dataAbertura;
        this.DataEncerramento = dataEncerramento;
    }

    public TicketDTO(Ticket entity) {
        id = entity.getId();
        Titulo = entity.getTitulo();
        DataAbertura = entity.getDataAbertura();
        DataEncerramento = entity.getDataEncerramento();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public LocalDate getDataAbertura() {
        return DataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return DataEncerramento;
    }
}
