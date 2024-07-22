package com.TesteAlfa.TicketAPI.Repositories;

import com.TesteAlfa.TicketAPI.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
