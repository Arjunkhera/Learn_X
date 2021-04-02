import React, { Component } from 'react';
import Http from '../../Utility/HTTPLib';
import './FullPost.css';

class FullPost extends Component {
    state = {
        loadedPost: null,
    }

    componentDidUpdate () {
        if (this.props.id) {
            if(this.state.loadedPost === null || (this.state.loadedPost.id != this.props.id)) {
                Http.get('https://jsonplaceholder.typicode.com/posts/' + this.props.id)
                .then(data => {
                    this.setState({loadedPost: data})
                })
                .catch(err => console.log(err));
            }
        }
    }

    deletePostHandler = () => {
        Http.delete('https://jsonplaceholder.typicode.com/posts/' + this.props.id)
        .then(data => {
            console.log(data);
        })
        .catch(err => console.log(err));

    }

    render () {
        let post = <p style={{textAlign: 'center'}}>Please select a Post!</p>;
        if (this.props.id) {
            post = <p style={{textAlign: 'center'}}>Loading ......</p>;
        }
        if (this.state.loadedPost) {
            post = (
                <div className="FullPost">
                    <h1>{this.state.loadedPost.title}</h1>
                    <p>{this.state.loadedPost.body}</p>
                    <div className="Edit">
                        <button onClick={this.deletePostHandler} className="Delete">Delete</button>
                    </div>
                </div>
    
            );    
        }

        return post;
    }
}

export default FullPost;