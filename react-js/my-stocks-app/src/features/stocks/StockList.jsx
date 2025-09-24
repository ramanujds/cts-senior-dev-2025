import React, { useEffect, useReducer, useState } from 'react'
import { Row } from 'react-bootstrap'
import StockItem from './StockItem'
import { deleteStockById, fetchStocks } from './stocksApi';

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
                return {
                    ...state,
                    stocks: state.stocks.filter(stock => stock.id !== action.payload),
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

    function deleteStock(id) {
      if(confirm("Are you sure you want to delete this stock?")){
        deleteStockById(id).then(() => {
            dispatch({ type: 'DELETE', payload: id });
        })
        .catch(error => {
            dispatch({ type: 'ERROR', payload: error });
            console.error('Error deleting stock:', error);
        });
      }
  }

  return (
    <>
    <Row>
        {state.stocks.map(stock => (
            <StockItem key={stock.id} stock={stock} deleteStock={deleteStock}/>
        ))}
    </Row>
    </>
  )
}

export default StockList