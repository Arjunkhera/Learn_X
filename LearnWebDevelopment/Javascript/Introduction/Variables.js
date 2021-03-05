// Primitive Data Types

// Variables

var name = 'Arjun Khera';
console.log(name);
name = "Goku";
console.log(name);

// initializing
var greeting;
console.log(greeting);
greeting = 'Hello';
console.log(greeting);

// naming variables
// letters, numbers, _, $
// cannot start with a number

// starting with $ is preferred when using jquery
// _variableName is used for private variables

var firstName = 'arjun';    // Camel case
var first_name = 'khera';   // Underscore
var FirstName = 'arjun khera';  // Pascal case, preferred for constructors and classes

// CONST

const constantName = 'constant';
console.log(constantName);

// cannot reassign
// constantName = "arjun";

// need to initialise with a value
// const greeting;

// const objects can be changed but not reassigned
const person = {
    name: "ram",
    age: "12"
}
console.log(person);

person.name = "shyam";
person.age  = '13';
console.log(person);

// same goes for arrays
const exampleArray = [1,2,3];
console.log(exampleArray);

exampleArray.push(4);
console.log(exampleArray);

// cannot reassign
// exampleArray = [1,2,3,4];
