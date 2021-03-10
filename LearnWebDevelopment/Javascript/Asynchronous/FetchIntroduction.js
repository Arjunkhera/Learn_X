document.getElementById('button1').addEventListener('click', getText);

function getText() {
    fetch('data.txt')
        .then(function(response) {
            return response.text();
        })
        .then(function(data) {
            document.getElementById('output').innerHTML = data;
        })
        .catch(function(err) {
            console.log(err);
        });
}

document.getElementById('button2').addEventListener('click', getJSON);

function getJSON() {
    fetch('customers.json')
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            let output = '';
            data.forEach(customer => {
                output += `<li>${customer.name}</li>`;
            });

            document.getElementById('output').innerHTML = output;
        })
        .catch(function(err) {
            console.log(err);
        });
}

document.getElementById('button3').addEventListener('click', getExternal);

function getExternal() {
    fetch('https://api.github.com/users')
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            let output = '';
            data.forEach(user => {
                output += `<li>${user.login}</li>`;
            });

            document.getElementById('output').innerHTML = output;
        })
        .catch(function(err) {
            console.log(err);
        });
}

document.getElementById('clear').addEventListener('click', function(e) {
    document.getElementById('output').innerHTML = '';
})