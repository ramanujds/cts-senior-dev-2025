import React from 'react'
import { StockContext } from './StockList';

const StockForm = () => {

  const dispatch = useContext(StockContext).dispatch;

  return (
    <div>StockForm</div>
  )
}

export default StockForm