package com.dataart.flight.exceptions.handler;

import com.dataart.flight.exceptions.TicketException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(TicketException.class)
    private ResponseEntity<Object> handleApiRequestException(TicketException e) {
        return new ResponseEntity<>(e, BAD_REQUEST);
    }
}
