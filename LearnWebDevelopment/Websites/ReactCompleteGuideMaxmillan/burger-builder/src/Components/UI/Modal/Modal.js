import React from 'react';
import ModalStyle from './Modal.module.css';
import Aux from '../../../HOC/Auxilliary';
import Backdrop from '../Backdrop/Backdrop';

const modal = (props) => {
    return (
        <Aux>
            <Backdrop 
                show={props.show}
                clicked={props.modalClosed}
            />
            <div 
                className={ModalStyle.Modal}
                style={{
                    transform: props.show ? 'translateY(0)' : 'translateY(-100vh)',
                    opacity: props.show ? '1': '0'
                }}
            >
                {props.children}
            </div>
        </Aux>
    );
}

export default modal;