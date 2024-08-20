# What is a Marker Interface and Its Significance?

In Java, a marker interface is an interface with no methods, also known as a tag or flag interface. The purpose of a marker interface is to mark a class as having a particular property or special characteristic to JVM. This marking is done implicitly by implementing the marker interface.

Marker interfaces are used to indicate certain behavior or capabilities of classes without specifying the details.

Two well-known marker interfaces in Java are `Serializable` and `Cloneable`.

## Example: `SerializableExample.java` and `CloneableExample.java`

Let's break down why `private static final long serialVersionUID = 1L;` is used in `Serializable` and why the `clone` method is used in:

### 1. `serialVersionUID` for Serializable:

- When a class implements `Serializable`, Java automatically generates a unique identifier for the class known as the `serialVersionUID`. This identifier is used during the serialization and deserialization process to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization.

- If you don't explicitly declare a `serialVersionUID`, the Java runtime system will generate one based on the class structure. However, it's considered good practice to provide an explicit `serialVersionUID` to have control over the versioning of your classes.

- Here, `1L` is an arbitrary value, and you may choose different values based on your versioning strategy. If you don't add new fields/variables to the class, you might keep the `serialVersionUID` unchanged. If you add new fields/variables to the class, you can increment the `serialVersionUID` from `1L` to `2L` as per good practice.

- If you keep the `serialVersionUID` unchanged (e.g., `serialVersionUID = 1L`) even after adding new fields to the class, it can lead to versioning issues during the process of serialization and deserialization.

- If you keep the `serialVersionUID` unchanged, you might face issues like deserialization failure; after deserialization, you might not get new fields added in class in the source file.

- In summary, keeping the `serialVersionUID` unchanged while making incompatible changes to the class (such as adding new fields) is generally not recommended. It's essential to increment the `serialVersionUID` whenever there are structural changes to the class to indicate versioning and maintain compatibility. By doing so, you have better control over the serialization and deserialization process, ensuring that the class versions are recognized as compatible.

### 2. `clone` Method:

- The `clone` method is declared in the `Object` class, and when you override it in your class, using `@Override` ensures that you are correctly overriding the method. It's a good practice to include this annotation to make your code more robust and easier to maintain.

- The `clone` method is declared in the `Cloneable` interface, and it's used to create a copy of the object. By convention, the `clone` method in your class should call `super.clone()` to leverage the default implementation provided by the `Object` class. However, it's important to note that proper cloning may involve more considerations, especially for deep cloning of objects with complex structures.

---

# `hashCode()` and `equals()` Method

- `hashCode()` and `equals()` methods have been defined in the `Object` class, which is the parent of all Java objects. For this reason, all Java objects inherit the default implementation of these methods, but we can override the implementation of these methods.

- When you create two objects with the same content (refer to example `HashCodeAndEquals.java`), and print them, the default value (class name + hexadecimal value) of them will be different as those two objects are created at different places in memory.

- The `equals()` method is checking internally if both the objects are referring to the same object, so by default, both `==` and `equals` will give a false result for equality of objects in our example.

- To define our own logic to determine when objects are equal or not, we need to override the `equals` method inside the class. After overriding the `equals` method, there is still a problem: you can still add these two similar or non-similar objects in a `HashSet`. For similar objects, ideally, it should not happen as a set always contains unique values. The same identical object can be used as a `HashMap` key.

- To resolve this, Java documentation recommends overriding the `hashCode()` method whenever `equals()` is overridden. Additionally, both methods should utilize the same fields (e.g., price and color).

- Once you override the `hashCode` method, there will only be one entry added in the `HashSet`, and without `hashCode`, there will be two entries for identical objects. This is because while creating `hashCode`, we use the same values for both objects for generating the hash code, meaning the generated hash code will always be the same for two identical objects. You can verify this by running the code without the `toString` method.

## `hashCode()` and `equals()` Contract:

- If two objects are equal, they must have the same hash code.
- If two objects have the same hash code, they may or may not be equal.

---

# Why `String` is Immutable

**Key points:**

- String pool is possible only because `String` is immutable in Java. This way, Java Runtime saves a lot of heap space because different `String` variables can refer to the same `String` variable in the pool.

- If `String` were not immutable, it would cause a severe security threat to the application. For example, database usernames and passwords are passed as `String` to get a database connection, and in socket programming, host and port details are passed as `String`. Since `String` is immutable, its value can't be changed; otherwise, any hacker could change the referenced value to cause security issues in the application.

- Since `String` is immutable, it is safe for multithreading. A single `String` instance can be shared across different threads. This avoids the use of synchronization for thread safety.

- Since `String` is immutable, its hash code is cached at the time of creation and doesn't need to be calculated again. This makes it a great candidate for the key in a `Map`, and its processing is faster than other `HashMap` key objects. This is why `String` is the most widely used as `HashMap` keys.

---

# `StringBuffer` and `StringBuilder` Classes

- `StringBuffer` and `StringBuilder` classes are mutable and can be used if you want to achieve mutability from `String`.
- `StringBuffer` is thread-safe, whereas `StringBuilder` is not thread-safe.

---

# `intern()` Method:

- The `intern()` method is a method of the `String` class in Java. It returns the canonical representation of the string.
- It searches the pool for the string with the same content. If the string is found, it returns the reference to that string. If not found, it adds the string to the pool and returns its reference.
- **Usage example:**

  ```java
  String s1 = new String("hello").intern(); // Returns the reference to the string "hello" in the string pool
  ```

# `join()` Method:

- The `join()` method is a method of the `String` class in Java introduced in Java 8. It concatenates the elements of an array or any `Iterable` object into a single string with a specified delimiter between each element.
- **Usage example:**

  ```java
  String[] words = {"Java", "is", "awesome"};
  String result = String.join(" ", words); // Returns "Java is awesome"
  ```

These are the basic usages of the `intern()` and `join()` methods in Java.

---

# `char[]` Array vs `String` for Storing Passwords

For storing passwords, it's generally recommended to use `char[]` array over `String`. Here's why:

- `String` will always be present in the string constant pool until garbage collector cleanup.
- This increases the risk of exposing the password to unauthorized access via memory dumps or string interning.
- `String` values can be directly viewed or printed.
- When accessing a `char[]` array directly, it typically prints the hash code representation of the array object.

---

# Cloning: Shallow vs Deep

In Java, cloning refers to creating a copy of an object. There are two main types of cloning: shallow cloning and deep cloning. Let's explain each with clear, easy-to-understand language and code examples: `CloningTechniques.java`

### Shallow Cloning:

- **Description:** Shallow cloning creates a new object and copies all the fields of the original object to the new object. However, if the fields of the original object are references to other objects, shallow cloning only copies the references, not the actual objects. As a result, both the original object and the cloned object share references to the same objects. Changes made to the shared objects through one object will affect the other object as well.

  In your `shallowClone` method, you clone the `Person` object using the default `clone()` method, which performs shallow cloning. This means that the `address` field in both the original `Person` object and the shallow cloned `Person` object points to the same `Address` object in memory. As a result, changes made to the `address` field in the shallow cloned `Person` object will affect the original `Person` object as well.

### Deep Cloning:

- **Description:** Deep cloning creates a

 new object and recursively copies all fields of the original object, including any objects referenced by the fields. This means that all objects within the original object hierarchy are duplicated. As a result, the cloned object and the original object are entirely independent of each other, and changes made to one object won't affect the other.
```
