### How to Implement Route Guards in React Router

#### Common Approach: Protected Route Component

1. Create a reusable `ProtectedRoute` component that:
    - Checks a condition (e.g., user is logged in).
    - If allowed, renders the child route/component.
    - If not allowed, redirects to a login page or another route.

2. Use this component to wrap guarded routes.

***

### Example: Simple Auth Guard

```js
import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

// Simulate authentication status
const isAuthenticated = () => {
  // Logic to check auth status, e.g. token present, user context
  return localStorage.getItem('userToken') !== null;
};

function ProtectedRoute() {
  if (!isAuthenticated()) {
    // Redirect to login if not authenticated
    return <Navigate to="/login" replace />;
  }
  // Render child routes if authenticated
  return <Outlet />;
}
```

### Usage in Routes

With nested routes and `createBrowserRouter`:

```js
const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      { index: true, element: <Home /> },
      {
        element: <ProtectedRoute />,  // Guarded routes go here
        children: [
          { path: 'dashboard', element: <Dashboard /> },
          { path: 'profile', element: <Profile /> },
        ],
      },
      { path: 'login', element: <Login /> },
    ],
  },
]);
```

- Unauthenticated users trying to access `/dashboard` or `/profile` get redirected to `/login`.
- Authenticated users can access the guarded routes.[1][2]

***

