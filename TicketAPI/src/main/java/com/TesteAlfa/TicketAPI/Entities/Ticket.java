package com.TesteAlfa.TicketAPI.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "ticket_id", sequenceName = "ticket_id_seq", allocationSize = 1)
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(generator = "ticket_id", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String titulo;
    @Column(name = "data_abertura")
    private Date dataAbertura;
    @Column(name = "data_encerramento")
    private Date dataEncerramento;
    @Column(name = "cliente_id")
    private Long clienteId;
    @Column(name = "modulo_id")
    private Long moduloId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getModuloId() {
        return moduloId;
    }

    public void setModuloId(Long moduloId) {
        this.moduloId = moduloId;
    }
}

