const firstName = "arjun";
const lastName = "khera";

let val;

val = firstName + lastName;

// Concatenation
val = firstName + " " + lastName;

// Append
val = "Son"
val += "Goku";

// Escaping
val = 'Using single quotes. That\'s awesome';

// Length, here its a property and not a method
val = firstName.length;

// Concat method
val = firstName.concat(' ', lastName);

// Change case
val = firstName.toUpperCase();
val = firstName.toLowerCase();

val = firstName[2];

// indexOf, provides the index of the first occurence of a given character
val = firstName.indexOf('r');
// traverse the string from back for the first occurence of a given character
val = firstName.lastIndexOf('a');

// charAt()
val = firstName.charAt(2);
// get last character of string
val = firstName.charAt(firstName.length - 1);


// substring
val = firstName.substring(0,4);

// slice : return substrings or subarrays
val = firstName.slice(0,4);
val = firstName.slice(-2);

val = 'Hello there, my name is Arjun';
// split
val = val.split(' ');

// replace : single instance
val = "This is so awesome removeMe".replace("removeMe","I love it!");
// replaceAll : all instances
val = "This is 1 and now 2 again 1".replaceAll("1", "3");

// includes()
val = "just random string here".includes('random');
val = "just random string here".includes('is');

console.log(val);

