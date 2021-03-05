// FOR loop
for (let i = 0; i < 5; i++) {
    if (i === 2) {
        continue;
    } else if (i === 4) {
        break;
    }
    
    console.log(i);
}

// WHILE loop
let i = 0;

while(i < 5) {
    console.log(`Hi ${i}`);

    i++;
}


// DO WHILE loop
i = 0;

do {
    console.log(`Do ${i}`);

    i++;
} while(i < 5);


// FOR EACH
const cars = ['maruti', 'honda', 'toyota'];

cars.forEach(function(car){
    console.log(car);
})

// MAP
const users = [
    {id:1, name:'arjun'},
    {id:2, name:'ram'},
    {id:3, name:'shyam'}
];

const ids = users.map(function(user) {
    return user.id;
});
console.log(ids);

// we can access some more stuff inside the map
const secondId = users.map(function(user, index, array) {
    console.log(`user id ${user.id}, index ${index}`);
    console.log(array);
});


// FOR IN loop
const equipment = {
    id : 5,
    name : 'hammer',
    type : 'construction'
}

for (let e in equipment) {
    console.log(`${e} : ${equipment[e]}`);
}













