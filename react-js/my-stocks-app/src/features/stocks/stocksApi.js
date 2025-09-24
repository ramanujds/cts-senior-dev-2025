export const fetchStocks = async () => {
    return fetch('http://localhost:3000/stocks')
        .then(response => response.json())
        .catch(error => {
            console.error('Error fetching stocks:', error);
            throw error;
        });
};

