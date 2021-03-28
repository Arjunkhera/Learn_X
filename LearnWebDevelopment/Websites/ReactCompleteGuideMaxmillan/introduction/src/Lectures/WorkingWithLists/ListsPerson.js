import './ListsPerson.css';

const ListPerson = (props) => {

    return (
        <div className='list card' onClick={props.click} id={"personList-" + props.index}>
            <p className='list person-title'><span className="list person-name">{props.name}</span> {props.age}</p>
            <hr/>
            <p className='list person-description'>{props.children}</p>
            {/* Two Way Binding */}
            <input onChange={props.nameChange} value={props.name} />
            <button onClick={props.deleteCard}>Delete</button>
        </div>
    );
}

export default ListPerson;