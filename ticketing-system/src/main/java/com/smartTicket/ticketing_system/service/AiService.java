package com.smartTicket.ticketing_system.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartTicket.ticketing_system.dto.AiTicketAnalysis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//This steps when we have the paid Api OpenAi key
//@Service
//public class AiService {
//
//    @Value("${ai.openai.api-key}")
//    private String apiKey;
//
//    private final ObjectMapper mapper = new ObjectMapper();
//
//    public AiTicketAnalysis analyzeTicket(String text) {
//
//        try {
//
//            String prompt = """
//            Analyze this customer support ticket.
//
//            Classify:
//            - category (Billing, Technical, Account, General)
//            - priority (High, Medium, Low)
//            - short auto reply message
//
//            Return JSON only:
//            {
//              "category": "...",
//              "priority": "...",
//              "autoReply": "..."
//            }
//
//            Ticket:
//            %s
//            """.formatted(text);
//
//            String requestBody = """
//            {
//              "model": "gpt-4.1-mini",
//              "messages": [
//                {"role": "user", "content": "%s"}
//              ]
//            }
//            """.formatted(prompt.replace("\"","\\\""));
//
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
//                    .header("Authorization", "Bearer " + apiKey)
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//
//            HttpResponse<String> response =
//                    HttpClient.newHttpClient()
//                            .send(request, HttpResponse.BodyHandlers.ofString());
//
//            // Extract AI message content
//            JsonNode root = mapper.readTree(response.body());
//            String content = root
//                    .get("choices").get(0)
//                    .get("message").get("content").asText();
//
//            return mapper.readValue(content, AiTicketAnalysis.class);
//
//        } catch (Exception e) {
//            throw new RuntimeException("AI processing failed", e);
//        }
//    }
//}

//USing free method now
@Service
public class AiService {

    public AiTicketAnalysis analyzeTicket(String text) {

        AiTicketAnalysis ai = new AiTicketAnalysis();

        // Simple rule-based logic (like fake AI)
        if (text.toLowerCase().contains("payment") || text.toLowerCase().contains("refund")) {
            ai.setCategory("Billing");
            ai.setPriority("HIGH");
            ai.setAutoReply("Your billing issue has been received. Our team will contact you soon.");
        }
        else if (text.toLowerCase().contains("login") || text.toLowerCase().contains("password")) {
            ai.setCategory("Authentication");
            ai.setPriority("MEDIUM");
            ai.setAutoReply("Please try resetting your password. If issue continues, contact support.");
        }
        else {
            ai.setCategory("General");
            ai.setPriority("LOW");
            ai.setAutoReply("Thank you for contacting support. We will review your issue.");
        }

        return ai;
    }
}
