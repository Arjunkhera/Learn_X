
let a,b;
[a, b] = [100, 200];

// Rest pattern
[a, b, c, ...rest] = [100, 200, 300, 400, 500];

({a, b} = {a:100, b:200, c:300, d:400, e:500});
({a, b, ...rest} = {a:100, b:200, c:300, d:400, e:500});

console.log(a, b, rest);

const student = {
    ID: '21',
    name: 'John',
    GPA: '3.0',
};
  
// Normal Way
const idNormal = student.ID;
const nameNormal = student.name;
const GPANormal = student.GPA;
  
console.log(idNormal);
console.log(nameNormal);
console.log(GPANormal);

// Using destructuring
const {ID, name, GPA} = student;
console.log(ID, name, GPA);

// We can provide aliases
const {name:n} = student;
console.log(n);

// Useful for dealing with state in react
const state = {
    users: [
        {
            name: 'John Doe',
            age: 32,
            gender: 'male',
            lookingfor: 'female',
            location: 'Boston MA',
            image: "https://randomuser.me/api/portraits/men/27.jpg",
        },
        {
            name: 'Jen Smith',
            age: 26,
            gender: 'female',
            lookingfor: 'male',
            location: 'Miami FL',
            image: "https://randomuser.me/api/portraits/women/87.jpg",
        },
    ],
    counter: 2,
    records: [
        {
            id_one: '1',
            id_two: '101',
            matched_on: '12-30-2012'
        },
        {
            id_one: '23',
            id_two: '132',
            matched_on: '05-19-2017'
        },
    ]
}

const {users, counter, records} = state;
console.log(users);

// We can destructure in the function call to
function render({ records }) {
    console.log(records);
}

console.log('Destructuring in a function call');
render(state);

// We can split the objects
function split(state) {
    const { records, ...front } = state
    console.log(records);
    console.log(front);
}

console.log('Splitting the object');
split(state);