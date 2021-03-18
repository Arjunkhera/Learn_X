
const map = new Map();

let keyOne = "This is a string key",
    keyTwo = {'InnerKey': 'InnerValue'},
    keyThree = function() {
        console.log("function key");
    }

map.set(keyOne, 'Value of string key');
map.set(keyTwo, 'Value of object key');
map.set(keyThree, 'Value of function key');

// Get a single value
console.log(map.get(keyOne));

// for of loop
console.log('This is a for of loop');
for(let [key, value] of map) {
    console.log(`${key} : ${value}`);
}

// only keys
console.log('Logging only keys');
for(let key of map.keys()) {
    console.log(key);
}

// only values
console.log('Logging only values');
for(let value of map.values()) {
    console.log(value);
}

// for each
console.log('This is a for each loop');
map.forEach((value, key) => {
    console.log(`${key} : ${value}`);
})

// Key value array
const keyValArr = Array.from(map);
console.log(keyValArr);

// Array of keys
const keyArray = Array.from(map.keys());
console.log(keyArray);

// Arrays of values
const valueArray = Array.from(map.values());
console.log(valueArray);