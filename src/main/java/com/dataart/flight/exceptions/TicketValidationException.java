package com.dataart.flight.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class TicketValidationException extends TicketException {

    private static final long serialVersionUID = 9138142099883351082L;

    public static final String ARRIVAL_DATE_BEFORE = "ticket.arrivalDate.before";
    public static final String ARRIVAL_DATE_BEFORE_DESC = "The arrival date can't be before the departure date";

    public static final String TIME_DATE_BEFORE = "ticket.arrivalTime.before";
    public static final String TIME_DATE_BEFORE_DESC = "The arrival time can't be before the departure time when the date is the same";

    public static final String ORIGIN_CITY_NOTEXISTS = "ticket.origin.notExists";
    public static final String ORIGIN_CITY_NOTEXISTS_DESC = "The city of origin does not exists";


    public static final String DESTINATION_CITY_NOTEXISTS = "ticket.destination.notExists";
    public static final String DESTINATION_CITY_NOTEXISTS_DESC = "The city of destination does not exists";

    public static final String ORIGIN_CITY_EMPTY = "ticket.origin.empty";
    public static final String ORIGIN_CITY_EMPTY_DESC = "The city of origin is empty";

    public static final String DESTINATION_CITY_EMPTY = "ticket.destination.empty";
    public static final String DESTINATION_CITY_EMPTY_DESC = "The city of destination is empty";


    public TicketValidationException(String error) {
        super(error, HttpStatus.BAD_REQUEST, ZonedDateTime.now());
    }


}
