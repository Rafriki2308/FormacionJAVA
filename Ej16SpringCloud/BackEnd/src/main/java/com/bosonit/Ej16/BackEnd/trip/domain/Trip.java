package com.bosonit.Ej16.BackEnd.trip.domain;


import com.bosonit.Ej16.BackEnd.customer.domain.Customer;
import com.bosonit.Ej16.BackEnd.trip.infrastructure.controller.input.TripInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PersonTable")
    private Long idTravel;

    @Column(nullable = false, unique = true)
    private String origin;

    @Column(nullable = false, unique = true)
    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    @OneToMany(mappedBy = "travel")
    List<Customer> passengers = new ArrayList<>();

    @Column(columnDefinition = "boolean default true")
    private Boolean status;

    public Trip (TripInputDto tripInputDto){
        setOrigin(tripInputDto.getOrigin());
        setDestination(tripInputDto.getDestination());
        setDepartureDate(tripInputDto.getDepartureDate());
        setArrivalDate(tripInputDto.getArrivalDate());
        setStatus(tripInputDto.getStatus());
    }

    public Trip (TripInputDto tripInputDto, Long idTrip){
        setIdTravel(idTrip);
        setOrigin(tripInputDto.getOrigin());
        setDestination(tripInputDto.getDestination());
        setDepartureDate(tripInputDto.getDepartureDate());
        setArrivalDate(tripInputDto.getArrivalDate());
        setStatus(tripInputDto.getStatus());
    }

    public void setPassenger(Customer customer){
        this.passengers.add(customer);
    }


}
