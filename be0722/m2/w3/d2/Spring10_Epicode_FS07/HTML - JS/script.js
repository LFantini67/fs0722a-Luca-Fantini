

function recuperaUtentiJSON() {
    let tBody = document.querySelector('tbody');
    tBody.innerHTML = '';
    fetch("http://localhost:8083/be/persone").then((response) => response.json()).then((data) => {
        data.forEach(element => {
            let tr = document.createElement('tr');
            tr.innerHTML = `<td>${element.id}</td>
                            <td>${element.nome}</td>
                            <td>${element.cognome}</td>
                            <td>${element.eta}</td>
                            <td><button onclick=elimina(${element.id}) type="button" class="btn btn-danger">Danger</button></td>`;
            
                            tBody.appendChild(tr);               
        });
    });
}
recuperaUtentiJSON();
function elimina(id) {
    fetch("http://localhost:8083/be/persone/"+id, {method:'DELETE'}).then((response) => recuperaUtentiJSON());
}

