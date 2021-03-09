document.getElementById('button1').addEventListener('click', loadCustomer);

function loadCustomer(e) {
    const xhr = new XMLHttpRequest();

    xhr.open('GET', 'customer.json', true);

    xhr.onload = function() {
        if(this.status === 200) {
            const customer = JSON.parse(this.responseText);
            document.getElementById('customer').innerHTML = getCustomerTemplate(customer);
        }
    }

    xhr.send();
}

document.getElementById('button2').addEventListener('click', loadCustomers);

function loadCustomers(e) {
    const xhr = new XMLHttpRequest();

    xhr.open('GET', 'customers.json', true);

    xhr.onload = function() {
        if(this.status === 200) {
            const customers = JSON.parse(this.responseText);
            let output = ``;

            customers.forEach(customer => {
                output += getCustomerTemplate(customer);
            });

            document.getElementById('customers').innerHTML = output;
        }
    }

    xhr.send();
}

function getCustomerTemplate(customer) {
    return `
        <ul>
            <li>ID: ${customer.id} </li>
            <li>Name: ${customer.name} </li>
            <li>Company: ${customer.company} </li>
            <li>Phone: ${customer.phone} </li>
        </ul>
    `;
}