package com.jaruratchatbot.jarurat_chatbot.Config;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class FireBaseConfiguration {

    private static final String SERVICE_ACCOUNT_KEY_PATH = "/Users/ansh/Desktop/to_do_list/Spring_boot_projects/Clone/jarurat-chatbot/src/main/resources/jarurat-chatbot-firebase-adminsdk-fbsvc-eefb46ba3d.json";
    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        try (FileInputStream serviceAccount = new FileInputStream(SERVICE_ACCOUNT_KEY_PATH)) {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) { // Ensure FirebaseApp is initialized only once
                FirebaseApp.initializeApp(options);
                log.info("Firebase app initialized successfully for project: jarurat-chatbot");
            }
        } catch (IOException e) {
            log.warn("Error initializing Firebase: " + e.getMessage());
            throw e; // Re-throw to prevent application startup if Firebase init fails
        }
    }

    @Bean
    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }

    
    /*
     * 
     * 
     * import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    private static final String SERVICE_ACCOUNT_KEY_PATH = "src/main/resources/jarurat-chatbot-service-account.json"; // Update this path if needed

    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        try (FileInputStream serviceAccount = new FileInputStream(SERVICE_ACCOUNT_KEY_PATH)) {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) { // Ensure FirebaseApp is initialized only once
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase app initialized successfully for project: jarurat-chatbot");
            }
        } catch (IOException e) {
            System.err.println("Error initializing Firebase: " + e.getMessage());
            throw e; // Re-throw to prevent application startup if Firebase init fails
        }
    }

    @Bean
    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}

     * 
     */
}
