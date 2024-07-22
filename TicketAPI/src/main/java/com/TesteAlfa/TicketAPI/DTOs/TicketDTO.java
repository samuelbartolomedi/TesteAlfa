package com.TesteAlfa.TicketAPI.DTOs;

import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Entities.TicketPK;

import java.time.LocalDate;

public class TicketDTO {
    private TicketPK clienteId;
    private TicketPK moduloId;
    private String titulo;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;

    public TicketDTO(TicketPK clienteId, TicketPK moduloId, String titulo, LocalDate dataAbertura, LocalDate dataEncerramento) {
        this.clienteId = clienteId;
        this.moduloId = moduloId;
        this.titulo = titulo;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
    }

    public TicketDTO(Ticket entity) {
        clienteId = entity.getId();
        moduloId = entity.getId();
        titulo = entity.getTitulo();
        dataAbertura = entity.getDataAbertura();
        dataEncerramento = entity.getDataEncerramento();
    }

    public TicketPK getClienteId() {
        return clienteId;
    }

    public void setClienteId(TicketPK clienteId) {
        this.clienteId = clienteId;
    }

    public TicketPK getModuloId() {
        return moduloId;
    }

    public void setModuloId(TicketPK moduloId) {
        this.moduloId = moduloId;
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
