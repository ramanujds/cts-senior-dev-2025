import { configureStore } from '@reduxjs/toolkit'
import stocksReducer from '../features/stocks/stocksSlice'

export default configureStore({
  reducer: {
    stocks: stocksReducer
  }
})