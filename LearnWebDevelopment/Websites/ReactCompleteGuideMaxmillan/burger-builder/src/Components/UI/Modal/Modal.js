import React, { Component } from 'react';
import ModalStyle from './Modal.module.css';
import Aux from '../../../HOC/Auxilliary/Auxilliary';
import Backdrop from '../Backdrop/Backdrop';

class Modal extends Component {

    shouldComponentUpdate(nextProps, nextState) {
        return nextProps.show !== this.props.show || nextProps.children !== this.props.children;
    }

    render() {
        // console.log('[Modal] show:', this.props.show);
        // console.log('[Modal] message:', this.props.children);

        return (
            <Aux>
                <Backdrop 
                    show={this.props.show}
                    clicked={this.props.modalClosed}
                />
                <div 
                    className={ModalStyle.Modal}
                    style={{
                        transform: this.props.show ? 'translateY(0)' : 'translateY(-100vh)',
                        opacity: this.props.show ? '1': '0'
                    }}
                >
                    {this.props.children}
                </div>
            </Aux>

        );
    }
}

export default Modal;