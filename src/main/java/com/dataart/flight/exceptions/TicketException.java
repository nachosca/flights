package com.dataart.flight.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TicketException extends RuntimeException{

    private static final long serialVersionUID = -5766485759623492409L;
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

}
