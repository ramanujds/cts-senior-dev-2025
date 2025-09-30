React Redux is a way to manage shared state in React applications using a centralized store, so multiple components can access, update, and sync data easily. It solves the problem of passing props deeply and makes state predictable by using actions and reducers.[1][2][3]

### Core Concepts

Redux introduces several key ideas:[4][5][6]

- **Store**: A central place that holds the whole app’s state.
- **Action**: A plain object describing a change (contains a `type` and optional data).
- **Reducer**: A function that decides how the state updates after an action.
- **Dispatch**: Sends actions to the store.
- **Provider**: Makes the store available to all React components.

### Simple Example – Counter App

Imagine a counter that can be incremented or decremented. Here’s how it looks in Redux:

```js
// 1. ACTIONS
const incrementAction = { type: 'INCREMENT', payload: 1 };
const decrementAction = { type: 'DECREMENT', payload: 1 };

// 2. REDUCER
function counterReducer(state = 0, action) {
  switch(action.type) {
    case 'INCREMENT':
      return state + action.payload;
    case 'DECREMENT':
      return state - action.payload;
    default:
      return state;
  }
}

// 3. STORE
const store = createStore(counterReducer);

// 4. DISPATCH
store.dispatch(incrementAction);
// store.getState() will now return 1
```


### How React Redux Connects Everything

- Use the `Provider` component at the top-level to make the store available.
- Use hooks like `useSelector` (to read state) and `useDispatch` (to send actions) in components.

```js
// In App.js
<Provider store={store}>
  <Counter />
</Provider>

// In Counter.js (component)
import { useSelector, useDispatch } from 'react-redux';

function Counter() {
  const count = useSelector(state => state);
  const dispatch = useDispatch();

  return (
    <div>
      <button onClick={() => dispatch({ type: 'DECREMENT', payload: 1 })}>-</button>
      <span>{count}</span>
      <button onClick={() => dispatch({ type: 'INCREMENT', payload: 1 })}>+</button>
    </div>
  );
}
```


### Why Use Redux?

- Centralizes state for easy sharing between components.
- Simplifies debugging and makes state changes predictable.
- Scales well for large apps with lots of interdependent data.[3][7][1]


Redux Toolkit (RTK) is the official, recommended way to write Redux logic in modern React applications. It simplifies Redux code by reducing boilerplate, integrating best practices, and bundling essential tools for state management, such as asynchronous logic, immutability handling, and convenient APIs.[1][2][3]

### Key Features

- **configureStore()**: One-step setup for Redux store, combining reducers, middleware (like redux-thunk for async actions), and enables Redux DevTools integration automatically.[4][1]
- **createSlice()**: Defines a slice of state, along with its reducers and action creators, all in one place. This method auto-generates action types and creators, making code cleaner and easier to maintain.[3][6]
- **createAsyncThunk()**: Handles asynchronous actions such as data fetching, automatically dispatching lifecycle actions (pending/fulfilled/rejected) for requests.[1][3]
- **Immutability with Immer**: RTK lets you write code that appears to mutate state directly (e.g., `state.count += 1`) but safely handles immutability behind the scenes, reducing errors.[2][3]
- **RTK Query**: A built-in data fetching and caching tool that makes remote data management simple, reducing the need for manual handling of fetching and caching logic.[3][1]
- **DevTools Integration**: Built-in support for Redux DevTools to help with debugging, tracking state changes, and time travel debugging.[5][6]

### Example: Counter With Redux Toolkit

Here’s a minimal example:

```js
import { configureStore, createSlice } from '@reduxjs/toolkit';

const counterSlice = createSlice({
  name: 'counter',
  initialState: { value: 0 },
  reducers: {
    increment: (state) => { state.value += 1; },
    decrement: (state) => { state.value -= 1; },
  }
});

export const { increment, decrement } = counterSlice.actions;
export default configureStore({ reducer: { counter: counterSlice.reducer } });
```


### Benefits Over Classic Redux

- Less boilerplate: No more manual action types or long switch statements for reducers.
- Simplified logic: Actions, reducers, and state are grouped together for better organization.
- Async logic is built-in: Manage data fetching more easily.
- Safer state updates: Built-in immutability enforcement with Immer reduces bugs.[2][6][3]

Redux Toolkit makes modern Redux development much easier, faster, and cleaner, and it is recommended for all new Redux projects.[6][1][2][3]

