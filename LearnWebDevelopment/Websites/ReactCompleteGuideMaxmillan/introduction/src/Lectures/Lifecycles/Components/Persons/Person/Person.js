import PersonStyle from './Person.module.css';
import React, { Component } from 'react';
import PropTypes from 'prop-types';
import AuthContext from '../../../Context/AuthContext';

// import Aux from '../../../HOC/Auxilliary';
import { withClassTwo } from '../../../HOC/WithClass';

class Person extends Component {
    constructor(props) {
        super(props);
        this.inputElementRef = React.createRef();
    }

    static contextType = AuthContext;

    componentDidMount() {
        // this.inputElement.focus();
        this.inputElementRef.current.focus();
        console.log("Person authenticate ?", this.context.authenticated);
    }

    render() {
        console.log('[Lifecycles/Person.js] rendering...');

        return (
            <div onClick={this.props.click} id={"Person-" + this.props.index}>
                <p className={PersonStyle.PersonTitle}>
                    <span className={PersonStyle.PersonName}> {this.props.name} </span> 
                    {this.props.age} {' '}
                    {/* <AuthContext.Consumer>
                        { 
                            (context) => {
                                return (
                                    context.authenticated ? 
                                        <span className={PersonStyle.LoggedIn}>Authenticated</span> 
                                    : <span className={PersonStyle.LoggedOut}>Not Authenticated</span> 
                                );
                            }
                        }
                    </AuthContext.Consumer> */}
                    {
                        this.context.authenticated ? 
                            <span className={PersonStyle.LoggedIn}>Authenticated</span> 
                        : <span className={PersonStyle.LoggedOut}>Not Authenticated</span> 
                    }
                </p>
                <hr/>
                <p className={PersonStyle.PersonDescription}>{this.props.children}</p>
                <input 
                    onChange={this.props.nameChange} 
                    value={this.props.name} 
                    // ref={ (inputElement) => {this.inputElement = inputElement}}
                    ref = {this.inputElementRef}
                />
                <br/><br/>
                <button className={PersonStyle.Button} onClick={this.props.deleteCard}>Delete</button>
            </div>
        );
    }
}

Person.propTypes = {
    name: PropTypes.string,
    age: PropTypes.number,
    click: PropTypes.func,
    index: PropTypes.number,
    nameChange: PropTypes.func,
    deleteCard: PropTypes.func,
};

export default withClassTwo(Person, PersonStyle.Card);

// Returning multiple adjacent elements
// Use array
// return ([
//         <p className={PersonStyle.PersonTitle}><span className={PersonStyle.PersonName}>{this.props.name}</span> {this.props.age}</p>,
//         <hr/>,
//         <p className={PersonStyle.PersonDescription}>{this.props.children}</p>,
//         <input onChange={this.props.nameChange} value={this.props.name} />,
//         <br/>,
//         <br/>,
//         <button className={PersonStyle.Button} onClick={this.props.deleteCard}>Delete</button>,
// ]);

// Using a higher order component
// return (
//     <Aux>
//         <p className={PersonStyle.PersonTitle}><span className={PersonStyle.PersonName}>{this.props.name}</span> {this.props.age}</p>
//         <hr/>
//         <p className={PersonStyle.PersonDescription}>{this.props.children}</p>
//         <input onChange={this.props.nameChange} value={this.props.name} />
//         <br/><br/>
//         <button className={PersonStyle.Button} onClick={this.props.deleteCard}>Delete</button>
//     </Aux>
// );

// User builtin HOC
// <React.Fragment>