console.log(typeof undefined) // "undefined"

console.log(typeof 0) // "number"

console.log(typeof 10n) // "bigint"

console.log(typeof true) // "boolean"

console.log(typeof "foo") // "string"

console.log(typeof Symbol("id")) // "symbol"

// libraries are also objects
console.log(typeof Math) // "object"

// null is a primitive type and not an object
// this is a known error of javascript
console.log(typeof null) // "object"

// functions are object types
// however, typeof still lists them as function
console.log(typeof alert) // "function"