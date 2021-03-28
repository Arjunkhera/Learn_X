import './StyleReact.css';
// import Radium from 'radium';
import styled from 'styled-components';

// returns a react component
const StyledDiv = styled.div`    
    display: inline-block;
    padding: 20px;
    margin: 10px;
    width: 25%;
    border: 1px solid #eee;
    box-shadow: 0 2px 2px #ccc;

    @media (min-width: 500px) {
        width: 450px;
    }
`

const StyleReactPerson = (props) => {
    return (
        <StyledDiv className='style card' onClick={props.click} id={"personStyle-" + props.index}>
            <p className='style person-title'><span className="style person-name">{props.name}</span> {props.age}</p>
            <hr/>
            <p className='style person-description'>{props.children}</p>
            {/* Two Way Binding */}
            <input onChange={props.nameChange} value={props.name} />
            <button onClick={props.deleteCard}>Delete</button>
        </StyledDiv>
    );
}

// export default Radium(StyleReactPerson);
export default StyleReactPerson;