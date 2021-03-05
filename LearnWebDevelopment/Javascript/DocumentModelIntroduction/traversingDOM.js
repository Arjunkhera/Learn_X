let val;

const list = document.querySelector('ul.collection');
// first child is not required
const listItem = document.querySelector('li.collection-item:first-child');

// line breaks are seen as text nodes
val = list.childNodes;

val = list.childNodes[0];
val = list.childNodes[0].nodeName;
val = list.childNodes[1].nodeType;

// Node Types in HTML
// 1 - Element
// 2 - Attribute (deprecated)
// 3 - Text node
// 8 - Comment
// 9 - Document itself
// 10 - Doctype

// if do not need them
// use get children element nodes
val = list.children;
list.children[1].textContent = 'Hello';

// children of children
val = list.children[3].children;

// retrieve the first node
val = list.firstChild;
// does not consider text nodes
val = list.firstElementChild;

val = list.lastChild;
val = list.lastElementChild;

// Getting count 
val = list.childElementCount;

// Doing stuff is possible with parents also
val = listItem.parentNode;
val = listItem.parentElement;
val = listItem.parentElement.parentElement;

// Get next sibling
val = listItem.nextSibling;
val = listItem.nextElementSibling;
val = listItem.nextElementSibling.nextElementSibling;

// Get previous sibling
val = listItem.previousSibling;
val = listItem.previousElementSibling;

console.log(val);

