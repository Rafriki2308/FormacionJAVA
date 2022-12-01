package com.bosonit.FronEnd.trip.domain;

import com.bosonit.FronEnd.customer.infrastructure.output.CustomerOutDto;
import com.bosonit.FronEnd.trip.infrastructure.output.TripOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {


    private Long idTravel;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    private Boolean status;

    private List<CustomerOutDto> passengers = new ArrayList<>();

    public Trip(TripOutDto tripOutDto){
        setIdTravel(tripOutDto.getIdTrip());
        setOrigin(tripOutDto.getOrigin());
        setDestination(tripOutDto.getDestination());
        setDepartureDate(tripOutDto.getDepartureDate());
        setArrivalDate(tripOutDto.getArrivalDate());
        setStatus(tripOutDto.getStatus());
        setPassengers(tripOutDto.getPassengers());
    }

}
