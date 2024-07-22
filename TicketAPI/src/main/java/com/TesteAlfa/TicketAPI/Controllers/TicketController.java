package com.TesteAlfa.TicketAPI.Controllers;

import com.TesteAlfa.TicketAPI.DTOs.TicketDTO;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Repositories.TicketRepository;
import com.TesteAlfa.TicketAPI.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/{id}")
    public TicketDTO findById(@PathVariable Long id){
         return ticketService.findById(id);
    }

    @GetMapping()
    public List<TicketDTO> findAll(){
        return ticketService.findAll();
    }
}
