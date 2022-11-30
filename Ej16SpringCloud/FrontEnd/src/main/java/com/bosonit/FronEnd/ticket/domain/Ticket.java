package com.bosonit.FronEnd.ticket.domain;


import com.bosonit.FronEnd.trip.domain.Trip;
import com.bosonit.FronEnd.customer.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TicketTable")
    private Long idTicket;

    @Column
    private Long idPassenger;

    @Column
    private String passengerName;

    @Column
    private String passengerSurname;

    @Column
    private String passengerEmail;

    @Column
    private String originTrip;

    @Column
    private String destinationTrip;

    @Column
    private Date departureDate;

    @Column
    private Date arrivalDate;

    public Ticket (Customer customer, Trip trip){
        setIdPassenger(customer.getIdCustomer());
        setPassengerName(customer.getName());
        setPassengerSurname(customer.getSurname());
        setPassengerEmail(customer.getEmail());
        setOriginTrip(trip.getOrigin());
        setDestinationTrip(trip.getDestination());
        setDepartureDate(trip.getDepartureDate());
        setArrivalDate(trip.getArrivalDate());
    }
}
