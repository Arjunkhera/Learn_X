import { Component } from 'react';
import PersonStyle from '../Components/Persons/Person/Person.module.css'
import Persons from '../Components/Persons/Persons';
import Cockpit from '../Components/Cockpit/Cockpit';
import WithClass from '../HOC/WithClass';
import AuthContext from '../Context/AuthContext';

class App extends Component {
    constructor(props) {
        super(props);
        console.log('[Lifecycles/App.js] constructor');
    }

    state = {
        persons: [
            // age as string would give error in prop types check
            {id: 'xcvcxdks', firstname: 'Arjun', lastName: 'Khera', age: "24"},
            {id: 'lkcnesdf', firstname: 'Neishka', lastName: 'Srivastava', age: 23},
            {id: 'kas93nsn', firstname: 'Ayush', lastName: 'Jain', age: 24},
        ],
        description: [
            "Dummy Description",
            "Dummy Description",
            "Dummy Description",
        ],
        showPersons: false,
        showCockpit: true,
        changeCounter: 0,
        isAuthenticated: false,
    }

    static getDerivedStateFromProps(props, state) {
        console.log('[Lifecycles/App.js] getDerivedStateFromProps ', props);
        return state;
    }

    // componentWillMount() {
    //     console.log('[Lifecycles/App.js] componentWillMount');
    // }

    componentDidMount() {
        console.log('[Lifecycles/App.js] componentDidMount');
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log('[Lifecycles/App.js] shouldComponentUpdate');
        return true;
    }

    componentDidUpdate() {
        console.log('[Lifecycles/App.js] componentDidUpdate');
    }

    componentWillUnmount() {
        console.log('[Lifecycles/App.js] componentWillUnmount');        
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

        this.setState((prevState, props) => {
            return {
                persons,
                changeCounter: prevState.changeCounter + 1   
            }
        });
        
        // Incorrect Way
        // this.setState({
        //     persons,
        //     changeCounter: this.state.changeCounter + 1,
        // });

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

    authenticate = () => {
        this.setState((prevState, props) => {
            return {
                isAuthenticated: !prevState.isAuthenticated
            }
        });
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
                    // isAuthenticated={this.state.isAuthenticated}
                />
            );            
        }

        return (
            <div>
                <button onClick={() => this.setState({showCockpit: !this.state.showCockpit})}>Cockpit</button>
                
                <AuthContext.Provider 
                    value={{
                        authenticated: this.state.isAuthenticated,
                        login: this.authenticate
                    }}
                >
                    {
                        this.state.showCockpit ? 
                            <Cockpit 
                                personsLength={this.state.persons.length}
                                toggle={this.togglePersonsHandler}
                                title={this.props.title}
                                // login={this.authenticate}
                            />
                            : null
                    }
                    <WithClass classes={PersonStyle.Person}>
                        {persons}
                    </WithClass>
                </AuthContext.Provider>
            </div>
        );
    }
}

export default App;