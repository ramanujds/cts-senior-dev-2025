import React, { createContext, useEffect, useReducer, useState } from 'react'
import { Row } from 'react-bootstrap'
import StockItem from './StockItem'
import { addStock, deleteStockById, fetchStocks } from './stocksApi';

export const StockContext = createContext();

const StockList = () => {

    // const [stocks, setStocks] = useState([]);

    const initialState = {
        stocks: [],
        loading: false,
        error: null,
    };

 

    const [state, dispatch] = useReducer(reducer, initialState);

    function reducer(state, action) {
        switch (action.type) {
            case 'LOADING':
                return {
                    ...state,
                    loading: true,
                    error: null,
                };
            case 'SUCCESS':
                return {
                    ...state,
                    loading: false,
                    stocks: action.payload,
                };
            case 'ERROR':
                return {
                    ...state,
                    loading: false,
                    error: action.payload,
                };
            case 'DELETE':
                deleteStockById(action.payload);
                return {
                    ...state,
                    stocks: state.stocks.filter(stock => stock.id !== action.payload),
                };
            case 'ADD':
                addStock(action.payload);
                return {
                    ...state,
                    stocks: [...state.stocks, action.payload],
                };
            case 'UPDATE':
                return {
                    ...state,
                    stocks: state.stocks.map(stock => 
                        stock.id === action.payload.id ? action.payload : stock
                    ),
                };

            default:
                return state;
        }
    }


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
    <StockContext.Provider value={{ state, dispatch }}>
    <Row>
        {state.loading && <p>Loading...</p>}
        {state.error && <p className="text-danger">Error: {state.error.message}</p>}
        {!state.loading && state.stocks.length === 0 && <p>No stocks available.</p>}
        {state.stocks.map(stock => (
            <StockItem key={stock.id} stock={stock}/>
        ))}
    </Row>
    </StockContext.Provider>
  )
}

export default StockList