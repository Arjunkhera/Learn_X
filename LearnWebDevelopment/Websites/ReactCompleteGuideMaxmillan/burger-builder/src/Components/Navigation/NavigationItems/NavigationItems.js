import React from 'react';
import NavigationItem from './NavigationItem/NavigationItem';
import NavigationItemsStyle from './NavigationItems.module.css';

const NavgitationItems = () => {
    return (
        <ul className={NavigationItemsStyle.NavigationItems}>    
            <NavigationItem
                link="/"
                active
            >
                Burger Builder
            </NavigationItem>
            <NavigationItem
                link="/"
            >
                Checkout
            </NavigationItem>
        </ul>
    );
};

export default NavgitationItems;