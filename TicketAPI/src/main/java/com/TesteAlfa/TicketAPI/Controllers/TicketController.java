package com.TesteAlfa.TicketAPI.Controllers;

import com.TesteAlfa.TicketAPI.DTOs.TicketDTO;
import com.TesteAlfa.TicketAPI.Entities.Cliente;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Repositories.TicketRepository;
import com.TesteAlfa.TicketAPI.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping()
    public List<TicketDTO> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("/{cliente_id}")
    public ResponseEntity<List<TicketDTO>> getTicketsByClientId(@PathVariable Long cliente_id) {
        List<TicketDTO> tickets = ticketService.findBycliente_id(cliente_id);
        return ResponseEntity.ok(tickets);
    }
}
