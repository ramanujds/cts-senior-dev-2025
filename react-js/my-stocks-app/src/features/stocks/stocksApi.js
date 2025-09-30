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

export const saveStock = async (stock) => {
    return fetch('http://localhost:3000/stocks', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(stock),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .catch(error => {
        console.error('Error adding stock:', error);
        throw error;
    });
};

export const updateStock = async (id, stock) => {
    return fetch(`http://localhost:3000/stocks/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(stock),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .catch(error => {
        console.error('Error updating stock:', error);
        throw error;
    });
};

export const fetchStockById = async (id) => {
    return fetch(`http://localhost:3000/stocks/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .catch(error => {
            console.error('Error fetching stock by ID:', error);
            throw error;
        });
};  

