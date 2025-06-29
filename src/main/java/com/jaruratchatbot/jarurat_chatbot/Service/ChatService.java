package com.jaruratchatbot.jarurat_chatbot.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.jaruratchatbot.jarurat_chatbot.Pojos.ChatMessage;
import com.jaruratchatbot.jarurat_chatbot.Pojos.ChatResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatService {

    private FireBaseService fireBaseService;

    public ChatService(FireBaseService fireBaseService) {
        this.fireBaseService = fireBaseService;
    }

    // here. we nned. to. define to. handle. the.  data. simple. 
    public ChatResponse processChat(ChatMessage chatMessage) throws InterruptedException, ExecutionException {
        // now we. need to. get about. the. mesage adn. then. about to Search in. the db about that
        // ABOUT THAT simple 
        // find. that. i. the. 
        String message = chatMessage.getMessage();
        String response = fireBaseService.get_respsone_form_db(message);
        if(response == null) response = "❓ Sorry, unable to understand that.\nPlease try again by sending *Hi* to restart the conversation.";

        // proecess this. means about. fin. in. the.  db. 
        // save to chameg adn. response. also. 

        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setMessage(message);
        chatResponse.setResponse(response);
        chatResponse.setResponse_time(LocalDateTime.now());
        chatResponse.setUser_id(chatMessage.getUser_id());
        
       fireBaseService.saveMessage(chatMessage.getUser_id(), "User", message);
       fireBaseService.saveMessage(chatMessage.getUser_id(), "Bot", response);

       log.info("Data Added for. the User " + chatMessage.getUser_id());


        return chatResponse;
    }

}
