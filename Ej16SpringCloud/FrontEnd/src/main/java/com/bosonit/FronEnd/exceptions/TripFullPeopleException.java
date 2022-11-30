package com.bosonit.FronEnd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)

public class TripFullPeopleException extends RuntimeException{

    public TripFullPeopleException(String message) {
        super(message);
    }

}
