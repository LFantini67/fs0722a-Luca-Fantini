(async () => {
    const response = await fetch("users.json");
    const datiJson = await response.json();
    console.log(datiJson);

    /*document.getElementById("male-name").innerHTML = datiJson[0].firstName + " " + datiJson[0].lastName;
    document.getElementById("male-email").innerHTML = datiJson[0].email;
    document.getElementById("female-name").innerHTML = datiJson[1].firstName + " " + datiJson[1].lastName;
    document.getElementById("female-email").innerHTML = datiJson[1].email;
    */


    let users = document.querySelector("#users");

    for (let person of datiJson) {

        let div = document.createElement("div");
        div.innerHTML = `
        <div> 
            <img src=${person.profileURL}>
            <p>${person.firstName + " " + person.lastName}</p>
            <a href=${person.email}>${person.email}</a>
        </div>
                        `

        users.appendChild(div);
    };
}

)
    ();



