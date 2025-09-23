// arrow function

const add = (a, b) => a + b;

let sum = add(5, 10);

// string interpolation
// console.log(`Sum = ${sum}`);

// OOP
// Class
// Abastraction, Encapsulation, Polymorohism, Inheritance

export class Person{
    name;
    age;

    constructor(name,age){
        this.name=name;
        this.age=age;
    }


    print(){
        console.log(`Name : ${this.name}`)
         console.log(`Age : ${this.age}`)
    }

}

// let person = new Person('Harsh',25);
// person.print()

export class Employee extends Person{
    salary;

    constructor(name,age,salary=0){
        super(name,age);
        this.salary=salary;
    }

    print(){
        super.print();
        console.log(`Salary : ${this.salary}`)
    }
}

// let emp = new Employee('Harsh',25);
// emp.print();


