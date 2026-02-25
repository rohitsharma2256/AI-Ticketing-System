package com.smartTicket.ticketing_system.service;

import com.smartTicket.ticketing_system.AiProvider;
import com.smartTicket.ticketing_system.dto.AiTicketAnalysis;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final AiProvider aiProvider;

    public AiService(AiProvider aiProvider){
        this.aiProvider = aiProvider;
    }

    public AiTicketAnalysis analysisTicket(String text){
        return aiProvider.analysisTicket(text);
    }
}

//Note: in this abstraction AiService does NOT know: FreeAi based OpenAI future model
//Strategy pattern + Spring profiles