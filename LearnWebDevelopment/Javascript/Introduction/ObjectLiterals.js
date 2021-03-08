// Two ways of declaring an object
// const objFirst = new Object{};
const objSecond = {};

const person = {
    // Keys are always strings
    // Reserved words are allowed as property names
    firstName : 'arjun',
    lastName : 'khera',
    age : 23,
    email : 'arkhera@adobe.com',
    hobbies : ['music','video games'],
    address : {
        city : 'Delhi',
        state : 'New Delhi',
    },
    // multi word properties should be double quoted
    "multi word" : "some random value",
    // last property can end with a comma
    getDOB : function() {
        return 2019 - this.age;
    },
}

let val;

val = person;
// get specific value
val = person.firstName;
val = person['lastName'];
val = person.age;
val = person.hobbies[1];
val = person.address.state;
val = person.address['city'];
val = person.getDOB();

// Deleting a property
delete val.firstName;

// Computed Properties
// the key value is decided at runtime
let fruit = prompt("Which fruit to buy?", "apple");

let bag = {
  [fruit]: 5, // the name of the property is taken from the variable fruit
};
alert( bag.apple ); // 5 if fruit="apple"

console.log(val);

// Shorthand notation
function makeUser(name, age) {
    return {
      name, // same as name: name
      age   // same as age: age
      // ...
    };
}

// Traversing objects
const people = [
    {name : "Arjun", age: 23},
    {name : "Ram", age : 13}
];

// Simple for loop
for(let i = 0; i < people.length; i++) {
    console.log(people[i].name + " " + people[i].age);
}

// Using for in
for(key in people) {
    console.log(`${key} : ${people[key]}`);
}

// In is also used to check whether a key exists or not
let key = "property to check";
if(key in people) {
    console.log("Property exists");
} else {
    console.log("Property does not exist");
}

// Cloning objects
const clone = Object.assign(people);

// Deep Copy