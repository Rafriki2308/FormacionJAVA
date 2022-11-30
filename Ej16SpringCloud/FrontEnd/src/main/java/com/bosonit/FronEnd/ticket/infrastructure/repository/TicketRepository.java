package com.bosonit.FronEnd.ticket.infrastructure.repository;

import com.bosonit.FronEnd.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


}
