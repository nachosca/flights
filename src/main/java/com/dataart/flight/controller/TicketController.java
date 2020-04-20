package com.dataart.flight.controller;

import com.dataart.flight.model.Ticket;
import com.dataart.flight.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping
    public ResponseEntity<Ticket> insertTicket (@Valid @NotNull @RequestBody Ticket ticket){
        return service.insertTicket(ticket);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ticket> findById (@NotNull @PathVariable Integer id){
        return service.findById(id);
    }
}
