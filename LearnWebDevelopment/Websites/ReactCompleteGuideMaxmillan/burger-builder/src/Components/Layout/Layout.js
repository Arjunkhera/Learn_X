import React from 'react';
import Aux from '../../HOC/Auxilliary';
import LayoutStyle from './Layout.module.css';

const layout = (props) => {
    return (
        <Aux>
            <div>
                Toolbar, SideDrawer, Backdrop
            </div>
            <main className={LayoutStyle.Content}>
                {props.children}
            </main>
        </Aux>
    );
};

export default layout;