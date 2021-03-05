// document.getElementsByClassName
const items = document.getElementsByClassName('collection-item');
console.log(items);
console.log(items[0]);

items[0].style.color = 'red';
items[1].textContent = 'hello';

// obtaining specific collections
const listItems = document.querySelector('ul').getElementsByClassName('collection-item');

console.log(listItems);

// document.getElementByTagName
const anotherList = document.getElementsByTagName('li');
console.log(anotherList);
console.log(anotherList);
console.log(anotherList[0]);

anotherList[0].style.color = 'red';
anotherList[1].textContent = 'hello';


// html collections are not arrays
let arrayList = Array.from(anotherList);

// is an array, we can use methods on it
arrayList.reverse();

// we can use for each now
arrayList.forEach(function(li, index){
    console.log(li.className);
    li.textContent = `${index} : Hello`;
});

console.log(arrayList);


// Working with nodelists

// document.querySelectorAll
const secondItem = document.querySelectorAll('ul.collection li.collection-item');

// no need to convert to array 
// since this is nodelist and not a collection
secondItem.forEach(function(item, index) {
    item.textContent = `${index} : Hello`;
});


const liOdd = document.querySelectorAll("li:nth-child(odd)");
const liEven = document.querySelectorAll("li:nth-child(even)");

liOdd.forEach(function(li, index) {
    li.style.background = '#ccc';
});

// this is suitable for both html collections and nodelists
// we do not need arrays for this
for (let i = 0; i < liEven.length; i++) {
    liEven[i].style.background = '#f4f4f4';
}

console.log(secondItem);














