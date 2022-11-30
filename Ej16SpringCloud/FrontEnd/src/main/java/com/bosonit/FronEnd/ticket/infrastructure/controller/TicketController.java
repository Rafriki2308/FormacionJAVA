package com.bosonit.FronEnd.ticket.infrastructure.controller;

import com.bosonit.FronEnd.customer.infrastructure.output.CustomerOutDto;
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
    public Object generateTicket(@PathVariable String userId, @PathVariable String tripId){
        return tService.generateTicket(userId, tripId);
    }
}
