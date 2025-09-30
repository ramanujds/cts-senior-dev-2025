### useState

Manages component-local state.

```js
import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0); // initial value is 0

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>+</button>
      <span>{count}</span>
      <button onClick={() => setCount(count - 1)}>-</button>
    </div>
  );
}
```
This maintains and updates the `count` state.[3][8][1]

***

### useEffect

Performs side effects like fetching data, subscribing, or manually changing the DOM.

```js
import React, { useState, useEffect } from 'react';

function Timer() {
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    const intervalId = setInterval(() => setSeconds(s => s + 1), 1000);
    return () => clearInterval(intervalId); // cleanup on unmount
  }, []); // runs once
  return <div>Seconds: {seconds}</div>;
}
```
This increments `seconds` every second while the component is mounted.

***

### useContext

Allows components to consume context values set by parent providers.

```js
import React, { useContext } from 'react';

const ThemeContext = React.createContext('light');

function ThemedButton() {
  const theme = useContext(ThemeContext);
  return <button className={theme}>Button</button>;
}
```
The button gets the theme value from the context provider.[7][3]

***

### useRef

Creates a mutable value that persists across renders, often for DOM refs.

```js
import React, { useRef } from 'react';

function InputFocus() {
  const inputRef = useRef(null);

  return (
    <>
      <input ref={inputRef} />
      <button onClick={() => inputRef.current.focus()}>Focus</button>
    </>
  );
}
```
The ref `inputRef` enables direct access to the input DOM node.[3][7]

***

### useReducer

Useful for complex state logic—like Redux but local.

```js
import React, { useReducer } from 'react';

function reducer(state, action) {
  switch (action.type) {
    case 'increment': return { count: state.count + 1 };
    case 'decrement': return { count: state.count - 1 };
    default: return state;
  }
}

function Counter() {
  const [state, dispatch] = useReducer(reducer, { count: 0 });
  return (
    <div>
      <button onClick={() => dispatch({ type: 'decrement' })}>-</button>
      {state.count}
      <button onClick={() => dispatch({ type: 'increment' })}>+</button>
    </div>
  );
}
```
This is ideal for state logic that involves multiple actions or complex updates.[2][7][3]

***

### useMemo & useCallback

Optimize performance by memoizing expensive calculations or callbacks.

```js
import React, { useMemo } from 'react';

function ExpensiveCalculation({ num }) {
  const result = useMemo(() => {
    // ...some slow calculation...
    return num * num;
  }, [num]);
  return <div>Result: {result}</div>;
}
```
Memoizes the result, recalculating only if `num` changes.[7]

***

### Custom Hooks

Custom hooks encapsulate reusable logic.

```js
import { useState, useEffect } from 'react';

function useWindowWidth() {
  const [width, setWidth] = useState(window.innerWidth);
  useEffect(() => {
    const handler = () => setWidth(window.innerWidth);
    window.addEventListener('resize', handler);
    return () => window.removeEventListener('resize', handler);
  }, []);
  return width;
}

// Usage:
function App() {
  const width = useWindowWidth();
  return <div>Width: {width}</div>;
}
```
This creates a hook for window width and reuses it in any component.[6][2][7]

***
