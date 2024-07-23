package com.TesteAlfa.TicketAPI.Repositories;

import com.TesteAlfa.TicketAPI.Entities.Cliente;
import com.TesteAlfa.TicketAPI.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findBycliente_id(Long cliente_id);
}
