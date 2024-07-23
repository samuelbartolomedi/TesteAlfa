package com.TesteAlfa.TicketAPI.Services;

import com.TesteAlfa.TicketAPI.DTOs.TicketDTO;
import com.TesteAlfa.TicketAPI.Entities.Cliente;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public List<TicketDTO> findAll() {
        List<Ticket> result = ticketRepository.findAll();
        return result.stream().map(x -> new TicketDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<TicketDTO> findByClienteId(Long cliente_id) {
        List<Ticket> tickets = ticketRepository.findByClienteId(cliente_id);
        return tickets.stream()
                .map(TicketDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TicketDTO> findByModuloId(Long cliente_id) {
        List<Ticket> tickets = ticketRepository.findByModuloId(cliente_id);
        return tickets.stream()
                .map(TicketDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional()
    public TicketDTO insert(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setTitulo(ticketDTO.getTitulo());
        ticket.setCliente(ticketDTO.getCliente());
        ticket.setDataAbertura(ticketDTO.getDataAbertura());
        ticket.setDataEncerramento(ticketDTO.getDataEncerramento());
        ticket.setModulo(ticketDTO.getModulo());
        ticket = ticketRepository.save(ticket);
        return new TicketDTO(ticket);
    }
}
