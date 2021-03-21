export const person = {
    name: 'John',
    age: 30,
}

export function sayHello() {
    return `Hello ${person.name}`;
}

// Only a single default export allowed
const greeting = 'Hello World';
export default greeting;