package com.smartTicket.ticketing_system.repository;

import com.smartTicket.ticketing_system.model.TicketResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketResponseRepository extends JpaRepository<TicketResponse, Long> {
}
