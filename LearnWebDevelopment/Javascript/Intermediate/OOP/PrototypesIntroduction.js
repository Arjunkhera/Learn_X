// Object Literals -> Object Prototype
let str = "Arjun";

// Objects created using Constructors -> Separate Prototype -> Object Prototype
// Person Constructor
function Person(firstName, lastName, dob) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = new Date(dob);
}

// Transfer common functions to Prototype

// Calculate Age
Person.prototype.calculateAge = function() {
    const diff = Date.now() - this.birthday.getTime();
    const ageDate = new Date(diff);

    return Math.abs(ageDate.getUTCFullYear() - 1970);
}

// Get Full Name
Person.prototype.getFullName = function() {
    return `${this.firstName} ${this.lastName}`; 
}

// Change Last Name
Person.prototype.getsMarried = function(newLastName) {
    this.lastName = newLastName;
}

const john = new Person('John', 'Doe', '8-12-90');
const mary = new Person('Mary', 'Johnson', 'March 20 1978');

console.log(mary);
console.log(john.calculateAge());
console.log(mary.getFullName());

mary.getsMarried('Smith');
console.log(mary.getFullName());

// hasOwnProperty : check if properties belong to given object or not
console.log(mary.hasOwnProperty('firstName'));
console.log(mary.hasOwnProperty('getFullName'));



