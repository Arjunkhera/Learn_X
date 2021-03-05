// Storage is always key value
// And value should always be a string
// local and session storage are different

// set local storage item
localStorage.setItem('name','arjun');

// set session storage item
sessionStorage.setItem('name','khera');

// remove from storage
localStorage.removeItem('name');

// get from storage
const name = localStorage.getItem('name');

// clear local storage
localStorage.clear();

document.querySelector('form').addEventListener('submit', function(e){
    const task = document.getElementById('task').value;  

    if (localStorage.getItem('tasks') === null) {
        tasks = [];
    } else {
        tasks = JSON.parse(localStorage.getItem('tasks'));
    }

    tasks.push(task);
    localStorage.setItem('tasks', JSON.stringify(tasks));

    e.preventDefault();
})