package com.amdocs.ticket.service;


import java.util.List;

import com.amdocs.ticket.model.Ticket;

/**
 * Created by user on 14/08/2017.
 */
public interface TicketService {

    Ticket getTicketById(String id);
    List<Ticket> getAllTickets();
}
