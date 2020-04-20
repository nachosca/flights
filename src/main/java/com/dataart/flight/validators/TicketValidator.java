package com.dataart.flight.validators;

import com.dataart.flight.dao.CityDAOImpl;
import com.dataart.flight.exceptions.TicketValidationException;
import com.dataart.flight.model.City;
import com.dataart.flight.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class TicketValidator {

    @Autowired
    private CityDAOImpl cityDAOImpl;

    public void validateTicket(Ticket ticket) throws TicketValidationException{
        if (ticket.getDepartureDate().isAfter(ticket.getArrivalDate())){
            throw new TicketValidationException(TicketValidationException.ARRIVAL_DATE_BEFORE_DESC);
        } else if (ticket.getDepartureDate().isEqual(ticket.getArrivalDate())){
            if (ticket.getDepartureTime().isAfter(ticket.getArrivalTime())){
                throw new TicketValidationException(TicketValidationException.TIME_DATE_BEFORE_DESC);
            }
        }

        if (Objects.nonNull(ticket.getOrigin().getId())){
            final Optional<City> city = cityDAOImpl.findById(ticket.getOrigin().getId());
            if (!city.isPresent()){
                throw new TicketValidationException(TicketValidationException.ORIGIN_CITY_NOTEXISTS_DESC);
            }
            ticket.setOrigin(city.get());
        }else {
            throw new TicketValidationException(TicketValidationException.ORIGIN_CITY_EMPTY_DESC);
        }

        if (Objects.nonNull(ticket.getDestination().getId())){
            final Optional<City> city = cityDAOImpl.findById(ticket.getDestination().getId());
            if (!city.isPresent()){
                throw new TicketValidationException(TicketValidationException.DESTINATION_CITY_NOTEXISTS_DESC);
            }
            ticket.setDestination(city.get());
        } else {
            throw new TicketValidationException(TicketValidationException.DESTINATION_CITY_EMPTY_DESC);
        }



    }

}
