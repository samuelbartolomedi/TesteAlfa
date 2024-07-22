package com.TesteAlfa.TicketAPI.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Modulo() {
    }

    public Modulo(Long id, String nome, List<Ticket> ticketsModulo) {
        this.id = id;
        this.nome = nome;
        this.ticketsModulo = ticketsModulo;
    }

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

    public List<Ticket> getTicketsModulo() {
        return ticketsModulo;
    }

    public void setTicketsModulo(List<Ticket> ticketsModulo) {
        this.ticketsModulo = ticketsModulo;
    }

    @OneToMany(mappedBy = "modulo")
    private List<Ticket> ticketsModulo = new ArrayList<>();
}
