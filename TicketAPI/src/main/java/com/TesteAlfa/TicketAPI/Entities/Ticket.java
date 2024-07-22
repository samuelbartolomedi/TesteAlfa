package com.TesteAlfa.TicketAPI.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @EmbeddedId
    private TicketPK id = new TicketPK();
    @Column(columnDefinition = "TEXT")
    private String titulo;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;

    public Ticket() {
    }

    public TicketPK getId() {
        return id;
    }

    public void setId(TicketPK id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}

