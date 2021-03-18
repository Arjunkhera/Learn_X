a = [1,2,3];
b = [4,5,6];

// Normal way
c = a.concat(b);
console.log("Normal: " + c);

// Using spread operator
c = [...a, ...b]; 
console.log("Spread: " + c);

// We can clone arrays
clone = [...a];
console.log('Clone: ', clone);

// Add anything in between
c = [...a, 'someRandomText', ...b];
console.log('Spread and add: ' + c);

// Combining different objects
const person = { name: "Jhon"};
const student = { ID: "21", GPA: "3.0"};

const new_object = { ...person, ...student, semester: '3'};
console.log(new_object);