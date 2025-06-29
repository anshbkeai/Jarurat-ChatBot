export function fetch_User() {
    let user_id = localStorage.getItem("user_id");
    if(!user_id){
            /// gernaye the new onw. 
            user_id = crypto.randomUUID();
            localStorage.setItem("user_id",user_id);
            return user_id;
    }
    return user_id;
    
}

export function ChatApi(chatMessage) {
    return fetch('https://jarurat-chatbot.onrender.com/webhook', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(chatMessage)
    })
    .then(resp => resp.json())
    .then(data => {console.log(data);  return data});

    
}


