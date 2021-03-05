// Log to console
console.log("Hello World");
// numbers and boolean values are printed in blue on the console
console.log(123); 
console.log(true);

var greeting = 'Hello';
console.log(greeting);
console.log([1,2,3]);
console.log({a:1, b:2});
// Pretty print object key's and value's
console.table({a:1, b:2});

console.error('This is some error');
console.clear();
console.warn("This is a warning");

console.time("Timer");
    console.log("Hello");
    console.log("Another Hello");
console.timeEnd("Timer");