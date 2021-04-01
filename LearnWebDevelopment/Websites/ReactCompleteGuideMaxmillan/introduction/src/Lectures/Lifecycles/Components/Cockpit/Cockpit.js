import React, { useEffect, useRef, useContext } from 'react';
import Style from './Cockpit.module.css';
import AuthContext from '../../Context/AuthContext';

const Cockpit = (props) => {
    const toggleBtnRef = useRef(null);
    const authContext = useContext(AuthContext);

    useEffect(() => {
        console.log('[Lifecycles/Cockpit.js] useEffect run every time');
    });

    // this hack works because we have dependencies as empty, so only run once
    useEffect(() => {
        console.log('[Lifecycles/Cockpit.js] useEffect run only when mounted');
        // Using functional references. Placed here to ensure we access it after render
        toggleBtnRef.current.click();
    }, []);

    useEffect(() => {
        console.log('[Lifecycles/Cockpit.js] useEffect run when persons changes');

        setTimeout(() => {
            alert('Save data to cloud!');
        }, 1000);
    }, [props.personsLength]);

    useEffect(() => {
        return () => {
            console.log('[Lifecycles/Cockpit.js] useEffect cleanup after component unmount');
        }
    }, []);

    useEffect(() => {
        return () => {
            console.log('[Lifecycles/Cockpit.js] useEffect run before every update');
        }
    });

    let btnClass = [Style.Button];

    if(props.showPersons) {
        btnClass.push(Style.Red);
    }

    const classes = [];
    if (props.personsLength <= 2) {
        classes.push(Style.red);
    }
    if (props.personsLength <= 1) {
        classes.push(Style.bold);
    }

    console.log('[Lifecycles/Cockpit.js] rendering...');
    
    return (
       <div className={Style.Cockpit}>
            <h2>{props.title}</h2>

            <p className={classes.join(' ')}>Number of persons in state {props.personsLength}</p>

            <div className="modify-name">
                <button 
                    ref = {toggleBtnRef}
                    className = {btnClass.join(' ')}
                    onClick={props.toggle}>
                        Toggle Persons
                </button>
                
                {/* <AuthContext.Consumer>
                    {
                        (context) => {
                            return (
                                <button
                                    className = {btnClass.join(' ')}
                                    onClick={context.login}
                                >
                                    Log In
                                </button>            
                            )
                        }
                    }
                </AuthContext.Consumer> */}

                <button
                    className = {btnClass.join(' ')}
                    onClick={authContext.login}
                >
                    Log In
                </button>            

            </div>
       </div> 
    );
};

// Runs the render update only when inputs change
export default React.memo(Cockpit);
