package com.smartTicket.ticketing_system.repository;

import com.smartTicket.ticketing_system.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
