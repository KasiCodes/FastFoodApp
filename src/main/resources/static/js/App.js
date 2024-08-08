import React, { useState } from 'react';
import Login from './Login';
import HomePage from './HomePage';

const App = () => {
    const [loggedIn, setLoggedIn] = useState(false);

    return (
        <div>
            {!loggedIn ? <Login onLogin={() => setLoggedIn(true)} /> : <HomePage />}
        </div>
    );
};

export default App;
