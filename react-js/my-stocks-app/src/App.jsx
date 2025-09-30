import { createContext, useReducer, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './pages/Header'
import Footer from './pages/Footer'
import { Col, Row } from 'react-bootstrap'
import { Outlet, Route, Routes } from 'react-router-dom'
import StockList from './features/stocks/StockList'
import StockForm from './features/stocks/StockForm'
import React from 'react'



export const StockContext = createContext();

export function App() {

  // const initialState = {
  //   stocks: [],
  //   loading: false,
  //   error: null,
  // };

  // const [state, dispatch] = useReducer(reducer, initialState);

  // function reducer(state, action) {
  //   switch (action.type) {
  //     case 'LOADING':
  //       return {
  //         ...state,
  //         loading: true,
  //         error: null,
  //       };
  //     case 'SUCCESS':
  //       return {
  //         ...state,
  //         loading: false,
  //         stocks: action.payload,
  //       };
  //     case 'ERROR':
  //       return {
  //         ...state,
  //         loading: false,
  //         error: action.payload,
  //       };
  //     case 'DELETE':
  //       deleteStockById(action.payload);
  //       return {
  //         ...state,
  //         stocks: state.stocks.filter(stock => stock.id !== action.payload),
  //       };
  //     case 'ADD':
  //       addStock(action.payload);
  //       return {
  //         ...state,
  //         stocks: [...state.stocks, action.payload],
  //       };
  //     case 'UPDATE':
  //       updateStock(action.payload.id, action.payload);
  //       return {
  //         ...state,
  //         stocks: state.stocks.map(stock =>
  //           stock.id === action.payload.id ? action.payload : stock
  //         ),
  //       };

  //     default:
  //       return state;
  //   }
  // }

  return (
    <>

      <Header />
      <Outlet />
      <Footer />
   

    </>
  )
}

// export default App
