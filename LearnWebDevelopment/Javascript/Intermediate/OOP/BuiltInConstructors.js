// String

const name1 = "Jeff";
const name2 = new String("Jeff");
// we can add properties since it's an object
name2.foo = 'bar';

const typeOne = typeof name1; // String
const typeTwo = typeof name2; // Object

let triple = (input, value) => {
    if(input === value) {
        console.log('Triple YES');
    } else {
        console.log('Triple NO');
    }
}
let double = (input, value) => {
    if(input == value) {
        console.log('Double YES');
    } else {
        console.log('Double NO');
    }
}

// Primitive. Type and Value same. Pass
triple(name1, 'Jeff');
// Type is not equal. Fails.
triple(name2, 'Jeff');
// Value matches. Pass.
double(name2, 'Jeff');

// Number
const num1 = 5;
const num2 = new Number(5);

// Boolean 
const bool1 = true;
const bool2 = new Boolean(true);

// Functions
const getSum1 = function(x, y) {
    return x + y;
}
getSum1(2,3);

const getSum2 = new Function('x', 'y', 'return 1 + 1');
getSum2(2,3);

// Arrays
const arr1 = [1,2,3];
const arr2 = new Array(1,2,3);

// Regular Expressions
const re1 = /\w+/;
const re2 = new RegExp('\\w+');