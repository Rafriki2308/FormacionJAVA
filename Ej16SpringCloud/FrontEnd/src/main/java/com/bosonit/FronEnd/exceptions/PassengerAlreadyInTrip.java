package com.bosonit.FronEnd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PassengerAlreadyInTrip extends RuntimeException {

    public PassengerAlreadyInTrip(String message) {
        super(message);
    }
}
