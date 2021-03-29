import { Component } from 'react';
import PersonStyle from '../Components/Persons/Person/Person.module.css'
import Persons from '../Components/Persons/Persons';
import Cockpit from '../Components/Cockpit/Cockpit';

class App extends Component {
    constructor(props) {
        super(props);
        console.log('[Lifecycles/App.js] constructor');
    }

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

    static getDerivedStateFromProps(props, state) {
        console.log('[Lifecycles/App.js] getDerivedStateFromProps ', props);
        return state;
    }

    componentWillMount() {
        console.log('[Lifecycles/App.js] componentWillMount');

    }

    componentDidMount() {
        console.log('[Lifecycles/App.js] componentDidMount');
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
        const personIndex = this.state.persons.findIndex(p => {
            return p.id === id;
        });

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
        console.log('[Lifecycles/App.js] rendering...');
        let persons = null;
        if(this.state.showPersons) {
            persons = (                         
                <Persons  
                    persons={this.state.persons}
                    descriptions={this.state.description}
                    clicked={this.switchClickHandler}
                    changed={this.switchNameChange}
                    delete={this.deletePersonsHandler}
                />
            );            
        }

        return (
            <div>
                <Cockpit 
                    persons={this.state.persons}
                    toggle={this.togglePersonsHandler}
                    title={this.props.title}
                />
                <div className={PersonStyle.Person}>
                    {persons}
                </div>
            </div>
        );
    }
}

export default App;