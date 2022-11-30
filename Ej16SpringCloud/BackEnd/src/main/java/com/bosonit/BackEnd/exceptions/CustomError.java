package com.bosonit.BackEnd.exceptions;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Date;

public class CustomError {

    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("HttpCode")
    private int httpCode;

    @JsonProperty("mensaje")
    private String msg;

    private Long dateTime = System.currentTimeMillis();


    public CustomError(int httpCode, String msg) {
        this.timestamp = new Timestamp(dateTime);
        this.httpCode = httpCode;
        this.msg = msg;
    }
}
