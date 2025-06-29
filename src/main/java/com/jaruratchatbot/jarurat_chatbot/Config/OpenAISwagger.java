package com.jaruratchatbot.jarurat_chatbot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAISwagger {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Jarurat Chatbot — Assignment API Testing ")
                    .description("This chatbot project demonstrates a stateless conversation flow using Firestore, built as part of an internship assignment by Vedansh")
                    
                    );
                
    }
}
