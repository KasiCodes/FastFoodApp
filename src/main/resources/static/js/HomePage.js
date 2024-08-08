import React, { useEffect, useState } from 'react';
import axios from 'axios';

const HomePage = () => {
    const [restaurants, setRestaurants] = useState([]);
    const [selectedRestaurant, setSelectedRestaurant] = useState(null);
    const [token, setToken] = useState('');

    useEffect(() => {
        // Fetch restaurant data
        axios.get('/api/restaurants')
            .then(response => setRestaurants(response.data))
            .catch(error => console.error('Error fetching restaurants:', error));
    }, []);

    const buyToken = () => {
        axios.post('/api/vouchers/buy', { restaurantId: selectedRestaurant, token })
            .then(response => console.log('Token purchased:', response.data))
            .catch(error => console.error('Error buying token:', error));
    };

    return (
        <div>
            <h1>Restaurants</h1>
            <ul>
                {restaurants.map(r => (
                    <li key={r.id} onClick={() => setSelectedRestaurant(r.id)}>
                        {r.name}
                    </li>
                ))}
            </ul>
            <input value={token} onChange={(e) => setToken(e.target.value)} placeholder="Token" />
            <button onClick={buyToken}>Buy Token</button>
        </div>
    );
};

export default HomePage;
