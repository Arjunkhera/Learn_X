import React from 'react';
import NavgitationItemsStyle from './NavigationItem.module.css';

const NavigationItem = (props) => {
    return (
        <li className={NavgitationItemsStyle.NavigationItem}>
            <a 
                href={props.link}
                className={props.active ? NavgitationItemsStyle.active : null}
            >
                {props.children}
            </a>
        </li>
    );
}

export default NavigationItem;