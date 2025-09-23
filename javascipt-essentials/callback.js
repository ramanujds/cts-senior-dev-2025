function greet(name, fun) {
    const greeting = `Hello, ${name}!`;
    fun(greeting);
}

function sayHello(message) {
    console.log(message);
}

greet('Alice', sayHello);

greet('Bob', (greeting) => {
    console.log(greeting.toUpperCase());
});

setTimeout(() => {
    console.log('This message is shown after 5 seconds');
}, 5000);

console.log('This message is shown immediately');

