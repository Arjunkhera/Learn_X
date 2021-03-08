// Book
class Book {
    constructor(title, author, isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}

// UI
class UI {
    addBookToList(book) {
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

    clearFields() {
        document.getElementById('title').value = '';
        document.getElementById('author').value = '';
        document.getElementById('isbn').value = '';
    }

    showAlert(msg, className) {
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

    deleteBook(target) {
        if(target.className === 'delete') {
            target.parentElement.parentElement.remove();
        } 
    }    
}

class Store {
    static getBooks() {
        let books = [];

        if(localStorage.getItem('books') !== null) {
            books = JSON.parse(localStorage.getItem('books'));
        }

        return books;
    }

    static displayBooks() {
        const books = Store.getBooks();
        
        books.forEach(book => {
            const ui = new UI();
            ui.addBookToList(book);
        });
    }

    static addBook(book) {
        const books = Store.getBooks();
        books.push(book);
        localStorage.setItem('books', JSON.stringify(books));
    }

    static removeBook(isbn) {
        const books = Store.getBooks();
        
        books.forEach((book,index) => {
            if(book.isbn === isbn) {
                books.splice(index, 1);
            }
        });

        localStorage.setItem('books', JSON.stringify(books));
    }
}

// Event Listeners

// Display the books from local storage
document.addEventListener('DOMContentLoaded', Store.displayBooks());

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
        // Add to local storage
        Store.addBook(book);

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

    // Delete book from UI
    ui.deleteBook(e.target);

    // Remove from local storage
    Store.removeBook(e.target.parentElement.previousElementSibling.textContent);

    // Error alert
    ui.showAlert('Book Removed', 'success');

    e.preventDefault();
});
