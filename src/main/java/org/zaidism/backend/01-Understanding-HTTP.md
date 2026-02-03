# HTTP Fundamentals (Interview Notes for Backend Engineers)

## HTTP Fundamentals

### HTTP Protocol Basics
- The primary medium for browsers and servers to communicate (send and receive data).
- One of the most widely used protocols.

### Statelessness
- HTTP has no memory of past interactions.
- Each request is self-contained and carries all necessary information (headers, URLs, methods, authentication tokens, session info).

**Benefits:**
- **Simplicity:** Simplifies server architecture by not needing to store session information.
- **Scalability:** Easy to distribute requests across multiple servers, as no single server tracks a session.
- **Resilience:** Server crashes do not affect client interaction state.

**State Management:**
- Developers often implement techniques like cookies, sessions, or tokens for continuity (e.g., user logins, shopping carts).

---

## Client-Server Model
- Always involves a client (e.g., web browser, application) initiating communication by sending requests.
- A server hosts resources (websites, APIs) and responds to client requests.
- Communication is always initiated by the client.

---

## HTTP vs HTTPS
- HTTPS is a more secure version of HTTP (encryption, security certificates, TLS).
- Uses the same underlying HTTP principles.

---

## TCP/IP Connection
- HTTP relies on TCP (Transmission Control Protocol) for reliable, connection-based communication.
- Backend engineers primarily deal with the Application Layer (Layer 7) of the OSI model.

---

## Evolution of HTTP

### HTTP 1.0
- Each request opened a new connection, leading to inefficiencies.

### HTTP 1.1
- Introduced persistent connections.
- Supports multiple requests/responses over one TCP connection.
- Added chunked transfer encoding and better caching mechanisms.

### HTTP 2.0
- Introduced multiplexing (multiple requests/responses over a single connection).
- Binary framing.
- Header compression (HPACK).
- Server push.

### HTTP 3.0
- Built on QUIC protocol (over UDP).
- Faster connection establishment.
- Reduced latency.
- Better packet loss handling.
- Multiplexing without head-of-line blocking.

---

## HTTP Messages

### Request Message
- Sent by the client.
- Request Method (e.g., GET, POST).
- Resource URL.
- HTTP Version (e.g., HTTP/1.1).
- Host (domain of the frontend).
- Headers (key-value pairs of metadata).
- Blank line (separates headers from the body).
- Request Body (information client sends to the server).

### Response Message
- Received by the client from the server.
- HTTP Version.
- Status Code (e.g., 200 OK, 404 Not Found).
- Response Headers.
- Blank line.
- Response Body (content returned by the server).

---

## HTTP Headers

### Purpose
- Provide metadata about the request or response.
- Allow intermediate systems (like proxies) and servers to understand and process messages without inspecting the body.

### Categories

#### Request Headers
- Sent by the client to provide info about the request.
- Examples: User-Agent, Authorization, Accept.

#### General Headers
- Used in both requests and responses for message metadata.
- Examples: Date, Cache-Control, Connection.

#### Representation Headers
- Deal with the representation of the transmitted resource.
- Examples: Content-Type, Content-Length, Content-Encoding, ETag.

#### Security Headers
- Enhance security by controlling behaviors like content loading and cookies.
- Examples: HSTS, Content-Security-Policy, X-Frame-Options.

### Key Ideas
- **Extensibility:** Headers can be easily added or customized without altering the underlying protocol.
- **Remote Control:** Clients send instructions/preferences to the server via headers (e.g., Accept, Cache-Control, Authorization).

---

## HTTP Methods

### Purpose
- Represent different actions a client can request on a server.
- Define the intent of the interaction.

### Common Methods
- **GET:** Fetch data; should not modify anything on the server.
- **POST:** Create data; typically has a request body.
- **PATCH:** Update partial data; has a request body.
- **PUT:** Update data by completely replacing the previous instance with the request body.
- **DELETE:** Delete a resource.

---

## Idempotent vs Non-Idempotent

### Idempotent Methods
- Can be called multiple times and yield the same result.
- GET: Fetching data multiple times yields the same data.
- PUT: Replacing data multiple times results in the same final state.
- DELETE: Deleting a resource once means subsequent delete attempts have the same outcome.

### Non-Idempotent Methods
- Calling multiple times can produce different results.
- POST: Multiple calls can create multiple resources.

---

## OPTIONS Method and CORS Workflow

### OPTIONS Method
- Used to fetch the capabilities of a server for a cross-origin request.
- Commonly seen in pre-flight requests in the browser's network tab.

### CORS (Cross-Origin Resource Sharing)
- A security mechanism enforced by browsers due to the Same-Origin Policy.

#### Same-Origin Policy
- Restricts web pages from making requests to a different domain than their own.

---

## CORS Request Flows

### Simple Request Flow
- Browser adds Origin header.
- Server checks Origin against its policy.
- If allowed, server includes Access-Control-Allow-Origin header.
- Browser allows response if the header is present and valid.

### Pre-flight Request Flow
- Occurs when:
    - Method is not GET/POST/HEAD.
    - Custom headers are used.
    - Content-Type is not application/x-www-form-urlencoded, multipart/form-data, or text/plain.
- Browser sends an OPTIONS request.
- Server responds with:
    - Access-Control-Allow-Origin
    - Access-Control-Allow-Methods
    - Access-Control-Allow-Headers
    - Access-Control-Max-Age
- If successful, the original request is sent.

---

## HTTP Response Status Codes

### Purpose
- Communicate the result of a request in a standardized way.
- Help clients understand success, failure, or required actions.

### Categories

#### 1xx – Informational
- Server received headers, client can proceed.
- Examples: 100 Continue, 101 Switching Protocols.

#### 2xx – Success
- 200 OK
- 201 Created
- 204 No Content

#### 3xx – Redirection
- 301 Moved Permanently
- 302 Found
- 304 Not Modified

#### 4xx – Client Errors
- 400 Bad Request
- 401 Unauthorized
- 403 Forbidden
- 404 Not Found
- 405 Method Not Allowed
- 409 Conflict
- 429 Too Many Requests

#### 5xx – Server Errors
- Server failed to fulfill a valid request.
- Indicates server-side issues.
