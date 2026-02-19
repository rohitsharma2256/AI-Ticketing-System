package com.smartTicket.ticketing_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Long userId;


}
