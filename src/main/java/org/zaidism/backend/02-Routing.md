# Routing in Backend Systems

---

## 1. What is Routing?

### Core Idea
Routing expresses the **“where”** of a request.

When a client sends an HTTP request, routing determines:
- **Which URL path** is being accessed
- **Which HTTP method** is used (GET, POST, PUT, DELETE)
- **Which server-side handler** should execute business logic

In simple terms:
> Routing answers the question: *“Which piece of backend code should handle this request?”*

---

### Real-World Example
Imagine an **online bookstore API**:

| Request | Meaning |
|------|-------|
| `GET /api/books` | Fetch all books |
| `POST /api/books` | Add a new book |
| `GET /api/books/42` | Fetch book with ID 42 |

Even though all requests hit the same server, **routing decides which handler runs**.

---

### Request → Handler Flow
```

Client
|
|  GET /api/books/42
v
Web Server
|
|  Route Match
v
Controller / Handler
|
|  Business Logic
|  Database Call
v
Response (JSON)

```

---

## 2. Static Routes

### What They Are
Static routes have **no variable parts** in the URL.

The path is **fixed and constant**.

Example:
```

/api/books

```

This route always represents the same resource.

---

### Real-World Example
**Use case: Fetch all books**

```

GET /api/books

````

What happens:
- No parameters to extract
- Server always returns a list of books
- Same structure every time

Typical response:
```json
[
  { "id": 1, "title": "Clean Code" },
  { "id": 2, "title": "Effective Java" }
]
````

---

### When Static Routes Are Used

* Listing resources
* Health checks (`/health`)
* Static configuration (`/api/version`)
* Creating resources (`POST /api/orders`)

---

## 3. Dynamic Routes (Path Parameters)

### What They Are

Dynamic routes contain **variable segments** in the URL path.

Example:

```
/api/users/123
```

Here, `123` is **dynamic** and represents a specific user.

---

### How Servers Define Them

Common convention:

```
/api/users/:id
```

* `:id` is a placeholder
* Any value in that position becomes a path parameter

---

### Real-World Example

**Use case: Fetch user profile**

```
GET /api/users/123
```

Server logic:

* Extract `id = 123`
* Query database for user with ID 123
* Return user details

```json
{
  "id": 123,
  "name": "Aisha",
  "email": "aisha@example.com"
}
```

---

### Path Parameter Flow

```
Request URL: /api/users/123
                 |
                 v
Route Pattern: /api/users/:id
                 |
                 v
Extract id = 123
                 |
                 v
Database Query
```

---

### Why Path Parameters Matter

* URLs become **human-readable**
* Clear **semantic meaning**
* Align well with REST principles

---

## 4. Query Parameters

### What They Are

Query parameters are **key-value pairs** appended after `?`.

Example:

```
/api/books?page=2&limit=10
```

---

### Key Differences from Path Parameters

| Path Parameters       | Query Parameters         |
| --------------------- | ------------------------ |
| Identify a resource   | Modify or filter results |
| Part of URL structure | Optional metadata        |
| Semantic meaning      | Operational meaning      |

---

### Real-World Examples

#### Pagination

```
GET /api/books?page=2&limit=10
```

Meaning:

* Fetch the second page
* Return 10 items per page

#### Filtering

```
GET /api/books?author=martin
```

Meaning:

* Fetch books written by Martin

---

### Why Mostly Used with GET

* GET requests usually **don’t have a request body**
* Query params provide a clean way to pass optional data

---

### Query Parameter Flow

```
/api/books?page=2&limit=10
        |
        v
Handler receives:
  page = 2
  limit = 10
        |
        v
Database Query with OFFSET & LIMIT
```

---

## 5. Nested Routes

### What They Are

Nested routes represent **relationships between resources**.

Example:

```
/api/users/123/posts/456
```

This expresses:

> Fetch post `456` that belongs to user `123`

---

### Real-World Example

**Social Media Platform**

| Route                      | Meaning                    |
| -------------------------- | -------------------------- |
| `/api/users/123/posts`     | All posts by user 123      |
| `/api/users/123/posts/456` | Specific post by that user |
| `/api/users/123/followers` | Followers of user 123      |

---

### Why Nested Routes Are Powerful

* Clear ownership and hierarchy
* Prevents ambiguous access
* Improves API readability

---

### Nested Routing Flow

```
/api/users/123/posts/456
        |
        v
Extract userId = 123
Extract postId = 456
        |
        v
Validate post belongs to user
        |
        v
Return post data
```

---

## 6. Route Versioning and Deprecation

### Why Versioning Exists

APIs evolve:

* New fields
* Changed response formats
* Removed properties

Without versioning, changes would **break existing clients**.

---

### Common Versioning Pattern

```
/api/v1/products
/api/v2/products
```

---

### Real-World Example

**v1 response**

```json
{
  "id": 1,
  "price": 1000
}
```

**v2 response**

```json
{
  "id": 1,
  "price": {
    "amount": 1000,
    "currency": "INR"
  }
}
```

Both versions can coexist safely.

---

### Deprecation Strategy

1. Release `/v2`
2. Mark `/v1` as deprecated
3. Give clients time to migrate
4. Remove `/v1` later

---

### Versioning Flow

```
Client App
   |
   |  /api/v1/products
   v
Old Handler (Deprecated)

Client App (Updated)
   |
   |  /api/v2/products
   v
New Handler
```

---

## 7. Catch-All Routes

### What They Are

Catch-all routes handle **unmatched URLs**.

Common pattern:

```
/*
```

---

### Real-World Example

User hits:

```
GET /api/unknown/route
```

Without catch-all:

* Server may crash
* Client gets unclear error

With catch-all:

```json
{
  "error": "Route not found"
}
```

---

### Why Catch-All Routes Matter

* Graceful error handling
* Better developer experience
* Useful for logging invalid requests

---

### Catch-All Flow

```
Incoming Request
        |
        v
Check Defined Routes
        |
        v
No Match Found
        |
        v
Catch-All Handler
        |
        v
404 Response
```

---