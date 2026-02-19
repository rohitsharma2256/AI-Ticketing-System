package com.smartTicket.ticketing_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor                   //This are from Lombok
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @Column(length = 5000)
    private String description;

    // Filled by AI
    private String category;   // Billing, Technical, Account
    private String priority;   // HIGH, MEDIUM, LOW

    private String status;     // OPEN, IN_PROGRESS, RESOLVED
    private String assignedTeam;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
