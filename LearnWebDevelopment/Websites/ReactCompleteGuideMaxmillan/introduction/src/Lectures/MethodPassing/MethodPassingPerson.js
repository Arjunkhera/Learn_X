import './MethodPassingPerson.css';

const MethodPassingPerson = (props) => {

    return (
        <div className='card' onClick={props.click}>
            <p className='person-title'><span className="person-name">{props.name}</span> {props.age}</p>
            <hr/>
            <p className='person-description'>{props.children}</p>
            {/* Two Way Binding */}
            <input onChange={props.nameChange} value={props.name} />
        </div>
    );
}

export default MethodPassingPerson;