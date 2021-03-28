import { Component } from 'react';
import MethodPassingPerson from './MethodPassingPerson';

class MethodPassingApp extends Component {

    state = {
        persons: [
            {name: 'Arjun', age: 24},
            {name: 'Neishka', age: 23},
            {name: 'Ayush', age: 24},
        ],
        description: "Some description goes here",
    }

    switchClickHandler(newDescription) {
        this.setState({
            description: newDescription + " " + new Date(),
        });
    }

    switchNameChange = (evt) => {
        const persons = this.state.persons;
        persons[2].name = evt.target.value;

        this.setState({
            persons
        });
    }

    render() {
        return (
            <div>
                <h2>Method Passing and Two Way Binding</h2>

                <div className="method modify-name">
                    {/* This is more expensive then bind */}
                    <button onClick={() => this.switchClickHandler("Description at")}>
                        Change Description
                    </button>
                </div>

                <MethodPassingPerson
                    name = {this.state.persons[0].name}
                    age = {this.state.persons[0].age}
                    click = {() => this.switchClickHandler("Arjun Khera")}
                >
                    {this.state.description}
                </MethodPassingPerson>

                <MethodPassingPerson
                    name = {this.state.persons[1].name}
                    age = {this.state.persons[1].age}
                    click = {this.switchClickHandler.bind(this, "Neishka Srivastava")}
                >
                    {this.state.description}
                </MethodPassingPerson>

                <MethodPassingPerson
                    name = {this.state.persons[2].name}
                    age = {this.state.persons[2].age}
                    click = {this.switchClickHandler.bind(this, "Ayush Jain")}
                    nameChange = {this.switchNameChange}
                >
                    {this.state.description}
                </MethodPassingPerson>
            </div>
        );
    }
}

export default MethodPassingApp;