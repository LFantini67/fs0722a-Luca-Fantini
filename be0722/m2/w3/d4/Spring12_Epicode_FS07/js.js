//console.log(rxjs);

const {of, from, pipe, Observable} = rxjs

const{filter, map, min}=rxjs.operators

let num = of(44,32,53,84).pipe(
    filter(e=> e > 50),
    map(e=> e * 2),
    min()
);

//num.subscribe(n=>console.log(n));


let x = from([1,2,3,4,5]);
//x.subscribe(n=>console.log(n))


const obs = new Observable(
    subscriber=> {
        subscriber.next("ciao");
        subscriber.next("ciao 2");
        subscriber.next("ciao 3");
        setTimeout(()=>{
            subscriber.next("ciao ritardato");
        }, 3000 );

        setTimeout(()=>{
            subscriber.next("ciao ritardato di più");
        }, 5000 );

        //subscriber.error("errore 404");
        
        subscriber.complete();
    }
);

obs.subscribe(
    e=>console.log(e),
    err=>console.log(err),
    ()=>console.log("fine")
    );


const url = "https://jsonplaceholder.typicode.com/users";
let promise = fetch(url).then(response=>response.json());
let obsAjax = from(promise);
obsAjax.subscribe(
    e=>console.log(e),
    err=>console.log(err)
    );
//console.log(promise)


