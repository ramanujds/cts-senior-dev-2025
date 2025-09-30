### What is Context?

- Context lets you share data (like theme, user info, settings) globally across the component tree.
- It avoids passing props manually through every intermediate component (prop drilling).

### What `useContext` Does

- It lets functional components **read the current context value** from the nearest matching Context Provider above in the tree.
- It automatically triggers re-rendering of components when the context value changes.
- It simplifies state sharing across deeply nested components.

### How to Use `useContext`

1. **Create Context:**
   ```js
   import React, { createContext } from 'react';
   const MyContext = createContext(defaultValue);
   ```

2. **Provide Context value:**
   ```jsx
   <MyContext.Provider value={someValue}>
     <YourComponent />
   </MyContext.Provider>
   ```

3. **Consume Context in a component:**
   ```js
   import React, { useContext } from 'react';
   const value = useContext(MyContext);
   ```

### Example

```jsx
import React, { createContext, useContext, useState } from 'react';

const ThemeContext = createContext('light');

function ThemedButton() {
  const theme = useContext(ThemeContext);
  return <button style={{ background: theme === 'dark' ? '#333' : '#eee' }}>Button</button>;
}

function App() {
  const [theme, setTheme] = useState('light');
  return (
    <ThemeContext.Provider value={theme}>
      <ThemedButton />
      <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>
        Toggle Theme
      </button>
    </ThemeContext.Provider>
  );
}
```

### Why useContext?

- Prevents prop drilling and keeps components cleaner.
- Easily share global state like theme, authentication, or user preferences.
- Works well with other hooks like `useReducer` for global state management without external libraries.
- Automatically updates subscribed components when context value changes.[3][4][5]

***
