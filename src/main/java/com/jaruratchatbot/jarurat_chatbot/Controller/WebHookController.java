package com.jaruratchatbot.jarurat_chatbot.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.jaruratchatbot.jarurat_chatbot.Pojos.ChatMessage;
import com.jaruratchatbot.jarurat_chatbot.Pojos.ChatResponse;
import com.jaruratchatbot.jarurat_chatbot.Service.ChatService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class WebHookController {
    // this is dependet upon the chat servie
    private ChatService chatService;

    public WebHookController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/webhook")
   @Operation(
        summary = "Process chat message",
        description = "Receives a chat message and returns the chatbot's response."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Successful response with chatbot reply"
    )
    public ChatResponse postMethodName(@RequestBody @Valid ChatMessage chatMessage) {
        //TODO: process POST request
        try {
            return chatService.processChat(chatMessage);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
        
        
    }

    
}
