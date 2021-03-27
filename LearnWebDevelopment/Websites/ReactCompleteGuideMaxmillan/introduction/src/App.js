import './App.css';
import {Component} from 'react';
import MethodPassingApp from './Lectures/MethodPassing/MethodPassingApp';
import ListsApp from './Lectures/WorkingWithLists/ListsApp';

class App extends Component {
  render() {
    return (
      <div className="App">
        <hr/>
        <MethodPassingApp></MethodPassingApp>
        <hr/>
        <ListsApp></ListsApp>
      </div>
    );  
  }
}

export default App;
