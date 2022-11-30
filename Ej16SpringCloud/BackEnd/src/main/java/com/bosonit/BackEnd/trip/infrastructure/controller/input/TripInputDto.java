package com.bosonit.BackEnd.trip.infrastructure.controller.input;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripInputDto {

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    private Boolean status;
}
