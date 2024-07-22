package com.TesteAlfa.TicketAPI.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Cliente() {
    }

    public Cliente(Long id, String nome, List<Ticket> ticketsCliente) {
        this.id = id;
        this.nome = nome;
        this.ticketsCliente = ticketsCliente;
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

    public List<Ticket> getTicketsCliente() {
        return ticketsCliente;
    }

    public void setTicketsCliente(List<Ticket> ticketsCliente) {
        this.ticketsCliente = ticketsCliente;
    }

    @OneToMany(mappedBy = "cliente")
    private List<Ticket> ticketsCliente = new ArrayList<>();
}
