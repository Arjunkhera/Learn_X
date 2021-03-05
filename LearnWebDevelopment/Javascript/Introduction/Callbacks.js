
function callbackExample(checkVariable, yes, no) {
    if (checkVariable === true) {
        yes();
    } else {
        no();
    }
}

function cool() {
    console.log("We did it");
}

function notCool() {
    console.log("Better luck next time");
}

callbackExample(true, cool, notCool);


// Function expressions or Anonymous functions
// The function exactly like a variable
let tempFunction = function() {
    console.log("I behave just like a variable");
}
