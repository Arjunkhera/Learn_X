import PersonStyle from './Person.module.css';

const Person = (props) => {
    return (
            <div className={PersonStyle.Card} onClick={props.click} id={"Person-" + props.index}>
                <p className={PersonStyle.PersonTitle}><span className={PersonStyle.PersonName}>{props.name}</span> {props.age}</p>
                <hr/>
                <p className={PersonStyle.PersonDescription}>{props.children}</p>
                <input onChange={props.nameChange} value={props.name} />
                <br/><br/>
                <button className={PersonStyle.Button} onClick={props.deleteCard}>Delete</button>
            </div>
    );
}

export default Person;