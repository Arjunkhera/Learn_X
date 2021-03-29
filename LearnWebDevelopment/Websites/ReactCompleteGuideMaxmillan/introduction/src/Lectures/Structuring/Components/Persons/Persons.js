import React from 'react';
import Person from './Person/Person'

const Persons = (props) => 
    props.persons.map((person, index) => {
        return (
            <Person
                name = {person.firstname}
                age = {person.age}
                click = {() => props.clicked(index)}
                nameChange = {(evt) => props.changed(evt, person.id)}
                deleteCard = {() => props.delete(index)}
                index = {index}
                key = {person.id}
            >
                {props.descriptions[index]}
            </Person>        
        );
    });

export default Persons;