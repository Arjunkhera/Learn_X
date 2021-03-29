import React from 'react';
import Style from './Cockpit.module.css';

const Cockpit = (props) => {
    let btnClass = [Style.Button];

    if(props.showPersons) {
        btnClass.push(Style.Red);
    }

    const classes = [];
    if (props.persons.length <= 2) {
        classes.push(Style.red);
    }
    if (props.persons.length <= 1) {
        classes.push(Style.bold);
    }

    return (
       <div className={Style.Cockpit}>
            <h2>{props.title}</h2>

            <p className={classes.join(' ')}>Number of persons in state {props.persons.length}</p>

            <div className="modify-name">
                <button 
                    className = {btnClass.join(' ')}
                    onClick={props.toggle}>
                        Change Description
                </button>
            </div>
       </div> 
    );
};

export default Cockpit;
