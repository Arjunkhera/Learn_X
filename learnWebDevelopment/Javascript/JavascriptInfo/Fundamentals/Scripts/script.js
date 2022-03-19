var testDivision = document.querySelector('.test');
var body = document.querySelector('body');

loadEventListeners();

function loadEventListeners() {
    console.log("Loaded Event Listener");
    body.addEventListener('onClick', changeColor);
}

function changeColor(e) {
    console.log("Moved Mouse");
}
