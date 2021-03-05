// EVENT BUBBLING

document.querySelector('.card-content').addEventListener('click', function() {
    console.log('card-content')
})

document.querySelector('.card').addEventListener('click', function() {
    console.log('card')
})

document.querySelector('.col').addEventListener('click', function() {
    console.log('col')
})


// EVENT DELEGATION

// example of a sitation when we need event delegation
// the following would only work on the first element
// const delItem = document.querySelector('.delete-item');

// delItem.addEventListener('click', deleteItem);

// function deleteItem() {
//     console.log('delete item');
// }

document.body.addEventListener('click', deleteItem);

function deleteItem(e) {
    // We need to get parent because, e.target gives us i tag here
    // which is the child of the a element
    if (e.target.parentElement.classList.contains('delete-item')) {
        console.log('delete-item');
    }
}