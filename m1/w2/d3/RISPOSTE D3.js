/* 
RISPOSTA ESERCIZIO 1
*/

var numero=new Array(5, 10);
function maxNum(arr)
{
var max = Math.max.apply(null, arr);
return max;
}

document.write("Il numero più alto è: "+maxNum(numero))

/* 
let x=4
let y=7

if (x>y){
  console.log('Il numero più grande è', x)
}
else if (x<y){
  console.log('Il numero più grande è', y)
}
else{
  console.log('I numeri sono uguali')
}
*/

/* 
RISPOSTA ESERCIZIO 2
*/

var x = 5;
var y

console.log(x != y);
if(x != y){
    document.write('not equal');
}

/* 
RISPOSTA ESERCIZIO 3
*/

var x;
var risultato = (x % 5);

if (risultato > 0){
    document.write('divisibile per 5')
}

/* 
RISPOSTA ESERCIZIO 4

Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

/* 
RISPOSTA ESERCIZIO 5
*/

var totalShoppingCart;

console.log(totalShoppingCart > 50);
console.log(totalShoppingCart <= 50;

if(totalShoppingCart > 50){
document.write('Spedizione gratuita');

}else (totalShoppingCart <= 50){
document.write('Spedizione 10€');
}

/* 
RISPOSTA ESERCIZIO 6
*/

if(totalShoppingCart > 50){
document.write(20% di sconto extra)
}

/* 
RISPOSTA ESERCIZIO 7
*/

var numero = new Array(5, 21, 13);

numero.sort(function(a, b) {
    return b - a;
})

console.log(numero);

/* 
RISPOSTA ESERCIZIO 8
*/

console.log(typeof x =="number");

/* 
RISPOSTA ESERCIZIO 9
*/

var x;
var risultato = (x % 2);

if (risultato > 0){
    document.write('pari')
}

/*
ESERCIZIO 10
*/

  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }

/*  
RISPOSTA ESERCIZIO 11
*/

const me = {
    name: 'John',
    lastName: 'Doe',
    skills: ['javascript', 'html', 'css'],
  };

me.city = 'Toronto';

/*
RISPOSTA ESERCIZIO 12
*/

delete me.lastName;

/*
RISPOSTA ESERCIZIO 13
*/

me.pop();

/* 
RISPOSTA ESERCIZIO 14
*/

var numeri = new Array();
numeri.push(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

/*
RISPOSTA ESERCIZIO 15
*/

numeri.pop();
numeri.push(100);