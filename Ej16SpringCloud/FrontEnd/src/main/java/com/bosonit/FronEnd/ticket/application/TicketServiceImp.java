package com.bosonit.FronEnd.ticket.application;

import com.bosonit.FronEnd.customer.domain.Customer;
import com.bosonit.FronEnd.customer.feing.CustomerService;
import com.bosonit.FronEnd.customer.infrastructure.output.CustomerOutDto;
import com.bosonit.FronEnd.exceptions.EntityNotFoundException;
import com.bosonit.FronEnd.exceptions.PassengerAlreadyInTrip;
import com.bosonit.FronEnd.ticket.domain.Ticket;
import com.bosonit.FronEnd.ticket.infrastructure.controller.output.TicketOutDto;
import com.bosonit.FronEnd.ticket.infrastructure.repository.TicketRepository;
import com.bosonit.FronEnd.trip.domain.Trip;
import com.bosonit.FronEnd.trip.feing.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImp implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    private final CustomerService customerF;
    @Autowired
    private final TripService tripF;

    @Override
    public Object generateTicket(String idCustomer, String idTrip) throws EntityNotFoundException
            , PassengerAlreadyInTrip {

        Customer customer = new Customer(customerF.findById(idCustomer));
        CustomerOutDto customerOutDto =customerF.findById(idCustomer);
        if (customer.equals(null)) {
            throw new EntityNotFoundException("The customer doesn't exists");
        }

        Trip trip = new Trip(tripF.findById(idTrip));
        log.info(String.valueOf(trip));
        if (trip.equals(null)) {
            throw new EntityNotFoundException("The trip doesn't exits");
        }
        if (trip.getPassengers().contains(customerOutDto)) {
            throw new PassengerAlreadyInTrip("This passanger is already in this trip");
        }

        tripF.addPassengerToTrip(idTrip, idCustomer);

        return new TicketOutDto(ticketRepository.save(new Ticket(customer, trip)));
    }
}
