import './App.css';
import { Component } from 'react';
import MethodPassingApp from './Lectures/MethodPassing/MethodPassingApp';
import ListsApp from './Lectures/WorkingWithLists/ListsApp';
import StyleReact from './Lectures/StylingReact/StyleReact';
import StructureApp from './Lectures/Structuring/Containers/App';
import Lifecycles from './Lectures/Lifecycles/Containers/App';

class App extends Component {
  render() {
    return (
        <div className="App">
          <hr/>
          <MethodPassingApp></MethodPassingApp>
          <hr/>
          <ListsApp></ListsApp>
          <hr/>
          <StyleReact></StyleReact>
          <hr/>
          <StructureApp></StructureApp>
          <hr/>
          <Lifecycles title="React Component Lifecycles"></Lifecycles>
          <br/><br/><br/><br/>

        </div>
    );  
  }
}

export default App;
