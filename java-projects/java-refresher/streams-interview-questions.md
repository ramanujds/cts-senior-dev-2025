## Advanced Java Streams Interview Questions

### 1. Stream Performance and Parallelism
- When and how would you use a parallel stream? What are the performance pitfalls of parallel streams in real-world applications?
- How do you ensure a stream pipeline is suitable for parallel execution?

### 2. Terminal and Intermediate Operations
- Explain the difference between stateful and stateless intermediate operations with examples.
- Give examples where the order of stream operations affects the output or performance.

### 3. Custom Collectors
- How do you implement a custom collector using the `Collector` interface? Can you provide a use-case?
- How does `Collectors.toMap()` handle key collisions? What strategy would you use to merge values?

### 4. Advanced Grouping and Partitioning
- Demonstrate how to group a collection by multiple fields (e.g., group employees by department and then gender) using streams.
- What is the difference between `groupingBy()` and `partitioningBy()`?

### 5. Reduction and Mutability
- What does the `reduce()` method do? Provide an example where you use it for something other than summing integers.
- What are the dangers of using mutable objects in collect, especially with parallel streams?

### 6. Flat Mapping and Nested Structures
- Provide a practical example of using `flatMap()` to flatten a nested structure, such as `List<List<Order>>` to `List<Order>`.
- How is `map()` different from `flatMap()` and when should each be used?

### 7. Exception Handling in Streams
- How do you handle checked exceptions inside lambda expressions in stream pipelines?

### 8. Infinite Streams and Short-Circuiting
- How do you create an infinite stream, and how can you limit its processing?
- What is a short-circuit operation in streams? Give some examples.

### 9. Stream API Limitations and Pitfalls
- Can you explain or demonstrate a memory leak issue that can arise from improper use of streams?
- Why does modifying a source collection while processing with a stream usually cause issues?

### 10. Optional, Null Handling, and Integration
- How do you safely process streams containing potential null elements?
- How would you combine the use of Streams with the `Optional` API for robust code?

