import './App.css';
import Person from './Person/Person';
import {Component} from 'react';

class App extends Component {
  state = {
    persons: [
      {name: 'Arjun', age: 24},
      {name: 'Neishka', age: 23},
      {name: 'Ayush', age: 24}
    ]
  }

  switchNameHandler = (e) => {
    console.log('Click');
  }

  render() {
    return (
      <div className="App">
        <button onClick={this.switchNameHandler}>Switch Name</button>
        <Person name={this.state.persons[0].name} age={this.state.persons[0].age}>My Hobbies : Gaming</Person>
        <Person name={this.state.persons[1].name} age={this.state.persons[1].age}>My Hobbies : Gaming</Person>
        <Person name={this.state.persons[2].name} age={this.state.persons[2].age}>My Hobbies : Gaming</Person>
      </div>
    );  
  }
}

export default App;
