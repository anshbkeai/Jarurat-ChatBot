package com.jaruratchatbot.jarurat_chatbot.Pojos;

import com.google.firebase.database.annotations.NotNull;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

// this is the response Chat Message that we will respsone to the user about the from to whoc
@Data
public class ChatMessage {
    @NotNull
    private String user_id;
    @NotEmpty
    private String message;

   
}
