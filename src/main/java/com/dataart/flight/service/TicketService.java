package com.dataart.flight.service;


import com.dataart.flight.dao.CityDAOImpl;
import com.dataart.flight.dao.TicketDAOImpl;
import com.dataart.flight.model.Ticket;
import com.dataart.flight.validators.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketDAOImpl ticketDAOImpl;

    @Autowired
    private CityDAOImpl cityDAO;

    @Autowired
    private TicketValidator validator;

    public ResponseEntity<Ticket> insertTicket(Ticket ticket) {
        validate(ticket);
        ticketDAOImpl.save(ticket);
        return ResponseEntity.ok(ticket);
    }

    public ResponseEntity<Ticket> findById(Integer id) {
        final Optional<Ticket> ticket = ticketDAOImpl.findById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public void validate(Ticket ticket) {
        validator.validateTicket(ticket);
    }
}
