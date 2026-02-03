# HTTP for Backend Engineers  

---

## 1. What is HTTP?

### Theory
HTTP (HyperText Transfer Protocol) is an **application-layer protocol** used for communication between a client and a server over a network.  
It defines **rules**, not implementation details.

HTTP answers questions like:
- How does a client ask for data?
- How does a server respond?
- How do both sides understand each other?

It is:
- Text-based (human readable)
- Stateless by default
- Request–response driven

---

### How HTTP is Implemented
- Runs on top of **TCP** (HTTP/1.1, HTTP/2) or **QUIC/UDP** (HTTP/3)
- Uses sockets internally
- Each request contains all information needed to process it

Backend frameworks (Spring Boot, Node.js, Django) act as **HTTP servers** that:
- Listen on a port
- Parse incoming HTTP requests
- Route them to handlers
- Construct HTTP responses

---

### Real-World Example
- Browser calls `/login`
- Mobile app calls `/api/orders`
- Microservices talk to each other over HTTP/REST

Even when using REST, GraphQL, or gRPC (via HTTP/2), HTTP is still the foundation.

---

## 2. Stateless Nature of HTTP

### Theory
HTTP is **stateless**, meaning:
- The server does not remember previous requests
- Each request is independent

The server treats every request as brand new.

---

### How It’s Implemented
- No automatic session memory
- State must be passed explicitly with each request

Common ways to maintain state:
- Cookies
- Session IDs
- JWT tokens
- Custom headers

---

### Real-World Example
Login flow:
1. User logs in
2. Server generates JWT
3. Client sends JWT with every request

```http
Authorization: Bearer eyJhbGciOiJIUzI1...
````

This scales well because **any server instance can handle the request**.

---

## 3. Evolution of HTTP Versions

### HTTP/1.0

**Theory**

* One request per TCP connection
* Very inefficient

**Implementation**

* Connection opens → request → response → connection closes

**Real-World Impact**

* Slow websites
* High server load

---

### HTTP/1.1

**Theory**

* Persistent connections
* Default version for most APIs

**Implementation**

* `Connection: keep-alive`
* Multiple requests over same TCP connection

**Real-World Impact**

* REST APIs
* Backend services
* Still widely used in production

---

### HTTP/2

**Theory**

* Multiplexing
* Header compression

**Implementation**

* Binary protocol
* Multiple streams over one TCP connection

**Real-World Impact**

* Faster web apps
* Used heavily by browsers and CDNs

---

### HTTP/3

**Theory**

* Built on QUIC (UDP)
* Avoids TCP head-of-line blocking

**Implementation**

* Faster handshakes
* Better performance on unstable networks

**Real-World Impact**

* Mobile networks
* High-latency environments

---

## 4. HTTP Request Structure

### Theory

An HTTP request contains:

1. Request line
2. Headers
3. Optional body

---

### Implementation Example

```http
POST /users HTTP/1.1
Host: api.example.com
Content-Type: application/json
Authorization: Bearer token

{
  "name": "Aisha"
}
```

---

### Real-World Mapping

* URL → Controller mapping
* Headers → Filters / Interceptors
* Body → DTO / Request object

In Spring Boot:

* `@RequestHeader`
* `@RequestBody`
* `@PathVariable`

---

## 5. HTTP Methods (Semantics Matter)

### GET

**Theory**

* Read-only
* No side effects

**Implementation**

* No request body (by convention)

**Real World**

* Fetch user details
* Load dashboard data

---

### POST

**Theory**

* Create new resources
* Not idempotent

**Implementation**

* Request body required

**Real World**

* Create order
* Register user
* Submit form

---

### PUT

**Theory**

* Replace entire resource
* Idempotent

**Implementation**

* Client sends full resource representation

**Real World**

* Update profile completely

---

### PATCH

**Theory**

* Partial update

**Implementation**

* Sends only changed fields

**Real World**

* Update email
* Change password

---

### DELETE

**Theory**

* Remove resource

**Implementation**

* Resource identifier in URL

**Real World**

* Cancel order
* Delete account

---

## 6. Idempotency

### Theory

An operation is idempotent if:

> Multiple identical requests produce the same result.

---

### Implementation Logic

* PUT and DELETE must be safe for retries
* POST must be handled carefully in distributed systems

---

### Real-World Scenario

Payment APIs:

* POST payment → dangerous to retry
* PUT payment status → safe to retry

---

## 7. HTTP Headers

### Theory

Headers carry **metadata**, not data.

They control:

* Authentication
* Caching
* Content format
* Security

---

### Implementation Examples

```http
Content-Type: application/json
Accept: application/json
Authorization: Bearer token
```

---

### Real-World Usage

* API gateways
* Security filters
* Load balancers
* Caching layers

---

## 8. HTTP Status Codes

### Theory

Status codes communicate **outcome**, not data.

---

### Implementation

* Set explicitly in backend
* Used by clients for decision-making

---

### Real-World Mapping

* 200 → success UI
* 401 → redirect to login
* 403 → show access denied
* 500 → show error page

---

## 9. CORS (Cross-Origin Resource Sharing)

### Theory

CORS is a **browser security mechanism**.

Servers don’t block requests. Browsers do.

---

### Implementation

* Browser sends preflight `OPTIONS`
* Server responds with allowed rules

```http
Access-Control-Allow-Origin: https://frontend.com
```

---

### Real-World Scenario

* Frontend on `localhost:3000`
* Backend on `localhost:8080`
* CORS must be configured

---

## 10. HTTP Caching

### Theory

Caching avoids unnecessary server calls.

---

### Implementation Headers

```http
Cache-Control: max-age=3600
ETag: "v2"
```

---

### Real-World Use

* CDN caching
* Browser caching
* API performance optimization

---

## 11. Content Negotiation

### Theory

Same endpoint, multiple formats.

---

### Implementation

```http
Accept: application/json
```

---

### Real-World Example

* Browser wants HTML
* Mobile app wants JSON

---

## 12. Chunked Transfer Encoding

### Theory

Used when response size is unknown.

---

### Implementation

```http
Transfer-Encoding: chunked
```

---

### Real-World Usage

* Streaming logs
* Large file downloads
* Event streams

---

## 13. HTTPS and TLS

### Theory

HTTPS secures HTTP.

Provides:

* Confidentiality
* Integrity
* Authentication

---

### Implementation

* TLS handshake
* Certificates
* Encrypted channel

---

### Real-World Impact

* Secure logins
* Secure payments
* Compliance requirements

---

## 14. HTTP in Microservices

### Theory

HTTP enables loosely coupled services.

---

### Implementation

* REST APIs
* API gateways
* Load balancers

---

### Real-World Example

* Order service → Payment service
* Auth service → User service

---

## 15. Key Interview Takeaways

* HTTP is simple but strict
* Correct semantics prevent bugs
* Headers and status codes matter
* Statelessness enables scalability
* Deep HTTP knowledge beats framework knowledge

---

## Final Thought

If you understand HTTP deeply:

* REST becomes natural
* Debugging becomes easier
* System design decisions become clearer

Frameworks change.
HTTP fundamentals do not.


