import React, { Component } from 'react';
import Aux from '../Auxilliary/Auxilliary';
import LayoutStyle from './Layout.module.css';
import Toolbar from '../../Components/Navigation/Toolbar/Toolbar';
import SideDrawer from '../../Components/Navigation/SideDrawer/SideDrawer';

class Layout extends Component {
    state = {
        showSideDrawer: false,
    }

    sideDrawerClosedHandler = () => {
        this.setState({showSideDrawer: false});
    }

    sideDrawerToggleHandler = () => {
        this.setState((prevState) => {
            return {
                showSideDrawer: !prevState.showSideDrawer,
            }
        });
    }

    render() {
        return (
            <Aux>
                <Toolbar toggleDrawer={this.sideDrawerToggleHandler}/>
                <SideDrawer open={this.state.showSideDrawer} closed={this.sideDrawerClosedHandler}/>
                <main className={LayoutStyle.Content}>
                    {this.props.children}
                </main>
            </Aux>
        );        
    }
};

export default Layout;