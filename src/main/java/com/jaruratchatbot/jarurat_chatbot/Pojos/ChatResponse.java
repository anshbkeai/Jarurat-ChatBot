package com.jaruratchatbot.jarurat_chatbot.Pojos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatResponse {
    private String user_id;
    private String message;
    private String response;
    private LocalDateTime response_time;
}
