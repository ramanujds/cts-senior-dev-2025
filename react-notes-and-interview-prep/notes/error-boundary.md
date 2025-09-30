### How Error Boundaries Work

- Error boundaries only catch errors in components below them in the tree.
- They do NOT catch errors in event handlers, asynchronous code (like `setTimeout`), or server-side rendering.
- You implement an error boundary by defining either (or both) the lifecycle methods `static getDerivedStateFromError()` and `componentDidCatch()` in a class component.[3][1]
- When an error is caught, you can log error details and show a custom fallback UI.[4]

### Example: Basic Error Boundary

```js
import React from 'react';

class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  static getDerivedStateFromError(error) {
    return { hasError: true };
  }

  componentDidCatch(error, errorInfo) {
    console.error("Error caught by boundary:", error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    return this.props.children;
  }
}

export default ErrorBoundary;
```

### Usage

Wrap any part of your component tree with the error boundary:

```js
<ErrorBoundary>
  <MyComponent />
</ErrorBoundary>
```
If `MyComponent` or any of its children throw errors in render, constructor, or lifecycle methods, `ErrorBoundary` will catch those errors and display the fallback UI instead of breaking the entire app.[2][5][1]

Error boundaries are essential for robust React apps, letting you gracefully handle and recover from unexpected errors.[3][4]
