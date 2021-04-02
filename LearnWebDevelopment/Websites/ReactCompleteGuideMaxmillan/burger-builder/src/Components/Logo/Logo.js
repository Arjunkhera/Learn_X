import React from 'react';
import burgerLogo from '../../Assets/Images/burger-logo.png';
import LogoStyle from './Logo.module.css';

const Logo = (props) => {
    return (
        <div className={LogoStyle.Logo}>
            <img src={burgerLogo} alt="My Burger"></img>
        </div>
    );
};

export default Logo;