import React from 'react';
import BuildControlStyle from './BuildControl.module.css';

const BuildControl = (props) => {
    return (
        <div className={BuildControlStyle.BuildControl}>
            <div className={BuildControlStyle.Label}>{props.label}</div>
            <button className={BuildControlStyle.Less}>Less</button>
            <button className={BuildControlStyle.More}>More</button>
        </div>
    );
};

export default BuildControl;