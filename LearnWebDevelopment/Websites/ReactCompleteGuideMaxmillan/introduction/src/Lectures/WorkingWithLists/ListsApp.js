import { Component } from 'react';
import ListPerson from './ListsPerson';

class ListsApp extends Component {

    state = {
        persons: [
            {id: 'kajdks', firstname: 'Arjun', lastName: 'Khera', age: 24},
            {id: 'lkcnes', firstname: 'Neishka', lastName: 'Srivastava', age: 23},
            {id: 'kasjnn', firstname: 'Ayush', lastName: 'Jain', age: 24},
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
        person.name = evt.target.value;

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
        let persons = null;

        if(this.state.showPersons) {
            persons = (                         
                <div>
                    {
                        this.state.persons.map((person, index) => {
                            return (
                                <ListPerson
                                    name = {person.firstname}
                                    age = {person.age}
                                    click = {() => this.switchClickHandler(index)}
                                    nameChange = {(evt) => this.switchNameChange(evt, person.id)}
                                    deleteCard = {() => this.deletePersonsHandler(index)}
                                    index = {index}
                                    key = {person.id}
                                >
                                    {this.state.description[index]}
                                </ListPerson>        
                            );
                        })
                    }
                </div>
            );
        }

        return (
            <div>
                <h2>List's and Conditionals</h2>

                <div className="modify-name">
                    <button onClick={this.togglePersonsHandler}>
                        Change Description
                    </button>
                </div>
                
                {persons}
            </div>
        );
    }
}

export default ListsApp;