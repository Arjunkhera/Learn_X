const first = 100;
const second = 200;
let val;

// Math object
val = Math.PI;
val = Math.E;
val = Math.round(2.4);
val = Math.ceil(2.4);
val = Math.floor(2.4);
val = Math.sqrt(64);
val = Math.abs(-20);
val = Math.pow(8,2);
val = Math.min(1,2,3,4,-2);
val = Math.max(1,2,3,4);

// range is between 0 and 1, decimal
val = Math.random();

// Changing the range to 1 and 20, and ensuring whole numbers
val = Math.floor(Math.random() * 20 + 1);

console.log(val);