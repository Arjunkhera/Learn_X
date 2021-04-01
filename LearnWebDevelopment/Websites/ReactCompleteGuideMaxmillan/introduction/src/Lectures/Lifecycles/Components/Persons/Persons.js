import React, { Component } from 'react';
import Person from './Person/Person'

// class Persons extends PureComponent {
class Persons extends Component {

    // Gives warning if state is not initialized
    // static getDerivedStateFromProps(props, state) {
    //     console.log('[Lifecycles/Person.js] getDerivedStateFromProps ', props);
    //     return state;
    // }

    // depracated
    // componentWillReceiveProps
    // componentWillUpdate

    shouldComponentUpdate(nextProps, nextState) {
        console.log('[Lifecycles/Persons.js] shouldComponentUpdate nextProps ', nextProps);        
        console.log('[Lifecycles/Persons.js] shouldComponentUpdate nextState ', nextState);        

        // if(nextProps.persons !== this.props.persons) {
        //     return true;
        // } else {
        //     return false;
        // }
        return true;
    }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('[Lifecycles/Persons.js] getSnapshotBeforeUpdate prevProps', prevProps);        
        console.log('[Lifecycles/Persons.js] getSnapshotBeforeUpdate prevState ', prevState);        

        return {message: 'Snapshot Body'};
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('[Lifecycles/Persons.js] componentDidUpdate ', snapshot);        
    }

    componentWillUnmount() {
        console.log('[Lifecycles/Persons.js] componentWillUnmount');        
    }

    render() {
        console.log('[Lifecycles/Persons.js] rendering...');

        return this.props.persons.map((person, index) => {
            return (
                <Person
                    name = {person.firstname}
                    age = {person.age}
                    click = {() => this.props.clicked(index)}
                    nameChange = {(evt) => this.props.changed(evt, person.id)}
                    deleteCard = {() => this.props.delete(index)}
                    index = {index}
                    isAuthenticated={this.props.isAuthenticated}
                    key = {person.id}
                >
                    {this.props.descriptions[index]}
                </Person>        
            );
        });    
    }
}

export default Persons;