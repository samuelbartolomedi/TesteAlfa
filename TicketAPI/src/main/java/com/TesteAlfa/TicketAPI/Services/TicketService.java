package com.TesteAlfa.TicketAPI.Services;

import com.TesteAlfa.TicketAPI.DTOs.TicketDTO;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public TicketDTO findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        return new TicketDTO(ticket);
    }

    @Transactional(readOnly = true)
    public List<TicketDTO> findAll() {
        List<Ticket> result = ticketRepository.findAll();
        return result.stream().map(x -> new TicketDTO(x)).toList();
    }
}
