package com.bosonit.FronEnd.ticket.application;

import com.bosonit.FronEnd.customer.domain.Customer;
import com.bosonit.FronEnd.customer.feing.CustomerService;
import com.bosonit.FronEnd.exceptions.EntityNotFoundException;
import com.bosonit.FronEnd.ticket.domain.Ticket;
import com.bosonit.FronEnd.ticket.infrastructure.controller.output.TicketOutDto;
import com.bosonit.FronEnd.ticket.infrastructure.repository.TicketRepository;
import com.bosonit.FronEnd.trip.domain.Trip;
import com.bosonit.FronEnd.trip.feing.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImp implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    private final CustomerService customerF;
    @Autowired
    private final TripService tripF;

    @Override
    public Object generateTicket(String idCustomer, String idTrip) {

        Customer customer = new Customer(customerF.findById(idCustomer));
        Trip trip = new Trip(tripF.findById(idTrip));
        tripF.addPassengerToTrip(idTrip,idCustomer);

        return new TicketOutDto(ticketRepository.save(new Ticket(customer,trip)));
    }
}
