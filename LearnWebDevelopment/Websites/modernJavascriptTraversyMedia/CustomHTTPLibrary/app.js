const http = new easyHTTP();
const baseURL = "https://jsonplaceholder.typicode.com/posts";

const getSubmitBtn = document.querySelector('#get #submit');
const getClearBtn = document.querySelector('#get #clear');
const getDisplay = document.getElementById('result');

getSubmitBtn.addEventListener('click', function(e) {
    const id = document.getElementById('get-request').value;

    let output = ``;
    getPostById(id, function(error, post) {
            if(error) {
                output = error;
            } else {
                output = JSON.parse(post).body;
            }

            getDisplay.innerHTML = output;
    });

    e.preventDefault();
});

getClearBtn.addEventListener('click', function(e) {
    getDisplay.innerHTML = '';
    document.getElementById('get-request').value = '';
    
    e.preventDefault();
});

// Get Post
function getPostById(id, callback) {
    http.get(baseURL + "/" + id, callback);
}

// Get Posts
function getPosts() {
    http.get(baseURL, 
        function(error, posts) {
            if(error) {
                return error;
            } else {
                return posts
            }
    });
}

// Create POST
function createPost(data) {
    http.post(baseURL, data, 
        function(error, post) {
            if(error) {
                return error;
            } else {
                return post;
            }
        })
}


// Update Post
function updatePost(data) {
    http.put(baseURL, data, 
        function(error, post) {
            if(error) {
                return error;
            } else {
                return post;
            }
        })
}

// Delete Post
function deletePost(id) {
    http.delete(baseURL + "/" + id,
        function(error, response) {
            if(error) {
                return error;
            } else {
                return response;
            }
        })
}
