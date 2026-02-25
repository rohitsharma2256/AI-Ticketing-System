package com.smartTicket.ticketing_system.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartTicket.ticketing_system.AiProvider;
import com.smartTicket.ticketing_system.dto.AiTicketAnalysis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//This Class is now Disabled by default bcz @profile is there
@Service
//Spring loads it ONLY when profile is enabled.
@Profile("openai")    //it will ony active when profile = openai (when add OpenAi APi key)
public class OpenAiProvider implements AiProvider {

    @Value("${ai.openai.api-key}")
    private String apiKey;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public AiTicketAnalysis  analysisTicket(String text){
        try {
             //Promt Engineering
            String prompt = """
        Analyze this customer support ticket.

        Classify:
        - category (Billing, Technical, Account, General)
        - priority (High, Medium, Low)
        - short auto reply message

        Return JSON only:
        {
          "category": "...",
          "priority": "...",
          "autoReply": "..."
        }

        Ticket:
        %s
        """.formatted(text);

            // Escape quotes so JSON stays valid
            String escapedPrompt = prompt.replace("\"", "\\\"");

            String requestBody = """
        {
          "model": "gpt-4o-mini",
          "messages": [
            {"role": "user", "content": "%s"}
          ]
        }
        """.formatted(escapedPrompt);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response =
                    HttpClient.newHttpClient()
                            .send(request, HttpResponse.BodyHandlers.ofString());

            // Parse OpenAI response
            JsonNode root = mapper.readTree(response.body());

            String content = root
                    .get("choices").get(0)
                    .get("message").get("content")
                    .asText();

            // Convert returned JSON → Java object
            return mapper.readValue(content, AiTicketAnalysis.class);

        } catch (Exception e) {
            throw new RuntimeException("OpenAI ticket analysis failed", e);
        }
    }

}
