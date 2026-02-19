package com.smartTicket.ticketing_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AiTicketAnalysis {

    private String category;
    private String priority;
    private String autoReply;
}