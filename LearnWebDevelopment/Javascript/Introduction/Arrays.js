const numbers = [43,56,33,23,44,36,5];
const numbers2 = new Array(22,45,33,76,54);

const vehicles = ['car','bus','train'];
const mixed = [22,'Hello', true, undefined, null, {a:1, b:1}, new Date()];

let val;

// get array length
val = numbers.length;
// check if its an array
val = Array.isArray(numbers);
// get a single value
val = numbers[2];
// insert into array
numbers[2] = 100;
// find index of value
val = numbers.indexOf(36);

// Mutating arrays
// add from last
numbers.push(250);
// add from front
numbers.unshift(120);
// remove from end
numbers.pop();
// remove from front
numbers.shift();


// slice, splice and split

// slice returns new array without modifying the original
numbers.slice(1,3);

// splice, modifies the existing array

// removes 1 element, at index 1
numbers.splice(1,1);
// we can also add elements using splice

// split is used for turning strings into arrays, does not modify the original string
let url = "https://www.freecodecamp.org/news/lets-clear-up-the-confusion-around-the-slice-splice-split-methods-in-javascript-8ba3266c29ae/";
url.split("/");

// the following will simply convert the string into array with every character as an element
// url.split("");


numbers.reverse();

// concatenate arrays
val = numbers.concat(numbers2);

// sorting arrays
val = vehicles.sort();
// sorts by first digit, not the whole number
val = numbers.sort();

// to sort by integer value
val = numbers.sort(function(x, y){
    return x - y;
});

// reverse the sorting order
val = numbers.sort(function(x, y){
    return y - x;
})

// Find
function under50(num) {
    return num < 50;
}

val = numbers.find(under50);


console.log(numbers);
console.log(val);