const posts = [
    {title: 'Post One', body: 'This is post one'},
    {title: 'Post One', body: 'This is post two'}
];

// Using promises
function createPost(post) {
    return new Promise(function(resolve, reject){
        setTimeout(function() {
            posts.push(post);

            let error = true;
            if(!error) {
                resolve();
            }
            reject('Error: Something went wrong');
        }, 2000);
    });
}

function getPosts() {
    setTimeout(function() {
        let output = '';
        posts.forEach(function(post) {
            output += `<li>${post.title}</li>`;
        })
        document.body.innerHTML = output;
    }, 1000);
}

let data = {title: 'Post Three', body: 'This is post three'};
createPost(data)
    .then(getPosts)
    .catch(function(err) {
        console.log(err);
    });


// Using callbacks
// function createPost(post, callback) {
//     setTimeout(function() {
//         posts.push(post);
//         callback();
//     }, 2000);
// }

// function getPosts() {
//     setTimeout(function() {
//         let output = '';
//         posts.forEach(function(post) {
//             output += `<li>${post.title}</li>`;
//         })
//         document.body.innerHTML = output;
//     }, 1000);
// }

// createPost({title: 'Post Three', body: 'This is post three'}, getPosts);

