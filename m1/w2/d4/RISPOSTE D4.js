const starWarsCharacters = [
    {
      name: "Luke Skywalker",
      height: "172",
      mass: "277",
      hair_color: "blond",
      skin_color: "fair",
      eye_color: "blue",
      birth_year: "19BBY",
      gender: "male"
    },
    {
      name: "C-3PO",
      height: "167",
      mass: "75",
      hair_color: "n/a",
      skin_color: "gold",
      eye_color: "yellow",
      birth_year: "112BBY",
      gender: "n/a"
    },
    {
      name: "R2-D2",
      height: "96",
      mass: "32",
      hair_color: "n/a",
      skin_color: "white, blue",
      eye_color: "red",
      birth_year: "33BBY",
      gender: "n/a"
    },
    {
      name: "Darth Vader",
      height: "202",
      mass: "136",
      hair_color: "none",
      skin_color: "white",
      eye_color: "yellow",
      birth_year: "41.9BBY",
      gender: "male"
    },
    {
      name: "Leia Organa",
      height: "150",
      mass: "49",
      hair_color: "brown",
      skin_color: "light",
      eye_color: "brown",
      birth_year: "19BBY",
      gender: "female"
    },
    {
      name: "Owen Lars",
      height: "178",
      mass: "120",
      hair_color: "brown, grey",
      skin_color: "light",
      eye_color: "blue",
      birth_year: "52BBY",
      gender: "male"
    },
    {
      name: "Beru Whitesun lars",
      height: "165",
      mass: "75",
      hair_color: "brown",
      skin_color: "light",
      eye_color: "blue",
      birth_year: "47BBY",
      gender: "female"
    },
    {
      name: "R5-D4",
      height: "97",
      mass: "32",
      hair_color: "n/a",
      skin_color: "white, red",
      eye_color: "red",
      birth_year: "unknown",
      gender: "n/a"
    },
    {
      name: "Biggs Darklighter",
      height: "183",
      mass: "84",
      hair_color: "black",
      skin_color: "light",
      eye_color: "brown",
      birth_year: "24BBY",
      gender: "male"
    },
    {
      name: "Obi-Wan Kenobi",
      height: "182",
      mass: "77",
      hair_color: "auburn, white",
      skin_color: "fair",
      eye_color: "blue-gray",
      birth_year: "57BBY",
      gender: "male"
    }
  ];

/*
RISPOSTA ESERCIZIO 1
Crea una variabile chiamata "characters" e inserisci un array vuoto
*/

let characters = [];

/* 
RISPOSTA ESERCIZIO 2
*/

for (let i of starWarsCharacters){
    characters[i] = starWarsCharacters[i].name;
}

/*
RISPOSTA ESERCIZIO 3
*/

let femaleCharacters = [
    {
      name: "Leia Organar",
      hair_color: "brown",
      eye_color: "brown",
      birth_year: "19BBY",
    }
]

/*
RISPOSTA ESERCIZIO 4
*/

  let eyeColor = {
    blue = [],
    yellow = [],
    brown = [],
    red = [],
    blue-gray = [],
  }

/* ESERCIZIO 5
  Inserisci l'oggetto dei personaggi in "starWarsCharacters" nell'array corrispondente al colore dei loro occhi nell'oggetto "eyeColor" precedentemente creato
  Utilizza uno switch statement per determinare in quale proprietà inserire il personaggio
  */

  switch (starWarsCharacters){

  }


