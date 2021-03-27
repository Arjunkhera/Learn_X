import './ListsPerson.css';

const ListPerson = (props) => {

    return (
        <div className='card' onClick={props.click} id={"person-" + props.index}>
            <p className='person-title'><span className="person-name">{props.name}</span> {props.age}</p>
            <hr/>
            <p className='person-description'>{props.children}</p>
            {/* Two Way Binding */}
            <input onChange={props.nameChange} value={props.name} />
            <button onClick={props.deleteCard}>Delete</button>
        </div>
    );
}

export default ListPerson;