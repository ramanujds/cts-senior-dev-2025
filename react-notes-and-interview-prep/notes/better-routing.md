`createBrowserRouter` is a modern React Router API for configuring routes using declarative route objects instead of JSX. It simplifies route setup, supports nested routes, and integrates seamlessly with React Router's rendering.

***

### How to Use `createBrowserRouter`

1. Define route objects for your pages, layouts, and nested routes.
2. Pass them to `createBrowserRouter`.
3. Use `<RouterProvider>` to apply the router to your app.

***

### Example Using `createBrowserRouter`

```js
import React from 'react';
import { createBrowserRouter, RouterProvider, Outlet } from 'react-router-dom';

// Layout component with Outlet for nested routes
function Layout() {
  return (
    <div>
      <h1>App Layout</h1>
      <Outlet />
    </div>
  );
}

// Pages
function Home() {
  return <h2>Home Page</h2>;
}

function About() {
  return <h2>About Page</h2>;
}

// Define routes as objects
const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      { index: true, element: <Home /> },         // default child route for '/'
      { path: 'about', element: <About /> },      // nested route '/about'
    ],
  },
]);

// Use RouterProvider at app root
export default function App() {
  return <RouterProvider router={router} />;
}
```

***

### Explanation

- `createBrowserRouter` creates a router from route objects.
- The root layout component uses `<Outlet />` to render matched child routes.
- The route `children` array declares nested routes under the root `/`.
- `RouterProvider` supplies routing context and renders matched components.

This declarative API is preferred for complex nested routing setups in React Router v6 and later.`createBrowserRouter` is a modern way in React Router to define routes using route objects instead of JSX, enabling easier nested routing and configuration.[1][2]

### Example using `createBrowserRouter`

```jsx
import React from 'react';
import { createBrowserRouter, RouterProvider, Outlet } from 'react-router-dom';

function Layout() {
  return (
    <div>
      <h1>App Layout</h1>
      <Outlet /> {/* Nested routes will render here */}
    </div>
  );
}

function Home() {
  return <h2>Home Page</h2>;
}

function About() {
  return <h2>About Page</h2>;
}

const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      { index: true, element: <Home /> },        // default child route
      { path: 'about', element: <About /> },
    ],
  },
]);

export default function App() {
  return <RouterProvider router={router} />;
}
```

- `createBrowserRouter` takes route objects defining paths and components.
- `RouterProvider` applies the routing configuration.
- `Outlet` inside `Layout` renders the child route components.
- This approach improves nested routing organization and control.

