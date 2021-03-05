
// Function Declarations

function greet(firstName = 'Arjun', lastName = 'Khera') {
    // ES5 did not have support for default parameters
    // if(typeof firstName === 'undefined') {
    //     firstName = 'defaultFirstName';
    // }

    console.log("Inside greet function");
    
    return 'Hello ' + firstName + " " + lastName;
}

console.log(greet('Iron', 'Man'));


// Functions Expressions

const square = function(x = 3) {
    return x*x;
};

console.log(square());
console.log(square(8));

// IMMEDIATELY INVOCABLE FUNCTIONS EXPRESSIONS : IFFES

(function(name){
    console.log('Hello ' + name);
})('Arjun');

// Property Methods

const todo = {
    add: function() {
        console.log('inside add functions');
    },
    edit: function(id) {
        console.log(`edit todo ${id}`);
    }
}

// We can define this outside too
todo.delete = function() {
    console.log('delete todo');
}

todo.add();
todo.edit(3);














