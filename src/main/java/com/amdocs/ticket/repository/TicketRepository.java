package com.amdocs.ticket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.ticket.model.Ticket;

@Repository("ticketRepository")
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}