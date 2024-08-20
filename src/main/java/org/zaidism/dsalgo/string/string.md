
# Why String is Immutable

**Key points:**

- **String pool** is possible only because `String` is immutable in Java. This way, Java Runtime saves a lot of heap space because different `String` variables can refer to the same `String` variable in the pool.

- If `String` is not immutable, it would cause a severe security threat to the application. For example, database usernames, passwords are passed as `String` to get database connections and in socket programming, host and port details are passed as `String`. Since `String` is immutable, its value can't be changed; otherwise, any hacker could change the referenced value to cause security issues in the application.

- Since `String` is immutable, it is safe for multithreading. A single `String` instance can be shared across different threads. This avoids the use of synchronization for thread safety.

- Since `String` is immutable, its hashcode is cached at the time of creation and it doesn't need to be calculated again. This makes it a great candidate for the key in a `Map` and its processing is faster than other `HashMap` key objects. This is why `String` is the most widely used as `HashMap` keys.

---

- `StringBuffer` and `StringBuilder` classes are mutable and can be used if you want to achieve mutability from `String`.
- `StringBuffer` is thread-safe whereas `StringBuilder` is not thread-safe.

---

1. **`intern()` method:**

   - The `intern()` method is a method of the `String` class in Java. It returns the canonical representation of the string.
   - It searches the pool for the string with the same content. If the string is found, it returns the reference to that string. If not found, it adds the string to the pool and returns its reference.
   - **Usage example:**
     ```java
     String s1 = new String("hello").intern(); // Returns the reference to the string "hello" in the string pool
     ```

2. **`join()` method:**

   - The `join()` method is a method of the `String` class in Java introduced in Java 8. It concatenates the elements of an array, or any `Iterable` object, into a single string with a specified delimiter between each element.
   - **Usage example:**
     ```java
     String[] words = {"Java", "is", "awesome"};
     String result = String.join(" ", words); // Returns "Java is awesome"
     ```

   These are the basic usages of the `intern()` and `join()` methods in Java.

---

# `char[]` array vs `String` for Storing Passwords

For storing passwords, it's generally recommended to use `char[]` array over `String`. Here's why:

- `String` will always be present in the string constant pool until garbage collector clean-up.
- This increases the risk of exposing the password to unauthorized access via memory dumps or string interning.
- `String` values can be directly viewed or printed.
- When accessing a `char[]` array directly, it typically prints the hash code representation of the array object.

---

# How Many Objects are Created?

1. **With the following statements:**
   ```java
   String s1 = new String("Jahid");
   String s2 = "Jahid";
   ```
   **Objects Created:**
   - 2 objects. One in the string pool for `"Jahid"`, and one in the heap for `new String("Jahid")`.

2. **With the following statements:**
   ```java
   String s2 = "Jahid";
   String s1 = new String("Jahid");
   ```
   **Objects Created:**
   - 2 objects. One in the string pool for `"Jahid"`, and one in the heap for `new String("Jahid")`.

