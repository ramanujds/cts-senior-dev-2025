import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { App } from './App.jsx'
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, createBrowserRouter, RouterProvider } from 'react-router-dom';
import StockList from './features/stocks/StockList.jsx';
import StockForm from './features/stocks/StockForm.jsx';
import UpdateStock from './features/stocks/UpdateStock.jsx';
import { Provider } from 'react-redux';
import store from './store/store.js';
import Login from "./features/authentication/Login.jsx";

const appRoutes = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: [
      {
        path: '/', element: <StockList />,
        children: [
          { path: '/update/:id', element: <UpdateStock /> }
        ]

      },
      // {path: '/update/:id', element: <UpdateStock /> } ,
      { path: '/add-stock', element: <StockForm /> },
        {path: '/login', element: <Login/>}
    ]
  }
]);

createRoot(document.getElementById('root')).render(
  <Provider store={store}>
    <RouterProvider router={appRoutes}>
      <App />
    </RouterProvider>
  </Provider>


)
