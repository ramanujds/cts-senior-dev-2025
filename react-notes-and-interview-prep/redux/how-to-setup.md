### Step 1: Setup Project

Install Redux Toolkit and React-Redux:

```bash
npm install @reduxjs/toolkit react-redux
```

### Step 2: Create a Redux Slice

Create a slice that defines the state and reducers in a file `counterSlice.js` inside a `features` folder:

```js
import { createSlice } from '@reduxjs/toolkit';

const counterSlice = createSlice({
  name: 'counter',
  initialState: { value: 0 },
  reducers: {
    increment(state) {
      state.value += 1;  // Immer takes care of immutability
    },
    decrement(state) {
      state.value -= 1;
    }
  }
});

export const { increment, decrement } = counterSlice.actions;
export default counterSlice.reducer;
```

### Step 3: Setup the Store

Create `store.js` and configure the store using `configureStore`:

```js
import { configureStore } from '@reduxjs/toolkit';
import counterReducer from './features/counterSlice';

export const store = configureStore({
  reducer: {
    counter: counterReducer
  }
});
```

### Step 4: Connect Store to React

In `index.js`, wrap the root app with the Redux `Provider` and pass the store:

```js
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { Provider } from 'react-redux';
import { store } from './store';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Provider store={store}>
    <App />
  </Provider>
);
```

### Step 5: Use Redux State and Dispatch in Components

In `App.js` (or your component), use `useSelector` to read state and `useDispatch` to send actions:

```js
import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { increment, decrement } from './features/counterSlice';

function App() {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  return (
    <div>
      <h1>Count: {count}</h1>
      <button onClick={() => dispatch(decrement())}>-</button>
      <button onClick={() => dispatch(increment())}>+</button>
    </div>
  );
}

export default App;
```

***

### Summary

| Step         | Action                          |
|--------------|---------------------------------|
| 1            | Create React app and install packages |
| 2            | Create slice with state and reducers    |
| 3            | Configure store with reducers          |
| 4            | Wrap app with Provider and pass store  |
| 5            | Use `useSelector` and `useDispatch` in components |

