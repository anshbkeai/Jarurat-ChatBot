

---

# 🤖 Jarurat Chatbot — Internship Assignment Submission

This repository contains a **Spring Boot + Firebase** project built as part of an **internship assignment** for **Jarurat Care Foundation**.
The chatbot simulates a WhatsApp chatbot backend by providing predefined responses to user queries and storing chat history in **Firebase Firestore**.

It is deployed and fully testable through a web-based UI (no WhatsApp API key required).

---
⚠️ **Cold Start Notice**  
This application is deployed on Render's free tier, which may put services to sleep after inactivity.  
When first accessed, the backend may take **30–50 seconds** to wake up and respond.  
Please be patient — this is normal and only happens on the first request after a period of idleness.

## 📌 Project Purpose

The goal of this project is to build the **backend logic** for a WhatsApp chatbot using:

* Java & Spring Boot
* Firebase (Firestore)
* Deployment on Render

The chatbot simulates:

* Stateless conversations
* Predefined response flows
* Chat history per user

---

## 🏗️ Project Architecture

```
jarurat-chatbot/
├── Controller/
│   └── WebHookController.java     # Entry point for chat messages (POST /webhook)
├── Service/
│   ├── ChatService.java           # Handles message logic
│   └── FireBaseService.java       # Firestore operations
├── Pojos/
│   ├── ChatMessage.java           # Request DTO
│   └── ChatResponse.java          # Response DTO
├── JaruratChatbotApplication.java # Spring Boot main app
├── resources/
│   ├── application.properties     # Spring config
│   └── firebase-service-account.json (excluded from repo)
└── pom.xml
```

---

## 🔥 Features Implemented

* ✅ **POST `/webhook`** endpoint for receiving and responding to user messages
* ✅ **Stateless chatbot logic** using Firestore as the message source
* ✅ **User message logging**: chat saved to `/users/{userId}/messages` in Firebase
* ✅ **Predefined message-response mapping** using `bot_flows` collection
* ✅ **Fallback/default response** if no match is found
* ✅ **Render Deployment** (Spring Boot backend & static frontend)
* ✅ **Frontend Testing UI**: Basic HTML/JS interface to test flow using generated UUID
* ✅ **CORS enabled** for cross-origin testing
* ✅ **Error handling & clean logging**
* ✅ **Future-extensible structure**: stateful chat & WhatsApp API can be added

---

## 💡 Technologies Used

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java 21            | Core backend development        |
| Spring Boot 3.2.x  | REST API framework              |
| Firebase Firestore | Stores messages and responses   |
| Firebase Admin SDK | Server-side integration         |
| Maven              | Build and dependency management |
| Lombok             | Reduces boilerplate in Java     |
| SpringDoc OpenAPI  | (Optional) API documentation    |
| Render             | Deployment platform             |
| HTML/CSS/JS        | Test UI frontend                |

---

## 🧪 How to Test

> ✅ Hosted frontend & backend are deployed separately on Render.

### 🌐 Frontend (Test UI)

> [🔗 Chatbot UI on Render](https://your-ui.onrender.com)

* Automatically generates a `userId`
* Lets you send test messages (e.g., `"Hi"`, `"1"`, `"delhi"`)
* Messages sent to `/webhook` and responses shown on screen

### 🔁 API Endpoint

> [🔗 POST `/webhook`](https://your-api.onrender.com/webhook)

#### Sample Request:

```json
{
	"user_id":"Java",
    "message":"Do I have gallbladder cancer?"

     
}
```

#### Sample Response:

```json
{
    "user_id": "Java",
    "message": "Do I have gallbladder cancer?",
    "response": "\"📘 *Health Overview*\\n\\n🩺 *Symptoms:*  \\nCommon symptoms include abdominal pain, nausea, jaundice, unexplained weight loss, fever, fatigue, dark urine, and pale stools.  \\n👉 Consult a healthcare provider if you experience any of these.\\n\\n🧪 *Diagnosis:*  \\nConfirmed through blood tests (liver function tests, CA 19-9), imaging tests (ultrasound, MRI, CT scan, PET scan), and biopsy.\\n\\n👨‍⚕️ *Consultation:*  \\nEssential for personalized assessment. Discuss symptoms, comorbidities (like diabetes or hypertension), and treatment options with your healthcare provider.\"",
    "response_time": "2025-06-28T23:16:10.714853"
}
```

---

## 📚 Firestore Collections

| Collection                | Purpose                                            |
| ------------------------- | -------------------------------------------------- |
| `Chats`               | Stores predefined responses (e.g., `"Hi"` → reply) |
| `Users/{userId}/messages` | Stores full user-bot chat history                  |

---

## 🚀 Deployment

| Service     | URL                             |
| ----------- | ------------------------------- |
| Backend API | `https://your-api.onrender.com` |
| Frontend UI | `https://your-ui.onrender.com`  |

You can replace these with actual links before finalizing.

---

## ✅ Completed Aspects vs. Requirements

| Requirement                       | Status                                                 |
| --------------------------------- | ------------------------------------------------------ |
| Spring Boot chatbot backend       | ✅ Done                                                 |
| Webhook simulation                | ✅ Done                                                 |
| Firebase Firestore integration    | ✅ Done                                                 |
| Render deployment                 | ✅ Done                                                 |
| REST API with message mapping     | ✅ Done                                                 |
| Chat history logging              | ✅ Done                                                 |
| UI for testing                    | ✅ Bonus                                                |
| WhatsApp Business API integration | ⚠️ Simulated only (permitted for test)                 |

---

## 🚧 Future Enhancements

* Add support for stateful conversation tracking
* Connect to Meta WhatsApp Business API
* Add Admin panel to manage bot\_flows from UI
* Enhance UI with chat bubbles & UX polish
* Write JUnit test cases for `ChatService`

---

## 🙏 Acknowledgement

This project was developed as part of the **Jarurat Care Foundation internship assignment**.
Special thanks to the team for a meaningful challenge and mission-driven context.

---
