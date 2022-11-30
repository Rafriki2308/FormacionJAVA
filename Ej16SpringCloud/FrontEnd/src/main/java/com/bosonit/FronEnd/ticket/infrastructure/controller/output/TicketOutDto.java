package com.bosonit.FronEnd.ticket.infrastructure.controller.output;

import com.bosonit.FronEnd.ticket.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOutDto {


    private Long idTicket;

    private Long idPassenger;

    private String passengerName;

    private String passengerSurname;

    private String passengerEmail;

    private String originTrip;

    private String destinationTrip;

    private Date departureDate;

    private Date arrivalDate;

    public TicketOutDto(Ticket ticket){
        setIdTicket(ticket.getIdTicket());
        setIdPassenger(ticket.getIdPassenger());
        setPassengerName(ticket.getPassengerName());
        setPassengerSurname(ticket.getPassengerSurname());
        setPassengerEmail(ticket.getPassengerEmail());
        setOriginTrip(ticket.getOriginTrip());
        setDestinationTrip(ticket.getDestinationTrip());
        setDepartureDate(ticket.getDepartureDate());
        setArrivalDate(ticket.getArrivalDate());
    }
}
