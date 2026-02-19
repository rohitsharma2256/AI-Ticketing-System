package com.smartTicket.ticketing_system.model;

import jakarta.persistence.*;
import lombok.*;

import  java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String role; // User, Admin, Agent
    private LocalDateTime createdAt = LocalDateTime.now();
}
