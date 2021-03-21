class UI {
    constructor() {
        this.container = document.querySelector('.postsContainer');
        this.cardForm = document.querySelector('.card-form');
        this.formEnd = document.querySelector('.form-end');
        this.posts = document.querySelector('#posts');
        this.titleInput = document.querySelector('#title');
        this.bodyInput = document.querySelector('#body');
        this.idInput = document.querySelector('#id');
        this.postSubmit = document.querySelector('.post-submit');
        this.cancelButton = document.querySelector('.post-cancel');
        this.forState = 'add';
    }

    // Show all the posts
    showPosts(posts) {
        let output = ``;

        posts.forEach((post) => {
            output += `
                <div class="card mb-3">
                    <div class="card-body">
                        <h4 class="card-title">${post.title}</h4>
                        <p class="card-text">${post.body}</p>
                        <a href="#" class="edit card-link" data-id="${post.id}">
                            <i class="fa fa-pencil"></i>
                        </a>
                        <a href="#" class="delete card-link" data-id="${post.id}">
                            <i class="fa fa-remove"></i>
                        </a>
                    </div>
                </div>`;
        });

        this.posts.innerHTML = output;
    }

    // Show Alert
    showAlert(msg, className) {
        this.clearAlert();

        // Create div
        const div = document.createElement('div');
        // Add classes
        div.className = className;
        // Add text
        div.appendChild(document.createTextNode(msg));
        // Insert alert
        this.container.insertBefore(div, this.posts);

        // Timeout  
        setTimeout(() => {
            this.clearAlert();
        }, 3000);
    }

    // Clear Alert
    clearAlert() {
        const currentAlert = document.querySelector('.alert');

        if(currentAlert) {
            currentAlert.remove();
        }
    }

    // Clear Id input
    clearIdInput() {
        this.idInput.value = '';
    }

    // Clear all form fields
    clearFields() {
        ui.titleInput.value = '';
        ui.bodyInput.value = '';
    }

    // Fill form to edit
    fillForm(data) {
        this.titleInput.value = data.title;
        this.bodyInput.value = data.body;
        this.idInput.value = data.id;

        this.changeFormState(`edit`);
    }

    // Change the form state
    changeFormState(type) {
        if(type === 'edit') {
            this.postSubmit.textContent = 'Update Post';
            this.postSubmit.classList = this.postSubmit.classList + ' btn-warning';

            // Create cancel button
            const button = document.createElement('button');
            button.className = 'post-cancel btn btn-light btn-block';
            button.appendChild(document.createTextNode('Cancel Edit'));

            ui.cardForm.insertBefore(button, ui.formEnd);
        } else {
            this.postSubmit.textContent = 'Post It';
            const submitClassList = this.postSubmit.classList;
            submitClassList.remove('btn-warning');
            this.postSubmit.classList = submitClassList;

            // Remove cancel button if present
            if(document.querySelector('.post-cancel')) {
                document.querySelector('.post-cancel').remove();
            }
            // Clear ID from hidden field
            this.clearIdInput();
            // Clear text
            this.clearFields();
        }
    }
}

export const ui = new UI();