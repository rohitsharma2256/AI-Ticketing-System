package com.smartTicket.ticketing_system.controller;

import com.smartTicket.ticketing_system.dto.TicketRequestDto;
import com.smartTicket.ticketing_system.model.Ticket;
import com.smartTicket.ticketing_system.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(
            @Valid @RequestBody TicketRequestDto request) throws Exception {

        Ticket ticket = ticketService.createTicket(request);
        return ResponseEntity.ok(ticket);
    }
}


