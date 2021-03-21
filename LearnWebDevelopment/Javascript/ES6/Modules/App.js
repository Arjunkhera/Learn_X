// ES2015 Module

// Import specific modules
import { person, sayHello } from './mymodule2';
console.log(person.name);
console.log(sayHello());


// Import everything
import * as mod from './mymodule2';
console.log(mod.person.name);
console.log(mod.sayHello());

// Import default
import greeting from './mymodule2';
console.log(greeting);