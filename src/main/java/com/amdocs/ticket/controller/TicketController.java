package com.amdocs.ticket.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.amdocs.ticket.model.Ticket;


import com.amdocs.ticket.model.Ticket;
import com.amdocs.ticket.service.TicketService;

/**
 * Created by user on 14/08/2017.
 */
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getTickets() {
        return ticketService.getAllTickets();
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public Ticket getEmployee(@PathVariable("id") long id) {
        return ticketService.getTicketById(id);
    }
}
