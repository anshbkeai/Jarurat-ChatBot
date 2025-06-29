import { ChatApi, fetch_User } from "./fetch_User.js";
const root = document.getElementById("root");
export  function Chat_Box_UI() {

    const chat_container = document.createElement("div");
    chat_container.className = "chat-container";

    const element =  `
       
        <div class="message-container">
            
        </div>

        <div class="message">
            <input type="text" 
                placeholder="Type your message..." class = "chat-input">
            <button class="send-btn">Send</button>
         
    
    `;
    chat_container.innerHTML = element;

     const input = chat_container.querySelector(".chat-input");
    const sendBtn = chat_container.querySelector(".send-btn");

    sendBtn.addEventListener('click', () => {
        const message = input.value; 
        //
        send_Message(message);
        input.value = ""; 
    });

    root.appendChild(chat_container);
    
}

export async function send_Message(message) {
    const send_Message_element = document.createElement("div");
    send_Message_element.className = "message sender-message";
    send_Message_element.innerHTML = `
                     ${message}
    `
    document.querySelector(".message-container").appendChild(send_Message_element);

    const resp  =await ChatApi({user_id:fetch_User() , message : message});


     const response_element = document.createElement("div");
    response_element.className = "message receiver-message";
    response_element.innerHTML = resp.response

    document.querySelector(".message-container").appendChild(response_element);






    // this is the fucnntion aboutt= that. will. sedn he. resp. to. the. aoi. ad about to
}