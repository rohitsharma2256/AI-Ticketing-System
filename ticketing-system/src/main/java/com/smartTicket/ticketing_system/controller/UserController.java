package com.smartTicket.ticketing_system.controller;

import com.smartTicket.ticketing_system.dto.UserRequestDto;
import com.smartTicket.ticketing_system.model.User;
import com.smartTicket.ticketing_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserRequestDto dto) {
        return userService.createUser(dto);
    }
}
