package com.smartTicket.ticketing_system.service;


import com.smartTicket.ticketing_system.AiProvider;
import com.smartTicket.ticketing_system.dto.AiTicketAnalysis;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//This is for FreeAi Serviced implementing AIProvider interface
@Service
@Primary   //its primary spring uses this if multiple providers exist.
public class FreeAiProvider implements AiProvider {

    @Override
    public AiTicketAnalysis analysisTicket(String text) {
     AiTicketAnalysis ai = new AiTicketAnalysis();


        if (text.toLowerCase().contains("payment") || text.toLowerCase().contains("refund")) {
            ai.setCategory("Billing");
            ai.setPriority("HIGH");
            ai.setAutoReply("Your billing issue has been received.");
        }
        else if (text.toLowerCase().contains("login")) {
            ai.setCategory("Authentication");
            ai.setPriority("MEDIUM");
            ai.setAutoReply("Please reset password.");
        }
        else {
            ai.setCategory("General");
            ai.setPriority("LOW");
            ai.setAutoReply("We will review your issue.");
        }

        return ai;
    }
    }

