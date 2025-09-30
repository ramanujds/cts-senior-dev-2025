import { createSlice } from '@reduxjs/toolkit'

export const stocksSlice = createSlice({
  name: 'stocks',
  initialState: [],
  reducers: {
    addStock: (state, action) => {
      console.log('action.payload in addStock:', action.payload);
      state.push(action.payload)
    },
    loadStocks: (state, action) => {
      console.log('action.payload in loadStocks:', action.payload);
      return action.payload
    },
    deleteStockById: (state, action) => {
      return state.filter(stock => stock.id !== action.payload)
    },
    updateStock: (state, action) => {
      return state.map(stock =>
        stock.id === action.payload.id ? action.payload : stock
      )
    }
  }
})

// Action creators are generated for each case reducer function
export const { addStock, deleteStockById, updateStock,loadStocks } = stocksSlice.actions
export default stocksSlice.reducer