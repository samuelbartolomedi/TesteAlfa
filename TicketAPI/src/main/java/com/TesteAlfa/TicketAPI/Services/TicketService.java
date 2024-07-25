package com.TesteAlfa.TicketAPI.Services;

import com.TesteAlfa.TicketAPI.DTOs.TicketDTO;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
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
    public List<TicketDTO> findByClienteId(Long clienteId) {
        List<Ticket> tickets = ticketRepository.findByClienteId(clienteId);
        return tickets.stream()
                .map(TicketDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TicketDTO> findByModuloId(int month, int year, Long moduloId) {
        List<TicketDTO> tickets = ticketRepository.findByModuloId(moduloId).stream()
                .map(TicketDTO::new)
                .collect(Collectors.toList());
        return getByDate(month, year, tickets);
    }

    @Transactional()
    public TicketDTO insert(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setTitulo(ticketDTO.getTitulo());
        ticket.setClienteId(ticketDTO.getClienteId());
        ticket.setDataAbertura(ticketDTO.getDataAbertura());
        ticket.setDataEncerramento(ticketDTO.getDataEncerramento());
        ticket.setModuloId(ticketDTO.getModuloId());
        ticket = ticketRepository.save(ticket);
        return new TicketDTO(ticket);
    }

    public List<TicketDTO> findByDateModulo (int month, int year){
        List<TicketDTO> listTickets = this.findAll();
        return getByDate(month, year, listTickets).stream().sorted(Comparator.comparing(TicketDTO::getModuloId).thenComparing(TicketDTO::getClienteId))
                .collect(Collectors.toList());
    }

    public List<TicketDTO> findByDateClient (int month, int year){
        List<TicketDTO> listTickets = this.findAll();
        return getByDate(month, year, listTickets).stream().sorted(Comparator.comparing(TicketDTO::getClienteId).thenComparing(TicketDTO::getModuloId))
                .collect(Collectors.toList());
    }

    private List<TicketDTO> getByDate(int month, int year, List<TicketDTO> listTickets) {
        Calendar initialDate = Calendar.getInstance();
        initialDate.set(Calendar.YEAR, year);
        initialDate.set(Calendar.MONTH, month);
        Calendar finalDate = (Calendar) initialDate.clone();
        int lastDay = finalDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        finalDate.set(Calendar.DAY_OF_MONTH, lastDay);
        initialDate.set(Calendar.DAY_OF_MONTH, 1);
        return listTickets.stream().filter(x -> !x.getDataAbertura().before(initialDate.getTime()) && !x.getDataAbertura().after(finalDate.getTime())).collect(Collectors.toList());
    }
}
