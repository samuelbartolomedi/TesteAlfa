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

    @GetMapping("/byclient/{cliente_id}")
    public ResponseEntity<List<TicketDTO>> getTicketsByClienteId(@PathVariable Long cliente_id) {
        List<TicketDTO> tickets = ticketService.findByClienteId(cliente_id);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/bymodulo/{modulo_id}")
    public ResponseEntity<List<TicketDTO>> getTicketsByModuloId(@PathVariable Long modulo_id) {
        List<TicketDTO> tickets = ticketService.findByModuloId(modulo_id);
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public TicketDTO insert(@RequestBody TicketDTO ticketDTO){
        ticketDTO = ticketService.insert(ticketDTO);
        return ticketDTO;
    }
}
