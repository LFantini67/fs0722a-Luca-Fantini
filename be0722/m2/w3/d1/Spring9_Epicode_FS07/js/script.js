//alert("ciao");

document.addEventListener("DOMContentLoaded", ()=>{
    let button = document.querySelector("#signup");
    button.addEventListener("click", registrazione)
})

let registrazione = (e)=>{
e.preventDefault();

let name = document.querySelector("#name");
let username = document.querySelector("#username");
let email = document.querySelector("#email");
let password = document.querySelector("#password");

let obj = {
    name: name.value,
    username: username.value,
    email: email.value,
    password: password.value,
    roles:["ROLE_USER"]
 }

 fetch('http://localhost:8080/api/auth/register', {
  method: 'POST',
  body: JSON.stringify( obj ),
  headers: {
    'Content-type': 'application/json; charset=UTF-8',
  },
})
  .then((response) => console.log(response))

}


