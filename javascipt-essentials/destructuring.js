import { Person,Employee } from "./my-script.js";

const person1 = new Person('Alice', 30);

let {name,age} = person1;
console.log(`Name = ${name} & Age = ${age}`);

const users = ["Harsh", "John", "Doe"];

let [u1] = users;
console.log(`User 1 = ${u1}`);

// spread operator
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const arr3 = [arr1, arr2];

console.log(...arr1, ...arr2);

// rest operator
function sum(...numbers) {
    let total = 0;
    for (let num of numbers) {
        total += num;
    }
    return total;
}

console.log(`Sum = ${sum(1,2,3)}`);