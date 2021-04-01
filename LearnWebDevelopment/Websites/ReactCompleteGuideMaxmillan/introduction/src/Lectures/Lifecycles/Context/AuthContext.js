import React from 'react';

// we initialise only for the ide to provide auto complete when using context
// not required otherwise
const AuthContext = React.createContext({
    authenticated: false,
    login: () => {}
});

export default AuthContext;