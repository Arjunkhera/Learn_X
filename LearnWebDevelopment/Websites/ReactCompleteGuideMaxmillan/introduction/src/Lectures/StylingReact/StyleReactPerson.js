// import './StyleReact.css';
// import Radium from 'radium';
// import styled from 'styled-components';
import style from './StyleReactPerson.module.css'

// returns a react component
// const StyledDiv = styled.div`    
//     display: inline-block;
//     padding: 20px;
//     margin: 10px;
//     width: 25%;
//     border: 1px solid #eee;
//     box-shadow: 0 2px 2px #ccc;

//     @media (min-width: 500px) {
//         width: 450px;
//     }
//`

const StyleReactPerson = (props) => {
    return (
        // <StyledDiv className='style card' onClick={props.click} id={"personStyle-" + props.index}>
        // <div className={style.PersonStyle}>
            <div className={style.Card} onClick={props.click} id={"personStyle-" + props.index}>
                <p className={style.PersonTitle}><span className={style.PersonName}>{props.name}</span> {props.age}</p>
                <hr/>
                <p className={style.PersonDescription}>{props.children}</p>
                <input onChange={props.nameChange} value={props.name} />
                <br/><br/>
                <button className={style.Button} onClick={props.deleteCard}>Delete</button>
            </div>
        // </div>
        // </StyledDiv>
    );
}

// export default Radium(StyleReactPerson);
export default StyleReactPerson;