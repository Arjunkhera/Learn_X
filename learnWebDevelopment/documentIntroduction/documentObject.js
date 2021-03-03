let val;

// grab the document from the window object
val = document;

// print all the elements of the document
// gives an HTML collection
val = document.all;
val = document.all.length;
// we can use array indexing
val = document.all[2];

// get by element name
val = document.head;
val = document.body;

// some other stuff we can grab
val = document.doctype;
val = document.domain;
val = document.URL;
val = document.characterSet;
val = document.contentType;

// we can get all elements of a type from the document
val = document.forms;
// undefined, since we are referring to outside the array
val = document.forms[1];
val = document.forms[0].id;
val = document.forms[0].method;
val = document.forms[0].action;

val = document.links;
val = document.links[0];
val = document.links[0].id;
// returns string of class
val = document.links[0].className;
// returns list of values of class
val = document.links[0].classList;

val = document.scripts;
val = document.scripts[2].getAttribute('src');

let scripts = document.scripts;

let scriptsArray = Array.from(scripts);
scriptsArray.forEach((script) => {
    console.log(script.getAttribute('src'))
})

console.log(val);