## 1. Core React Concepts

**Q1. What are the differences between functional and class components in React?**

* **Class Components**: Use ES6 classes, have lifecycle methods (`componentDidMount`, `componentDidUpdate`), and manage state using `this.state`.
* **Functional Components**: Plain JavaScript functions, rely on **hooks** (`useState`, `useEffect`, etc.) for state and lifecycle management.
* Modern React favors **functional components + hooks** due to better readability, reusability, and performance.

---

**Q2. Explain the concept of Virtual DOM in React.**

* Virtual DOM is a lightweight in-memory representation of the real DOM.
* When state changes, React creates a new Virtual DOM tree and compares it with the previous one using **diffing algorithm**.
* Only the parts that changed are updated in the actual DOM (via **reconciliation**).
* This improves performance by reducing costly direct DOM manipulations.

---

**Q3. What are React Hooks? Name some commonly used ones.**

* Hooks are functions that let you use state and lifecycle in functional components.
* Common Hooks:

    * `useState` – state management
    * `useEffect` – side effects (API calls, event listeners)
    * `useContext` – consume context
    * `useRef` – access/manipulate DOM or persist values
    * `useMemo` – memoize expensive calculations
    * `useCallback` – memoize functions

---

## 2. State Management

**Q4. What is the difference between local state and global state?**

* **Local State**: Managed inside a single component (e.g., form inputs with `useState`).
* **Global State**: Shared across multiple components (e.g., authentication, theme, cart items).
* For global state, libraries like **Redux, Zustand, Jotai, Recoil** or React’s built-in **Context API** are used.

---

**Q5. When would you use Redux vs Context API?**

* **Context API**: Best for small apps or simple global states (theme, user). Easy to use, but not optimized for frequent updates.
* **Redux**: Best for large-scale apps with complex state and predictable state transitions. Comes with middleware support (like Redux Thunk, Redux Saga) for async logic.

---

## 3. Lifecycle & Performance

**Q6. What are React lifecycle methods in class components, and how are they replaced in functional components?**

* **Class Methods**: `componentDidMount`, `componentDidUpdate`, `componentWillUnmount`.
* **Functional Hooks Equivalent**: `useEffect` with proper dependency arrays handles all three.

---

**Q7. How do you optimize performance in a React app?**

* Use **React.memo** to prevent unnecessary re-renders.
* Use **useCallback** and **useMemo** to memoize functions and values.
* Lazy load components with `React.lazy` and `Suspense`.
* Virtualize long lists with `react-window` or `react-virtualized`.
* Avoid passing new objects/functions as props unnecessarily.

---

## 4. Advanced Concepts

**Q8. Explain React reconciliation.**

* React uses the **diffing algorithm** to compare Virtual DOM trees.
* It updates only the nodes that have changed (instead of re-rendering the whole tree).
* Key prop plays a big role in reconciliation when rendering lists.

---

**Q9. What are controlled vs uncontrolled components?**

* **Controlled Component**: Form data is handled by React state. Example: `<input value={state} onChange={...} />`.
* **Uncontrolled Component**: Form data is handled by DOM itself via refs. Example: `<input ref={myRef} />`.
* Controlled is preferred for consistency and validation, though uncontrolled is simpler for basic use cases.

---

**Q10. What are custom hooks? Can you give an example use case?**

* Custom hooks are reusable functions that encapsulate logic using React’s hooks.
* Example: `useFetch` for fetching data or `useAuth` for authentication logic.
* Benefit: Increases code reuse and readability.

---


**Q11. How would you fetch data in React?**

* Using `useEffect` with `fetch` or `axios`:

```javascript
const [data, setData] = useState([]);

useEffect(() => {
  fetch('/api/data')
    .then(res => res.json())
    .then(setData)
    .catch(console.error);
}, []);
```

* Alternatively, use React Query / SWR for caching and better API state management.

---

**Q12. How would you handle forms in React?**

* Controlled components (bind inputs with state).
* Use libraries like `Formik` or `React Hook Form` for large, complex forms with validation.

---

**Q13. What is the significance of the `key` prop in lists?**

* Helps React identify which items changed, added, or removed.
* Keys must be unique among siblings.
* Avoid using array index as key if the list can change, as it causes re-rendering issues.

---

**Q14. Difference between SSR, CSR, and SSG in React ecosystem?**

* **CSR (Client-Side Rendering)**: Default React apps (CRA). Rendering happens in browser after JS loads.
* **SSR (Server-Side Rendering)**: Pages rendered on server first (Next.js) → better SEO & faster initial load.
* **SSG (Static Site Generation)**: Pages pre-rendered at build time (Next.js) → best for blogs/docs.


**Q15. What are React fragments and why are they used?**

* `<React.Fragment>` or shorthand `<>...</>` allows grouping elements without adding extra DOM nodes.
* Useful to avoid unnecessary wrappers like `<div>`.

