import React, { createContext, useReducer } from 'react'
import StockList from '../features/stocks/StockList'
import StockForm from '../features/stocks/StockForm'
import { Col, Row } from 'react-bootstrap'
import { addStock, deleteStockById } from '../features/stocks/stocksApi';
import StockReactHookFormBased from '../features/stocks/StockReactHookFormBased';

export const StockContext = createContext();

const MainPage = () => {

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

  return (
     <StockContext.Provider value={{ state, dispatch }}>
    <Row>
    <Col md={6}>
      <StockReactHookFormBased />
    </Col>
    <Col md={6}>
      <StockList />
    </Col>
    </Row>
    </StockContext.Provider>
  )
}

export default MainPage