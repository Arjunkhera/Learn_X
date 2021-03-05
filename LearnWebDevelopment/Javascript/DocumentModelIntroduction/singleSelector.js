// Single element selectors find the first match only
// Multiple element selectors return a collection or node list

let val;

// document.getElementById()
val = document.getElementById('task-title');
// get things from the element
val = document.getElementById('task-title').id;

const taskTitle = document.getElementById('task-title');

// change styling
taskTitle.style.background = '#333';
taskTitle.style.color = '#FFF';
taskTitle.style.padding = '5px';
// document.getElementById('task-title').style.display = 'none';

// change content
taskTitle.textContent = 'Task List';
taskTitle.innerText = 'My Tasks';
taskTitle.innerHTML = '<span style = "color:red" >Task List</span>';

// document.querySelector()
// works like JQeury

val = document.querySelector('#task-title');
val = document.querySelector('.card-title');
val = document.querySelector('h5');

// it is a single selector, so only one li is modified
document.querySelector('li').style.color = 'red';
// we can pass multiple elements
document.querySelector('ul li').style.color = 'blue';

// we can use css pseudo classes to get last child
document.querySelector('li:last-child').style.color = 'red';
// or nth child
document.querySelector('li:nth-child(3)').style.color = 'yellow';
// change text content
document.querySelector('li:nth-child(4)').textContent = 'Hello World';
// odd or even sets, but only first in the series is modified
// since this a single selector
document.querySelector('li:nth-child(odd)').style.background = '#ccc';
document.querySelector('li:nth-child(even)').style.background = '#f4f4f4';


console.log(val);

