package com.jaruratchatbot.jarurat_chatbot.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.jaruratchatbot.jarurat_chatbot.Pojos.ChatMessage;
import com.jaruratchatbot.jarurat_chatbot.Pojos.ChatResponse;

@Service
// this will help me. to get about the object about to read nad wirte the data
public class FireBaseService {

    private Firestore firestore;

    public FireBaseService(Firestore firestore) {
        this.firestore = firestore;
    }

    public String get_respsone_form_db(String message) throws InterruptedException, ExecutionException  {
        DocumentReference docRef = firestore.collection("Chats").document(message);
// asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...
        // future.get() blocks on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
        return document.getString("response");
    }

    public void saveMessage(String userId, String from, String message) {
            try {
                CollectionReference messagesRef = firestore
                    .collection("Users")
                    .document(userId)
                    .collection("messages");

                Map<String, Object> chatData = new HashMap<>();
                chatData.put("from", from);
                chatData.put("message", message);
                chatData.put("timestamp", Instant.now().toString());

            
                messagesRef.add(chatData);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
