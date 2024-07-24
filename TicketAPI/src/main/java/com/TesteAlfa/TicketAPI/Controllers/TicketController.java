package com.TesteAlfa.TicketAPI.Controllers;

import com.TesteAlfa.TicketAPI.DTOs.TicketDTO;
import com.TesteAlfa.TicketAPI.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping()
    public List<TicketDTO> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("/byclient/{clienteId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByClienteId(@PathVariable Long clienteId) {
        List<TicketDTO> tickets = ticketService.findByClienteId(clienteId);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/bymodulo/{moduloId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByModuloId(@PathVariable Long moduloId) {
        List<TicketDTO> tickets = ticketService.findByModuloId(moduloId);
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public TicketDTO insert(@RequestBody TicketDTO ticketDTO){
        ticketDTO = ticketService.insert(ticketDTO);
        return ticketDTO;
    }
}
