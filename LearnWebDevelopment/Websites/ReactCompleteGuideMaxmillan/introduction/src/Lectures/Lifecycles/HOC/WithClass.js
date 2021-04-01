
const withClass = props => (
    <div className={props.classes}>
        {props.children}
    </div>
);

export default withClass;

// Method 2
export const withClassTwo = (WrappedComponent, className) => {
    return props => (
        <div className={className}>
            <WrappedComponent {...props}/>
        </div>
    );
};
