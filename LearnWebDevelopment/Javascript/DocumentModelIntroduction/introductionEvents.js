
// Clicking on the clear tasks button will keep redirecting back to the page
document.querySelector('.clear-tasks').addEventListener('click', function(e){
    console.log('Hello World');

    // We can stop that from happening by preventing the default behaviour
    e.preventDefault();

    // or for a link, use href='#' to link back to the current page
});


// Using named functions
document.querySelector('.clear-tasks').addEventListener('click', onClick);

function onClick(e){
    console.log('Clicked');

    let val;
    val = e;


    // Event target element
    val = e.target;
    val = e.target.id;
    val = e.target.className;
    val = e.target.classList;

    e.target.innerText = 'Hello';

    // Event type
    val = e.type;

    // Timestamp
    val = e.timeStamp;

    // Coordinates event relative to the window
    val = e.clientX;
    val = e.clientY;

    // Coordinates event relative to the element
    val = e.offsetY;
    val = e.offsetX;

    console.log(val);
}

