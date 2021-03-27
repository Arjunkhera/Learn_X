let val;

// Creating a new object 
let user = {}; // object literal syntax

user = {
    firstName: 'Arjun',
    // using comma for last value
    // makes copy and paste easy
    "lastName": 'Khera',
};

// reading keys

// dot notation
console.log(user.firstName);
// square bracket notation
console.log(user["firstName"]);

// multi value key names only work in square brackets
user['Multi Value Property'] = 'Random Value';


// we can also use expressions in square brackets
let unknownKeyName = prompt('Give me a key name', "unknownKey");
user[unknownKeyName] = "User created run time key";

let hobby = prompt('Hobby', 'Gaming');
let hobbies = {
    [hobby]: 'A hobby',
};

// removing a key
let keyToDelete = 'deleteKey';
user[keyToDelete] = 'useless value';
delete user[keyToDelete];


// all keys are either strings or symbols
user[10] = "Key 10";

// Order prefers to put integers as sorted
// Remaining keys are always output in the order in
// which they were defined
user[1] = "First key to be output";
user["+1"] = "This will be the last key";

val = user;
console.log(val);

// check key in object
alert('Multi Value Property' in user);
// accessing a non existing key gives undefined
console.log(user['does not exist']);

// print all keys
for(let key in user) {
    console.log(key + " : " + user[key]);
}