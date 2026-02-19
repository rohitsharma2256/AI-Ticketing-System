package com.smartTicket.ticketing_system.repository;

import com.smartTicket.ticketing_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
