package com.smartTicket.ticketing_system.service;

import com.smartTicket.ticketing_system.dto.UserRequestDto;
import com.smartTicket.ticketing_system.model.User;
import com.smartTicket.ticketing_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequestDto dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
