export const fetchStocks = async () => {
    return fetch('http://localhost:3000/stocks')
        .then(response => response.json())
        .catch(error => {
            console.error('Error fetching stocks:', error);
            throw error;
        });
};

export const deleteStockById = async (id) => {
    return fetch(`http://localhost:3000/stocks/${id}`, {
        method: 'DELETE',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .catch(error => {
        console.error('Error deleting stock:', error);
        throw error;
    });
};

