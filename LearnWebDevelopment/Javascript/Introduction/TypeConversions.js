// Type conversion
// we do that explicitly

let val;

// Number to String
val = String(555);
// Boolean to String
val = String(true);
// Date to String
val = String(new Date());
// Array to String
val = String([1,2,3]);

// toString()
val = (5).toString();

// Output
console.log(val);
console.log(typeof val);
console.log(val.length);

let num;

// String to number
num = Number('5');
num = parseInt('100.30');
num = parseFloat('100.30');

// we can replace Number() call with +
// the following is the same as Number('5')
num = +"5";

// Boolean to number
num = Number(true);

num = Number(null);
num = Number('hello');
num = Number([1,2,3]);


// Output
console.log(num);
console.log(typeof num);
console.log(num.toFixed(2));

// Type coercion
// javascript does it for us
const firstNumber = String(24);
const secondNumber = 5;

const sum = firstNumber + secondNumber;
console.log(sum);
console.log(typeof sum);