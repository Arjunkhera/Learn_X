import { Component } from 'react';
import StyleReactPerson from './StyleReactPerson';
// import Radium from 'radium';
// import styled from 'styled-components';
import styles from './StyleReact.module.css';
import personStyle from './StyleReactPerson.module.css'

// Used by styled components
// const StyledButton = styled.button`
//     background-color: ${props => props.alt ? 'red' : 'green' };
//     display: inline-block;
//     color: white;
//     font: inherit;
//     border: 1px solid blue;
//     padding: 8px;
//     cursor: pointer;
    
//     &:hover {
//         background-color: ${props => props.alt ? 'salmon' : 'lightgreen'};
//         color: black;
//     }
// `

class StyleReact extends Component {

    state = {
        persons: [
            {id: 'xcvcxdks', firstname: 'Arjun', lastName: 'Khera', age: 24},
            {id: 'lkcnesdf', firstname: 'Neishka', lastName: 'Srivastava', age: 23},
            {id: 'kas93nsn', firstname: 'Ayush', lastName: 'Jain', age: 24},
        ],
        description: [
            "Dummy Description",
            "Dummy Description",
            "Dummy Description",
        ],
        showPersons: false
    }

    switchClickHandler = (modifiedIndex) => {
        const description = [...this.state.description].map((value, index) => {
            if (index === modifiedIndex) {
                value = this.getFullName(this.state.persons[index]) + " " + new Date();
            }

            return value;
        });

        this.setState({
            description,
        });
    }

    switchNameChange = (evt, id) => {
        // Method 1 : Using event handler 
        // const index = evt.target.parentNode.id.split('-')[1];
        // const persons = [...this.state.persons];
        // persons[index].firstname = evt.target.value;

        // this.setState({
        //     persons
        // });

        // Method 2 : Obtain specific id being modified
        const personIndex = this.state.persons.findIndex(p => {
            return p.id === id;
        });

        // const person = Object.assign({}, this.state.persons[personIndex]);
        const person = {
            ...this.state.persons[personIndex]
        };
        person.firstname = evt.target.value;

        const persons = [...this.state.persons];
        persons[personIndex] = person;

        this.setState({
            persons
        });
    }

    togglePersonsHandler = () => {
        const showPersons = !this.state.showPersons;
        this.setState({showPersons});
    }

    deletePersonsHandler = (index) => {
        const persons = [...this.state.persons];
        persons.splice(index, 1);

        this.setState({
            persons
        });
    }

    getFullName(person) {
        return person.firstname + " " + person.lastName;
    }

    render() {
        // Used by radium
        // const style = {
        //     backgroundColor: 'green',
        //     display: 'inline-block',
        //     color: 'white',
        //     font: 'inherit',
        //     border: '1px solid blue',
        //     padding: '8px',
        //     cursor: 'pointer',
        //     ':hover': {
        //         backgroundColor: 'lightgreen',
        //         color: 'black'
        //     },
        // }

        let persons = null;
        let btnClass = [styles.Button];

        if(this.state.showPersons) {
            persons = (                         
                <div>
                    {
                        this.state.persons.map((person, index) => {
                            return (
                                <StyleReactPerson
                                    name = {person.firstname}
                                    age = {person.age}
                                    click = {() => this.switchClickHandler(index)}
                                    nameChange = {(evt) => this.switchNameChange(evt, person.id)}
                                    deleteCard = {() => this.deletePersonsHandler(index)}
                                    index = {index}
                                    key = {person.id}
                                >
                                    {this.state.description[index]}
                                </StyleReactPerson>        
                            );
                        })
                    }
                </div>
            );

            btnClass.push(styles.Red);
            // Inline style used by radium
            // style.backgroundColor = 'red';
            // style[':hover'] = {
            //     backgroundColor: 'salmon',
            //     color: 'black'
            // }
        }

        const classes = ['style'];
        // if (this.state.persons.length <= 2) {
        //     classes.push('red');
        // }
        // if (this.state.persons.length <= 1) {
        //     classes.push('bold');
        // }
        if (this.state.persons.length <= 2) {
            classes.push(styles.red);
        }
        if (this.state.persons.length <= 1) {
            classes.push(styles.bold);
        }

        return (
            <div className={styles.StyleReact}>
                <h2>Styling React with CSS</h2>

                <p className={classes.join(' ')}>Number of persons in state {this.state.persons.length}</p>

                <div className="modify-name">
                    <button 
                        className = {btnClass.join(' ')}
                        onClick={this.togglePersonsHandler}>
                            Change Description
                    </button>
                    {/* <StyledButton 
                        alt={this.state.showPersons}
                        onClick={this.togglePersonsHandler}>
                            Change Description
                    </StyledButton> */}
                    {/* <button 
                        style = {style}
                        onClick={this.togglePersonsHandler}>
                            Change Description
                    </button> */}
                </div>
                
                <div className={personStyle.PersonStyle}>
                    {persons}
                </div>
            </div>
        );
    }
}

// export default Radium(StyleReact);
export default StyleReact;