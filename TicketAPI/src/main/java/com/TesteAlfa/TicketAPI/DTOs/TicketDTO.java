package com.TesteAlfa.TicketAPI.DTOs;

import com.TesteAlfa.TicketAPI.Entities.Cliente;
import com.TesteAlfa.TicketAPI.Entities.Modulo;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Long id;
    private String titulo;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;
    private Cliente cliente;
    private Modulo modulo;

    public TicketDTO(Ticket entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        dataAbertura = entity.getDataAbertura();
        dataEncerramento = entity.getDataEncerramento();
        cliente = entity.getCliente();
        modulo = entity.getModulo();
    }
}
