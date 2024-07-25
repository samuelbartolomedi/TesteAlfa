package com.TesteAlfa.TicketAPI.DTOs;

import com.TesteAlfa.TicketAPI.Entities.Cliente;
import com.TesteAlfa.TicketAPI.Entities.Modulo;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TicketDTO {
    private Long id;
    private String titulo;
    private Date dataAbertura;
    private Date dataEncerramento;
    private Long clienteId;
    private Long moduloId;

    public TicketDTO(@NotNull Ticket entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        dataAbertura = entity.getDataAbertura();
        dataEncerramento = entity.getDataEncerramento();
        clienteId = entity.getClienteId();
        moduloId = entity.getModuloId();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public Long getModuloId() {
        return moduloId;
    }
}
