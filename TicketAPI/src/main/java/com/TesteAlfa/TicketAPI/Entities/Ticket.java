package com.TesteAlfa.TicketAPI.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Titulo;
    private LocalDate DataAbertura;
    private LocalDate DataEncerramento;

    public Ticket() {
    }

    public Ticket(Long id, String titulo, LocalDate dataAbertura, LocalDate dataEncerramento) {
        this.id = id;
        Titulo = titulo;
        DataAbertura = dataAbertura;
        DataEncerramento = dataEncerramento;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public LocalDate getDataAbertura() {
        return DataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        DataAbertura = dataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return DataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        DataEncerramento = dataEncerramento;
    }
}

