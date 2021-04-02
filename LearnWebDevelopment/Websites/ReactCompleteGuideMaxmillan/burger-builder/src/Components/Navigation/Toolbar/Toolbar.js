import React from 'react';
import ToolbarStyles from './Toolbar.module.css';
import Logo from '../../Logo/Logo';
import NavgitationItems from '../NavigationItems/NavigationItems';
import DrawerToggle from '../SideDrawer/DrawerToggle/DrawerToggle';

const Toolbar = (props) => {
    return (
        <header className={ToolbarStyles.Toolbar}>
            <DrawerToggle click={props.toggleDrawer}/>
            <div className={ToolbarStyles.Logo}>
                <Logo/>
            </div>
            <nav className={ToolbarStyles.DesktopOnly}>
                <NavgitationItems />
            </nav>
        </header>
    );
}

export default Toolbar;