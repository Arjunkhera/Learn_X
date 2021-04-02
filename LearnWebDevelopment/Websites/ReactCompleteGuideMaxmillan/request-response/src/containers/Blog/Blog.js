import React, { Component } from 'react';

import Post from '../../components/Post/Post';
import FullPost from '../../components/FullPost/FullPost';
import NewPost from '../../components/NewPost/NewPost';
import './Blog.css';
import Http from '../../Utility/HTTPLib';

class Blog extends Component {

    state = {
        posts: [],
        selectedPostId: null,
    }

    componentDidMount () {
        Http.get('https://jsonplaceholder.typicode.com/posts')
            .then(data => {
                const resp = data.slice(0, 6);
                const posts = resp.map(post => {
                    return {
                        ...post,
                        author: 'Arjun',
                    }
                });
                
                this.setState({posts})
                })
            .catch(err => this.setState({error: true}));
    }

    postSelectedHandler = (id) => {
        this.setState({selectedPostId: id});
    }

    render () {
        let posts = <p style={{textAlign: 'center'}}>Something went wrong</p>
        if (!this.state.error) {
            posts = this.state.posts.map(post => {
                return (
                    <Post 
                        key={post.id} 
                        title={post.title}
                        author={post.author}
                        clicked={() => this.postSelectedHandler(post.id)}
                    />
                )
            });    
        }

        return (
            <div>
                <section className="Posts">
                    {posts}
                </section>
                <section>
                    <FullPost id={this.state.selectedPostId}/>
                </section>
                <section>
                    <NewPost />
                </section>
            </div>
        );
    }
}

export default Blog;