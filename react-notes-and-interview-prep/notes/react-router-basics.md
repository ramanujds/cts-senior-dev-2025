### How to Use React Router

#### 1. Install React Router

In your project directory, run:

```bash
npm install react-router-dom
```

#### 2. Create Simple Views (Pages)

For demonstration, define the following components:

```js
function Home() { return <h1>Home Page</h1>; }
function About() { return <h1>About Page</h1>; }
function Contact() { return <h1>Contact Page</h1>; }
```


#### 3. Set Up the Router in Your App

Wrap your app with `BrowserRouter`, and define routes using `Routes` and `Route`:

```js
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      {/* Navigation Links */}
      <nav>
        <Link to="/">Home</Link> |{" "}
        <Link to="/about">About</Link> |{" "}
        <Link to="/contact">Contact</Link>
      </nav>

      {/* Routing Setup */}
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
      </Routes>
    </BrowserRouter>
  );
}
```

- `BrowserRouter` enables routing functionality.
- `Link` changes the URL and navigates to the corresponding route.
- `Routes` wraps all route definitions.
- `Route` maps specific paths to components.[4][1]

***

### Why Use React Router?

- Adds multi-page navigation to your single-page app.
- Handles deep linking and browser history.
- Enables URL parameters, nested and protected routes, dynamic and programmatic navigation.

***

#### Example Navigation Table

| Path         | Displayed Component   |
|--------------|----------------------|
| `/`          | Home                 |
| `/about`     | About                |
| `/contact`   | Contact              |

React Router is essential for building robust, navigable, and scalable React applications.React Router is a library that enables navigation and routing for single-page React applications. It lets developers define multiple views or pages, control navigation, handle browser history, and manage route parameters—a necessity for complex or multi-page apps.[4][1]

### Installation and Setup

Install React Router with:

```bash
npm install react-router-dom
```

In your app, wrap content with `BrowserRouter`:

```js
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      {/* Your routes and navigation go here */}
    </BrowserRouter>
  );
}
```


### Defining Routes and Navigation

Import `Routes`, `Route`, and `Link` to set up basic multi-page routing:

```js
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

function Home() { return <h1>Home Page</h1>; }
function About() { return <h1>About Page</h1>; }
function Contact() { return <h1>Contact Page</h1>; }

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">Home</Link> |{" "}
        <Link to="/about">About</Link> |{" "}
        <Link to="/contact">Contact</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
      </Routes>
    </BrowserRouter>
  );
}

```

### React Router `Outlet` and `RouteProvider` Explanation with Examples

***

## What is `Outlet`?

`Outlet` is a component from React Router that acts as a placeholder for rendering child routes inside a parent route component. It allows layouts or parent components to define a shared UI structure (like headers, navigation bars, footers), and dynamically inject child route components at the location of the `<Outlet />`.

### Why use `Outlet`?

- Enables nested routing where multiple child routes can share a common layout.
- Keeps code organized by preventing duplication of shared UI.
- Allows child components to render within the parent layout dynamically.

***

## Example Using `Outlet`

### 1. Layout with `<Outlet>`

```js
import { Outlet } from 'react-router-dom';

function Layout() {
  return (
    <div>
      <header>My App Header</header>
      <nav>Navigation Bar</nav>
      <main>
        <Outlet /> {/* Render matched child routes here */}
      </main>
      <footer>My App Footer</footer>
    </div>
  );
}
```

### 2. Define Routes with Nested Children

```js
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './Layout';
import Home from './Home';
import About from './About';
import Contact from './Contact';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />           {/* Renders at "/" */}
          <Route path="about" element={<About />} />   {/* Renders at "/about" */}
          <Route path="contact" element={<Contact />} /> {/* Renders at "/contact" */}
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
```

- The `Layout` component wraps all child routes.
- The `Outlet` in `Layout` ensures the matching child route (`Home`, `About`, or `Contact`) renders inside the `main` section when visiting corresponding URLs.

***

