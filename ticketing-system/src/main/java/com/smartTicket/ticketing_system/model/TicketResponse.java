package com.smartTicket.ticketing_system.model;


import jakarta.persistence.*;
import lombok.*;
//import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_responses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TicketResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(length = 5000)
    private String message;

    private boolean isAiGenerated;

    private LocalDateTime createdAt = LocalDateTime.now();
}
