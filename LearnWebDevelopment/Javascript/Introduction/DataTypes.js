// Primitive Types

// String
let name = "Arjun";
// Number
let num = 5;
// there are some special number values such as infinity and negative infinity
let isInfinity = 1/0;
let isNegativeInfinity = -1/0;
// and then we also have NaN, which is not a number
let nan = 'arjun'/100;

// BigInt : recently introduced, not fully supported
// for values larger than 2^53, which btw is sixteen decimal digits
// the "n" at the end means it's a BigInt
const bigInt = 1234567890123456789012345678901234567890n;

// Boolean
let bool = true;
// Null
let nullVariable = null;
// Undefined
let emptyIsUndefined;


// Normally we use
// null to represent empty or unknown values
// undefined to check whether a variable has been assigned a value or not

// Symbol
const sym = Symbol();

console.log(typeof sym);

 
// Reference Data Types 

// Arrays
const arr = [1,2,3,4,5];
// Object Literal
const sampleObject = {firstName:"Arjun",secondName:"Khera"};
// Date
const sampleDate = new Date();

console.log(sampleObject);  
console.log(typeof sampleObject);