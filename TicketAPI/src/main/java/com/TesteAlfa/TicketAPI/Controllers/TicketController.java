package com.TesteAlfa.TicketAPI.Controllers;

import com.TesteAlfa.TicketAPI.DTOs.TicketDTO;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import com.TesteAlfa.TicketAPI.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping()
    public List<TicketDTO> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("/bydateclient/{month}/{year}")
    public List<TicketDTO> getTicketByDateClient(@PathVariable int month, @PathVariable int year){
        List<TicketDTO> listTicketsByDateClient = ticketService.findByDateClient(month, year);
        return listTicketsByDateClient;
    }

    @GetMapping("/bydatemodulo/{month}/{year}")
    public List<TicketDTO> getTicketByDateModulo(@PathVariable int month, @PathVariable int year){
        List<TicketDTO> listTicketsByDateModulo = ticketService.findByDateModulo(month, year);
        return listTicketsByDateModulo;
    }

    @GetMapping("/byclient/{clienteId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByClienteId(@PathVariable Long clienteId) {
        List<TicketDTO> tickets = ticketService.findByClienteId(clienteId);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/bymodulo/{month}/{year}/{moduloId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByModuloId(@PathVariable int month, @PathVariable int year, @PathVariable Long moduloId) {
        List<TicketDTO> tickets = ticketService.findByModuloId(month, year, moduloId);
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public TicketDTO insert(@RequestBody TicketDTO ticketDTO){
        ticketDTO = ticketService.insert(ticketDTO);
        return ticketDTO;
    }
}
