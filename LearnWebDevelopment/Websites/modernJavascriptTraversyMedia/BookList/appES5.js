// Book Constructor
function Book(title, author, isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
}

// UI Constructor
function UI() {

}

// Add book to list
UI.prototype.addBookToList = function(book) {
    const list = document.getElementById('book-list');
    
    // Create tr
    const row = document.createElement('tr');
    // Insert columns
    row.innerHTML = `
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.isbn}</td>
        <td><a href='#' class='delete'>X</a></td>
    `;

    list.appendChild(row);
}

// Clear Fields
UI.prototype.clearFields = function() {
    document.getElementById('title').value = '';
    document.getElementById('author').value = '';
    document.getElementById('isbn').value = '';
}

// Show Alert
UI.prototype.showAlert = function(msg, className) {
    // Create div
    const div = document.createElement('div');
    // Add classes
    div.className = `alert ${className}`;
    // Add text
    div.appendChild(document.createTextNode(msg));
    // Get parent
    const container = document.querySelector('.container');
    // Get sibling
    const form = document.getElementById('book-form');
    // Insert the element
    container.insertBefore(div, form);

    // Remove after 3 seconds
    setTimeout(function() {
        document.querySelector('.alert').remove();
    }, 3000);
}

// Delete book
UI.prototype.deleteBook = function(target) {
    if(target.className === 'delete') {
        target.parentElement.parentElement.remove();
    } 
}

// Event Listeners

// Adding book
document.getElementById('book-form').addEventListener('submit', function(e) {
    // Get form values
    const title = document.getElementById('title').value,
        author = document.getElementById('author').value,
        isbn = document.getElementById('isbn').value;

    // Instantiate book
    const book = new Book(title, author, isbn);

    // Instantiate UI
    const ui = new UI();

    // Validate Inputs
    if(title === '' || author === '' || isbn === '') {
        // Error alert
        ui.showAlert('Please fill in all the fields', 'error');
    } else {
        // Add book to list
        ui.addBookToList(book);

        // Clear fields
        ui.clearFields();

        // Success alert
        ui.showAlert('Book Added!', 'success');
    }

    e.preventDefault();
});

// Deleting book
document.getElementById('book-list').addEventListener('click', function(e) {
    const ui = new UI();
    ui.deleteBook(e.target);
    ui.showAlert('Book Removed', 'success');

    e.preventDefault();
});
