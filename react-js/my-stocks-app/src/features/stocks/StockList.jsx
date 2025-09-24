import React, { useEffect, useState } from 'react'
import { Row } from 'react-bootstrap'
import StockItem from './StockItem'
import { fetchStocks } from './stocksApi';

const StockList = () => {

    const [stocks, setStocks] = useState([]);

    useEffect(() => {
        fetchStocks().then(data => setStocks(data));
    }, []);

    function deleteStock(id) {
        setStocks(stocks.filter(stock => stock.id !== id));
        console.log(`Deleted stock with id: ${id}`);
  }

  return (
    <>
    <Row>
        {stocks.map(stock => (
            <StockItem key={stock.id} stock={stock} deleteStock={deleteStock}/>
        ))}
    </Row>
    </>
  )
}

export default StockList