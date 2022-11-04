function aggiungiCifra(elemento){
    
    console.log(elemento.getAttribute('data-simbolo'));
    
    let cifraCliccata = elemento.getAttribute('data-simbolo');

    document.getElementById('display').value += cifraCliccata;
}

function resettaValore(elemento){
    
    document.getElementById('display').value = ''
}

function radiceQuadrata(elemento){
    
    let numeri = document.getElementById('display');

    numeri.value = Math.sqrt(numeri.value);
}

function tot(){
    
    let numeri = document.getElementById('display');

    numeri.value = eval(numeri.value);
}
