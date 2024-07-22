package com.TesteAlfa.TicketAPI.DTOs;

import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Entities.TicketPK;

import java.time.LocalDate;

public class TicketDTO {
    private TicketPK id;
    private String titulo;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;

    public TicketDTO() {
    }

    public TicketDTO(TicketPK id, String titulo, LocalDate dataAbertura, LocalDate dataEncerramento) {
        this.id = id;
        this.titulo = titulo;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
    }

    public TicketDTO(Ticket entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        dataAbertura = entity.getDataAbertura();
        dataEncerramento = entity.getDataEncerramento();
    }

    public TicketPK getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }
}
