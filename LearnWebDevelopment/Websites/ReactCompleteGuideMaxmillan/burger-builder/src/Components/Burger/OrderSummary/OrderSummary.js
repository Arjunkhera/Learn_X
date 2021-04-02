import React, { useEffect } from 'react';
import Aux from '../../../HOC/Auxilliary/Auxilliary';
import Button from '../../UI/Button/Button';

const OrderSummary = (props) => {

    useEffect(() => {
        // We get the following on every state update
        // We can prevent this by adding should state update in modal
        console.log('[OrderSummary] Rendered');
    });

    const ingredientSummary = Object.keys(props.ingredients)
        .map(igKey => {
            return (
                <li key={igKey}>
                    <span style={{textTransform: 'capitalize'}}>{igKey}</span>
                    : {props.ingredients[igKey]}
                </li>                
            );
        });

    return (
        <Aux>
            <h3>Your Order</h3>
            <p>A delicious burger with the following ingredients: </p>
            <ul>
                {ingredientSummary}
            </ul>
            <p><strong>Total Price: {props.price.toFixed(2)}</strong></p>
            <p>Continue to checkout ?</p>
            <Button
                btnType='Danger'
                clicked={props.purchaseCanceled}
            >
                CANCEL
            </Button>
            <Button
                btnType='Success'
                clicked={props.purchaseContinued}
            >
                CONTINUE
            </Button>
        </Aux>
    );
};

export default OrderSummary;