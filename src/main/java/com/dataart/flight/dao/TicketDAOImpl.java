package com.dataart.flight.dao;

import com.dataart.flight.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDAOImpl extends CrudRepository<Ticket, Integer> {

}
