document.getElementById('button').addEventListener('click', loadData);

function loadData() {
    // Create an XHR object
    const xhr = new XMLHttpRequest();
    readyStateValue(xhr.readyState, 'after instantiation');

    // OPEN
    xhr.open('GET', 'data.txt', true);
    readyStateValue(xhr.readyState, 'after open');

    // optional : used for spinners/loaders
    xhr.onprogress = function() {
        readyStateValue(xhr.readyState, 'onprogress');
    }

    // old : went through states 2:4, hence we have to add check
    xhr.onreadystatechange = function() {
        readyStateValue(xhr.readyState, 'onreadystatechange');

        if(this.status === 200 && this.readyState === 4) {
            console.log(this.responseText);
        }
    }

    // new : directly triggers on state 4
    xhr.onload = function() {
        readyStateValue(xhr.readyState, 'onload');
 
        if(this.status === 200) {
            console.log(this.responseText);

            const output = document.createElement('h1');
            output.innerText = this.responseText;
            document.getElementById('output').appendChild(output);
        }
    }

    // runs only if something goes wrong
    xhr.onerror = function() {
        console.log('Error processing request');
    }

    xhr.send(); 
}

function readyStateValue(status, location) {
    switch(status) {
        case 0:
            console.log('Ready State : request not initalized ', location);
            break;
        case 1:
            console.log('Ready State : server connection established ', location);
            break;
        case 2:
            console.log('Ready State : request received ', location);
            break;
        case 3:
            console.log('Ready State : processing request ', location);
            break;
        case 4:
            console.log('Ready State : request finished, response ready ', location);
            break;
    }
}