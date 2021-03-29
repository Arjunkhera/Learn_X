import './App.css';
import { Component } from 'react';
import MethodPassingApp from './Lectures/MethodPassing/MethodPassingApp';
import ListsApp from './Lectures/WorkingWithLists/ListsApp';
import StyleReact from './Lectures/StylingReact/StyleReact';
// import { StyleRoot } from 'radium'

class App extends Component {
  render() {
    return (
      // <StyleRoot>
        <div className="App">
          <hr/>
          <MethodPassingApp></MethodPassingApp>
          <hr/>
          <ListsApp></ListsApp>
          <hr/>
          <StyleReact></StyleReact>
          <br/><br/><br/><br/>

        </div>
      // </StyleRoot>
    );  
  }
}

export default App;
