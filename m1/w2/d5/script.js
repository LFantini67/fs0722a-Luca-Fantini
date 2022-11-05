function aggiungiCifra(elemento){   //tramite la funzione aggiungiCifra ho consentito la visualizzazione dei tasti premuti sul display
    
    console.log(elemento.getAttribute('data-simbolo')); //tramite getAttribute sono andato a richiamare l'attributo personalizzato
    
    let cifraCliccata = elemento.getAttribute('data-simbolo');  

    document.getElementById('display').value += cifraCliccata;
}

function resettaValore(elemento){   //tramite la funzione resettaValore ho consentito lo svuotamento del display premendo il relativo tasto
    
    document.getElementById('display').value = ''
}

function radiceQuadrata(elemento){ //funzione per il calcolo della radice quadrata
    
    let numeri = document.getElementById('display');

    numeri.value = Math.sqrt(numeri.value);
}

function calcPercentuale(elemento){ //funzione per il calcolo percentuale (n*n1/100)
    
}

function tot(){ // tramite la funzione tot utilizzata mediante eval abbiamo trasformato la stringa in numero ed eeguito l'operazione richiesta
    
    let numeri = document.getElementById('display');

    numeri.value = eval(numeri.value);
}
