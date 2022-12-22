interface ICapoAbbigliamento {
    id: number;
    codProd: number;
    collezione: string;
    capo: string;
    modello: number;
    quantità: number;
    colore: string;
    prezzoIvaEsclusa: number;
    prezzoIvaInclusa: number;
    disponibile: string;
    saldo: number;
}

abstract class CapoAbbigliamento implements ICapoAbbigliamento {
    id: number;
    codProd: number;
    collezione: string;
    capo: string;
    modello: number;
    quantità: number;
    colore: string;
    prezzoIvaEsclusa: number;
    prezzoIvaInclusa: number;
    disponibile: string;
    saldo: number;
    constructor(
        id: number,
        codProd: number,
        collezione: string,
        capo: string,
        modello: number,
        quantità: number,
        colore: string,
        prezzoIvaEsclusa: number,
        prezzoIvaInclusa: number,
        disponibile: string,
        saldo: number,
    ) {
        this.id = id;
        this.codProd = codProd;
        this.collezione = collezione;
        this.capo = capo;
        this.modello = modello;
        this.quantità = quantità;
        this.colore = colore;
        this.prezzoIvaEsclusa = prezzoIvaEsclusa;
        this.prezzoIvaInclusa = prezzoIvaInclusa;
        this.disponibile = disponibile;
        this.saldo = saldo;
    }

    getSaldoCapo(): number {
        return (this.prezzoIvaInclusa / 100) * this.saldo;
    }

    getAcquistoCapo(): number {
        return this.prezzoIvaInclusa - (this.prezzoIvaInclusa / 100) * this.saldo;
    }
}

const InventarioCapi = async function () {
    try {
        let descrizioneCapi = await fetch("https://mocki.io/v1/765b2daf-41d5-4e94-a0d5-abd918f57b8f");
        return descrizioneCapi.json();
    }
    catch {
        console.log("Loading Error");
    }
}

const descrizioneCapo = async function () {
    let listaCapi = await InventarioCapi();

    console.log(listaCapi);

    let dressCard = document.querySelector("#card");

    for (let singoloCapo of listaCapi) {
        let div = document.createElement("div");
        div.innerHTML = `
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <ul><h5 class="card-title">#ITEM</h5></ul>
    <li>${singoloCapo.id}</li>
    <li>${singoloCapo.codProd}</li>
    <li>${singoloCapo.collezione}</li>
    <li>${singoloCapo.capo}</li>
    <li>${singoloCapo.modello}</li>
    <li>${singoloCapo.quantità}</li>
    <li>${singoloCapo.colore}</li>
    <li>${singoloCapo.prezzoIvaEsclusa}</li>
    <li>${singoloCapo.prezzoIvaInclusa}</li>
    <li>${singoloCapo.disponibile}</li>
    <li>${singoloCapo.saldo}</li>
    <a href="#" class="btn btn-primary">AGGIUNGI AL CARRELLO</a>
  </div>
</div>`

        dressCard?.appendChild(div);

    }   
}
descrizioneCapo()




