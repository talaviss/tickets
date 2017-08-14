package com.amdocs.ticket.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.ticket.model.Ticket;
import com.amdocs.ticket.repository.TicketRepository;

@Service("ticketService")
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket getTicketById(long id) {
        return ticketRepository.findOne(id);
    }

    @Override
    public List<Ticket> getAllTickets() {

        return ticketRepository.findAll();
    }

}
