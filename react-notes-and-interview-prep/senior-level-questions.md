## 1. **State & Data Handling**

**Q1. You’re building a search bar that fetches results as the user types. How do you optimize it?**

* Use **debouncing** with `setTimeout` or libraries like `lodash.debounce` to delay API calls until typing stops.
* Cancel previous requests if a new one is triggered (use `AbortController` or axios cancel token).
* Cache results for repeated searches (React Query, local state, or Redux).

---

**Q2. You have a list of 5000 records to display. How do you render it efficiently?**

* Use **virtualization** (`react-window` / `react-virtualized`) to render only visible items.
* Pagination or infinite scroll to load data in chunks.
* Avoid inline functions/objects to prevent re-renders.

---


**Q3. How would you implement dark mode in a React app?**

* Maintain a `theme` state (light/dark).
* Use **Context API** or a state manager (Redux, Zustand) to provide theme across components.
* Store preference in **localStorage** or use OS setting via `prefers-color-scheme` media query.

---

**Q4. You have a parent component re-rendering often, causing child components to re-render unnecessarily. What would you do?**

* Use **React.memo** for child components.
* Use `useCallback` to memoize callback props.
* Use `useMemo` for expensive calculations.
* Split components into smaller, more focused components.

---

**Q5. How would you build a form with multiple steps (wizard form)?**

* Maintain a **step index** state.
* Render fields based on current step.
* Save form data in local state (or global if needed).
* Validation at each step (Formik, React Hook Form, or Yup schema).

---

**Q6. You need to validate form inputs in real-time (e.g., username availability). How would you handle it?**

* Use controlled inputs with `onChange`.
* Debounce API calls to check availability.
* Provide feedback (spinner, error message, success).

---


**Q7. How do you handle API errors in React gracefully?**

* Use **try/catch** around fetch calls.
* Show error messages in the UI with retry options.
* Use an **error boundary** for unexpected runtime errors.
* For centralized handling: Interceptors in axios or middleware in Redux.

---

**Q8. Your app has multiple components fetching the same API. How do you avoid duplicate requests?**

* Use a global state manager (Redux, Zustand, React Query).
* React Query automatically caches and deduplicates requests.
* If using plain fetch, store results in Context or higher-level state and reuse.

---

## 5. **Routing & Navigation**

**Q9. You need to protect certain routes (e.g., dashboard, profile). How would you implement authentication?**

* Use **React Router’s Private Routes**:

    * Check if user is authenticated.
    * If yes → render component.
    * If no → redirect to login.
* Store auth status in Context/Redux.
* Refresh tokens via interceptors or background refresh.


**Q10. How would you implement nested routes (e.g., `/dashboard/settings/profile`)?**

* Use **React Router v6 nested routes** with `<Outlet />`.
* Example:

```jsx
<Route path="/dashboard" element={<Dashboard />}>
  <Route path="settings" element={<Settings />} />
  <Route path="profile" element={<Profile />} />
</Route>
```

---

## 6. **Performance & Optimization**

**Q11. Your React app feels slow after scaling. How do you debug and optimize it?**

* Use **React DevTools profiler** to check re-renders.
* Check network calls & API bottlenecks.
* Code-splitting with `React.lazy` and `Suspense`.
* Optimize images (lazy load, WebP).
* Memoize heavy calculations.

---

**Q12. You notice frequent re-renders when updating global state. How do you fix it?**

* Use Context API carefully (too broad → unnecessary re-renders).
* Split contexts (AuthContext, ThemeContext separately).
* Use state management libraries with selectors (Zustand, Redux Toolkit).

---

## 7. **Testing & Deployment**

**Q13. How would you test a React component that makes an API call?**

* Mock API calls using `jest.fn()` or `msw` (Mock Service Worker).
* Test loading, success, and error states.
* Use React Testing Library for rendering and user interaction simulation.

---

**Q14. Your app should load fast on slow networks. How would you achieve this?**

* Code splitting & lazy loading routes.
* Preloading critical assets.
* Use CDN for static files.
* Implement PWA (Progressive Web App) for offline support.

---


**Q15. You need to implement a shopping cart feature. How would you manage state?**

* Use global state (Redux, Context API).
* Cart actions: add, remove, update quantity.
* Persist cart in **localStorage** or backend.

---

**Q16. How would you implement infinite scrolling (like Twitter feed)?**

* Use an Intersection Observer API to detect when user reaches bottom.
* Fetch next page of results.
* Append results to existing state.
* Use React Query’s `fetchNextPage`.

