import { fetch_User } from "./fetch_User.js";
import { Chat_Box_UI } from "./UiManager.js";
const root = document.getElementById("root");

// Mobile menu toggle functionality
document.addEventListener('DOMContentLoaded', function() {
    const menuToggle = document.querySelector('[data-collapse-toggle="navbar-default"]');
    const menu = document.getElementById('navbar-default');
    
    if (menuToggle && menu) {
        menuToggle.addEventListener('click', function() {
            menu.classList.toggle('hidden');
        });
    }
});

const startChat_button = document.querySelector(".startChat");

console.log(startChat_button);

startChat_button.addEventListener('click' , () => {
    startChat();
})
function startChat() {
    //hey Genrate the random user id or fethc the. User id from. the localstorage
    const user_id = fetch_User();
    console.log(user_id);
    document.querySelector(".container").style.display = "none";
    
    //and aboout display about that chat Inbox 
    Chat_Box_UI();

}

