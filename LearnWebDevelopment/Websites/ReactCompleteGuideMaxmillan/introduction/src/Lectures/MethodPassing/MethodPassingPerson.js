import './MethodPassingPerson.css';

const MethodPassingPerson = (props) => {

    return (
        <div className='method card' onClick={props.click}>
            <p className='method person-title'><span className="method person-name">{props.name}</span> {props.age}</p>
            <hr/>
            <p className='method person-description'>{props.children}</p>
            {/* Two Way Binding */}
            <input onChange={props.nameChange} value={props.name} />
        </div>
    );
}

export default MethodPassingPerson;