class Person {

    age;
    name;

    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    get age() { return this.age; }
    get name() { return this.name; }

    comparaEtà(Person) {
      return  `${this.name} è ${(this.age > Person.age) ? 'più vecchio' : 'più giovane'} di ${Person.name}`;
    }
}

const p1 = new Person('Luca', 27);
const p2 = new Person('Francesco', 35);
const p3 = new Person('Giuseppe', 25);

console.log(p1.comparaEtà(p2));