

let id = 100;

if (id == 100) {
    console.log("Correct");
} else {
    console.log("Incorrect");
}

id = '100'

// no type checking here
if (id == 100) {
    console.log("Correct");
} else {
    console.log("Incorrect");
}

// Equal to value and type
if (id === 100) {
    console.log("Correct");
} else {
    console.log("Incorrect");
}

// an undeclared variable would result in an error, hence we need to check 
if(typeof id != undefined){
    console.log(`The ID is ${id}`);
} else {
    console.log('No ID');
}

const name = 'Steve';
const age = 20;

if(age > 0 && age < 12){
    console.log(`${name} is a child`);
} else if (age >= 13 && age <= 19) {
    console.log(`${name} is a teenager`);
} else {
    console.log(`${name} is an adult`);
}

// braces are not required, but preferable
if(id === 100)
    console.log('Correct');
    console.log("Another log");

console.log(new Date().getDay());

let day;

switch(new Date().getDay()) {
    case '0' : 
        day = "Sunday";
        break;
    case '1' : 
        day = "Monday";
        break;
    case '2' : 
        day = "Tuesday";
        break;
    case '6' : 
        day = "Saturday";
        break;
    default :
        day = "No day given"
}

console.log(`The day is ${day}`);
