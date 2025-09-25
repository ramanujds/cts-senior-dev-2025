import React, { createContext, useContext, useEffect, useReducer, useState } from 'react'
import { Row } from 'react-bootstrap'
import StockItem from './StockItem'
import { addStock, deleteStockById, fetchStocks } from './stocksApi';
import { StockContext } from '../../pages/MainPage';




const StockList = () => {

    const {state, dispatch} = useContext(StockContext);

    // const [stocks, setStocks] = useState([]);

  

 

 


    useEffect(() => {
        refreshStocks();
    }, []);

    const refreshStocks = () => {
        fetchStocks().then(data => {
            dispatch({ type: 'SUCCESS', payload: data });
        }).catch(error => {
            dispatch({ type: 'ERROR', payload: error });
            console.error('Error fetching stocks:', error);
        });
    }



  return (
   

    <Row>
        {state.loading && <p>Loading...</p>}
        {state.error && <p className="text-danger">Error: {state.error.message}</p>}
        {!state.loading && state.stocks.length === 0 && <p>No stocks available.</p>}
        {state.stocks.map(stock => (
            <StockItem key={stock.id} stock={stock}/>
        ))}
    </Row>
    )
}

export default StockList