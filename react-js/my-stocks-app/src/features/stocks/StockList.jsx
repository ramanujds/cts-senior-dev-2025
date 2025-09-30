import React, { createContext, useContext, useEffect, useReducer, useState } from 'react'
import { Row } from 'react-bootstrap'
import StockItem from './StockItem'
import {fetchStocks } from './stocksApi';
import { Outlet } from 'react-router';
import { useDispatch, useSelector } from 'react-redux';
import { loadStocks } from './stocksSlice';




const StockList = () => {


    
    // const {state, dispatch} = useContext(StockContext);
    // const context = useContext(StockContext);
    // console.log('Context in StockList:', context);

    // const [stocks, setStocks] = useState([]);

  

   const stocks = useSelector((state) => state.stocks);
   const dispatch = useDispatch();

 


    useEffect(() => {
        refreshStocks();
        console.log('Stocks from Redux Store:', stocks);
        
    }, []);

    const refreshStocks = () => {
        fetchStocks().then(data => {
            dispatch(loadStocks(data));
            
        }).catch(error => {
            console.error('Error fetching stocks:', error);
        });
    }



  return (
   

    <Row>
        
        {stocks.map(stock => (
            <StockItem key={stock.id} stock={stock}/>
        ))}
        <Outlet />  
    </Row>
    )
}

export default StockList