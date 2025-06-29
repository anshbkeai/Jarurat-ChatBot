package com.jaruratchatbot.jarurat_chatbot.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jaruratchatbot.jarurat_chatbot.Pojos.ChatResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ChatResponse> handleRuntimeException(RuntimeException ex) {
        // Customize the response as needed
       ChatResponse chatResponse = new ChatResponse();
        chatResponse.setMessage("NUll");
        chatResponse.setResponse("null");
        chatResponse.setResponse_time(LocalDateTime.now());
        chatResponse.setUser_id("NULL");

        return new ResponseEntity<ChatResponse>(chatResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
