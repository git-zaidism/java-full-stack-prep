# Data Structures & Algorithms - Theory

## Time Complexity

### What is Time Complexity?

Time complexity is not the actual time taken to run an algorithm. Instead, it describes how the algorithm's running time grows relative to the input size. It's a theoretical measure of performance as input size increases.

### Complexity Comparison

$$O(1) < O(\log n) < O(n) < O(n \log n) < O(n^2)$$

### Common Time Complexities

- **O(1) – Constant time:** Execution time does not depend on input size.
- **O(log n) – Logarithmic time:** Grows slowly as input size increases (e.g., binary search).
- **O(n) – Linear time:** Time grows proportionally with input size.
- **O(n log n) – Log-linear time:** Typical for efficient sorting algorithms like mergesort or heapsort.
- **O(n²) – Quadratic time:** Often found in algorithms with nested loops (e.g., bubble sort), where n could be the input size.

---

## Big O, Omega, and Theta Notation

Big O notation is a way to describe how fast an algorithm is or how much space it needs as the input gets bigger.

### Notations Explained

- **O(n) – Big O (Upper Bound):** The algorithm will take at most n steps (or use at most n space) when the input size is n. It won't grow faster than n.

- **Ω(n) – Omega (Lower Bound):** The algorithm will take at least n steps (or use at least n space) when the input size is n. It won't be faster than that—it grows no slower than n.

- **Θ(n) – Theta (Tight Bound):** The algorithm takes exactly about n steps (or space) as the input size grows. In other words, the algorithm's performance grows at the same rate as the input size.

### Quick Comparison

| Notation | Meaning | Description |
|----------|---------|-------------|
| O(n) | Upper Bound | At most n steps |
| Ω(n) | Lower Bound | At least n steps |
| Θ(n) | Tight Bound | Exactly n steps |

It's like saying: The algorithm is no faster than n steps (like O(n)), and also no slower than n steps (like Ω(n)). So, it's exactly proportional to n.

---

## Space Complexity

$$\text{Space Complexity} = \text{Auxiliary Space} + \text{Input Space}$$

- **Auxiliary Space:** Space required to solve the problem (typically what we consider in analysis)
- **Input Space:** Space needed to store the input

---

## Common Loop Time Complexities

| Loop Code | Time Complexity |
|-----------|-----------------|
| `for (i = 0; i < n; i++)` | O(n) |
| `for (i = 1; i < n; i = i + 2)` | O(n) |
| `for (i = n; i > 1; i--)` | O(n) |
| `for (i = 1; i < n; i = i * 2)` | O(log n) |
| `for (i = 1; i < n; i = i * 3)` | O(log n) |
| `for (i = n; i > 1; i = i / 2)` | O(log n) |

---
