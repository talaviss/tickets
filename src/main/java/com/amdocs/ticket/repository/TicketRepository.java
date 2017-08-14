package com.amdocs.ticket.repository;

import com.amdocs.ticket.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@Repository("ticketRepository")

public interface TicketRepository extends MongoRepository<Ticket, Long> {
    public List<Ticket> findByTitle(String title);
    public List<Ticket> findByDescription(String description);
}