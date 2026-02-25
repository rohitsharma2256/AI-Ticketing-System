package com.smartTicket.ticketing_system;

import com.smartTicket.ticketing_system.dto.AiTicketAnalysis;


//Im using this as a Contract, everything depends on this
public interface AiProvider {
    AiTicketAnalysis analysisTicket(String text);
}
