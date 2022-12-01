package com.bosonit.FronEnd.ticket.infrastructure.controller;

import com.bosonit.FronEnd.customer.infrastructure.output.CustomerOutDto;
import com.bosonit.FronEnd.exceptions.EntityNotFoundException;
import com.bosonit.FronEnd.exceptions.PassengerAlreadyInTrip;
import com.bosonit.FronEnd.ticket.application.TicketServiceImp;
import com.bosonit.FronEnd.ticket.infrastructure.controller.output.TicketOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImp tService;

    @GetMapping("/generateTicket/{userId}/{tripId}")
    public ResponseEntity<? extends Object> generateTicket(@PathVariable String userId, @PathVariable String tripId) {
        try {
            return new ResponseEntity<>(tService.generateTicket(userId, tripId), HttpStatus.ACCEPTED);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Trip or customer doesn't exists");
        } catch (PassengerAlreadyInTrip e) {
            return ResponseEntity.badRequest().body("This passenger has already been added to this trip");
        }
    }
}
