import PersonStyle from './Person.module.css';
import React, { Component } from 'react';
// import Aux from '../../../HOC/Auxilliary';
import { withClassTwo } from '../../../HOC/WithClass';

class Person extends Component {

    render() {
        console.log('[Lifecycles/Person.js] rendering...');

        return (
            <div onClick={this.props.click} id={"Person-" + this.props.index}>
                <p className={PersonStyle.PersonTitle}><span className={PersonStyle.PersonName}>{this.props.name}</span> {this.props.age}</p>
                <hr/>
                <p className={PersonStyle.PersonDescription}>{this.props.children}</p>
                <input onChange={this.props.nameChange} value={this.props.name} />
                <br/><br/>
                <button className={PersonStyle.Button} onClick={this.props.deleteCard}>Delete</button>
            </div>
        );
    }
}

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