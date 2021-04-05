import React, { Component } from 'react';
// import axios from 'axios';
import axios from '../../axios';
import { Route, Link, NavLink } from 'react-router-dom';

// import Post from '../../components/Post/Post';
// import FullPost from './FullPost/FullPost';
// import NewPost from './NewPost/NewPost';
import Posts from './Posts/Posts';
import NewPost from './NewPost/NewPost';
import './Blog.css';

class Blog extends Component {
    // state = {
    //     posts: [],
    //     selectedPostId: null,
    //     error: false
    // }

    // componentDidMount () {
    //     axios.get( '/posts' )
    //         .then( response => {
    //             const posts = response.data.slice(0, 4);
    //             const updatedPosts = posts.map(post => {
    //                 return {
    //                     ...post,
    //                     author: 'Max'
    //                 }
    //             });
    //             this.setState({posts: updatedPosts});
    //             // console.log( response );
    //         } )
    //         .catch(error => {
    //             // console.log(error);
    //             this.setState({error: true});
    //         });
    // }

    // postSelectedHandler = (id) => {
    //     this.setState({selectedPostId: id});
    // }

    render () {
        // let posts = <p style={{textAlign: 'center'}}>Something went wrong!</p>;
        // if (!this.state.error) {
        //     posts = this.state.posts.map(post => {
        //         return <Post 
        //             key={post.id} 
        //             title={post.title} 
        //             author={post.author}
        //             clicked={() => this.postSelectedHandler(post.id)} />;
        //     });
        // }

        return (
            <div className="Blog">
                <header>
                    <nav>
                        <ul>
                            <li>
                                <NavLink 
                                    to="/" 
                                    exact
                                    activeClassName='my-active'
                                    activeStyle={{
                                        textDecoration: 'underline'
                                    }}
                                >
                                        Home
                                </NavLink>
                            </li>
                            <li><NavLink to={{
                                pathname: '/new-post',
                                // Relative Paths
                                // pathname: this.props.match.url + '/new-post',
                                hash: '#submit',
                                search: '?quick-submit=true'
                            }}>New Post</NavLink></li>
                        </ul>
                    </nav>
                </header>
                <hr/>

                <Route 
                    path="/" exact component={Posts}
                />
                <Route 
                    path="/new-post" component={NewPost}
                />
                <Route 
                    path="/:id" exact component={Posts}
                />


                {/* <Route 
                    path="/" exact render={() => <h1>Home</h1>}
                />
                <Route 
                    path="/" render={() => <h1>Home 2</h1>}
                /> */}

                {/* <section className="Posts">
                    {posts}
                </section>
                <section>
                    <FullPost id={this.state.selectedPostId} />
                </section>
                <section>
                    <NewPost />
                </section> */}
            </div>
        );
    }
}

export default Blog;