package com.bosonit.Ej16.BackEnd.trip.infrastructure.controller.output;

import com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.output.CustomerOutDto;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.output.CustomerOutDtoResponse;
import com.bosonit.Ej16.BackEnd.trip.domain.Trip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
public class TripOutDto {

    @Autowired
    @JsonIgnore
    private CustomerOutDtoResponse customerOutDtoResponse;

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
        setPassengers(customerOutDtoResponse.mappingCustomerToCustomerOutDto(trip.getPassengers()));
    }
}
