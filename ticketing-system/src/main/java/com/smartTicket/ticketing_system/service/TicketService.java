package com.smartTicket.ticketing_system.service;

import com.smartTicket.ticketing_system.dto.AiTicketAnalysis;
import com.smartTicket.ticketing_system.dto.TicketRequestDto;
import com.smartTicket.ticketing_system.model.Ticket;
import com.smartTicket.ticketing_system.model.TicketResponse;
import com.smartTicket.ticketing_system.model.User;
import com.smartTicket.ticketing_system.repository.TicketRepository;
import com.smartTicket.ticketing_system.repository.TicketResponseRepository;
import com.smartTicket.ticketing_system.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TicketResponseRepository ticketResponseRepository;
    private final AiService aiService;

    public TicketService(TicketRepository ticketRepository,
                         UserRepository userRepository,
                         TicketResponseRepository ticketResponseRepository,
                         AiService aiService) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.ticketResponseRepository = (TicketResponseRepository) ticketResponseRepository;
        this.aiService = aiService;
    }

    public Ticket createTicket(TicketRequestDto dto) throws Exception {

        //  Validate user
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create ticket basic info
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setUser(user);
        ticket.setStatus("OPEN"); // default status

        // 3 Call AI service
        AiTicketAnalysis ai = aiService.analyzeTicket(dto.getDescription());

        ticket.setCategory(ai.getCategory());
        ticket.setPriority(ai.getPriority());

        // Assign team based on category
        if ("Billing".equalsIgnoreCase(ai.getCategory()))
            ticket.setAssignedTeam("BILLING_TEAM");
        else if ("Technical".equalsIgnoreCase(ai.getCategory()))
            ticket.setAssignedTeam("TECH_TEAM");
        else
            ticket.setAssignedTeam("SUPPORT_TEAM");

        // Save ticket
        Ticket saved = ticketRepository.save(ticket);

        // Save AI auto-reply
        TicketResponse response = new TicketResponse();
        response.setTicket(saved);
        response.setMessage(ai.getAutoReply());
        response.setAiGenerated(true);


        // Return saved ticket
        return saved;
    }
}
