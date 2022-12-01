package com.bosonit.FronEnd.trip.infrastructure.output;


import com.bosonit.FronEnd.customer.infrastructure.output.CustomerOutDto;
import com.bosonit.FronEnd.trip.domain.Trip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripOutDto {


    private Long idTrip;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private Boolean status;
    private List<CustomerOutDto> passengers;


    public TripOutDto(Trip trip){
        setIdTrip(trip.getIdTravel());
        setOrigin(trip.getOrigin());
        setOrigin(trip.getOrigin());
        setDestination(trip.getDestination());
        setDepartureDate(trip.getDepartureDate());
        setArrivalDate(trip.getArrivalDate());
        setStatus(trip.getStatus());
        setPassengers(trip.getPassengers());
    }
}
