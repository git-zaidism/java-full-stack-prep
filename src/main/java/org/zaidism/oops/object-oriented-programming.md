# Object-Oriented Programming (OOP) Concepts

## ✅ Core OOP Concepts with Real-World Examples

### 1. Encapsulation

**Definition:** Encapsulation is about controlling access to an object's internal state. It hides data using private fields and provides access through public getter and setter methods.

**Real-World Example:** In an e-commerce application, a `Product` class might encapsulate inventory logic so that product quantity can only be changed in controlled ways.

```java
public class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient stock!");
        }
    }

    public String getName() {
        return name;
    }
}
```

---

### 2. Inheritance

**Definition:** Inheritance allows a class to reuse the properties and behavior of another class. This promotes code reusability.

**Real-World Example:** A `BaseEntity` class that contains common fields for all entities like `id`, `createdAt`, and `updatedAt`.

```java
public class BaseEntity {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}

public class User extends BaseEntity {
    private String name;
    private String email;

    // Getters and setters
}
```

**Reference:** [Inheritance in Java](https://www.scaler.com/topics/java/inheritance-in-java/)

---

### 3. Abstraction

**Definition:** Abstraction hides complex internal logic and exposes only the necessary functionality to the user.

**Real-World Example:** You can use utility methods like `Math.max()` or collection methods like `Set.remove()` without knowing how they are implemented internally.

```java
public class AbstractionExample {
    public static void main(String[] args) {
        int max = Math.max(10, 20); // Abstracts the comparison logic
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.remove("apple"); // You don't know if it uses hashing or not
    }
}
```

---

### 4. Polymorphism

**Definition:** Polymorphism allows one interface to have multiple implementations, and the behavior can vary based on the actual object at runtime.

**Real-World Example:** A `NotificationService` interface with different implementations for Email, SMS, and Push notifications.

```java
public interface NotificationService {
    void sendNotification(String message);
}

public class EmailNotificationService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Email: " + message);
    }
}

public class SMSNotificationService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("SMS: " + message);
    }
}

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final List<NotificationService> notificationServices;

    public NotificationController(List<NotificationService> notificationServices) {
        this.notificationServices = notificationServices;
    }

    @GetMapping("/send")
    public String sendNotification() {
        for (NotificationService service : notificationServices) {
            service.sendNotification("heiiii"); // polymorphic call
        }
        return "Notifications sent to all channels!";
    }
}
```

---

## ✅ OOP Concepts Summary

| Concept       | Purpose                               | Real-World Analogy                                   |
|---------------|---------------------------------------|------------------------------------------------------|
| Encapsulation | Protect internal state                | Secure access to product inventory                   |
| Inheritance   | Reuse code                            | Common entity fields shared across multiple classes  |
| Abstraction   | Hide complexity, expose functionality | Using `Set.remove()` or `Math.max()`                 |
| Polymorphism  | One interface, many implementations   | Email/SMS/Push services under `NotificationService` |

---

## 📚 Key OOP Principles

- A single `.java` file can have a maximum of only one public class, and the name of the public class will always be the same as the file name.
- We can have multiple classes in a `.java` file which are not public.
- **Class:** Blueprint of object which has some properties (variables) and behavior (methods). 
- **Object:** An instance of a class.
  - *Example:* Human is a template/blueprint/class, Child, Boy, Men, Women can be its Objects. Their behavior could be walk, eat etc.
- We can access properties and behavior of a class using objects.
- If you have two constructors (one parameterized and one default), you can call the default constructor in your parameterized constructor using `this()`.

### Constructor Chaining Example:

```java
static int count;

public Person() {
    count++;
    System.out.println("creating an object");
}

public Person(int newAge, String newName) {
    this(); // example of constructor chaining
    this.name = newName;
    this.age = newAge;
}
```

- During inheritance, `super` keyword is used to call parent class constructor.

---

## 🔄 Types of Polymorphism in Java

**Real-life Illustration:** A person at the same time can have different characteristics. Like a man at the same time is a father, a husband, and an employee. So the same person possesses different behaviors in different situations. This is called polymorphism.

### 1. Compile-time/Static Polymorphism (Method Overloading)

**Definition:** If a class has multiple methods having the same name but different parameters, it is known as Method Overloading.

**Reference:** `MethodOverloadingDemo`

#### Overloading Scenarios:
- Scenario 1: Overloading with different parameter types.
- Scenario 2: Overloading with a different number of parameters.
- Scenario 3: Overloading with a different order of parameters.
- Scenario 4: Overloading with different return types (compilation error).
- Scenario 5: Overloading static methods.
- Overloading of final & private methods are allowed

#### Key Rules:
- Overloaded methods must have the same name.
- Overloaded methods must have different parameter lists (number, order, or types of parameters).
- An attempt to overload the main method shows that only the standard `main(String[] args)` method is recognized as the entry point for the program.
- Multiple main methods can be declared and overloaded, but only the standard `main(String[] args)` is recognized as the entry point.
- JVM checks for only the main method which has signature `main(String[] args)` - only that method can be considered as entry point of the program, not the overloaded methods.
- We can overload static methods, but we need to use the class name to call static methods.
- Overriding of final & private methods are allowed

---

### 2. Runtime Polymorphism/Dynamic Method Dispatch (Method Overriding)

**Definition:** It is a process in which a function call to the overridden method is resolved at Runtime. This type of polymorphism is achieved by Method Overriding.

If a method name in the base class is the same as in its child classes but with the same arguments types, order of arguments & number of arguments, then it is called method overriding.

#### Rules for Overriding a Method in Java:
- There must be inheritance between classes.
- The method between the classes must be the same (name of the class, number, and type of arguments must be the same).
- Static methods can't be overridden.

**Reference:** `MethodOverridingDemo.java` & `StaticMethodOverrideDemo.java`

---

## 🔐 Access Modifiers in Java

- **Private:** Accessible only within the class.
- **Public:** Accessible from anywhere in the Java program.
- **Protected:** Classes in same package + subclasses in other packages.
- **Default (Package-private):** Accessible only within the same package.

---

## 3️⃣ Abstract Class vs Interface

### ✅ When to Use an Abstract Class vs. an Interface in Java

#### 📌 Abstract Class

**Use an abstract class when:**

- You want to provide a common base with some shared implementation.
- Classes share state (fields/variables) and behavior.
- You want to evolve the class hierarchy without breaking existing code (because you can add new methods with default implementations).
- You expect that classes are closely related or logically belong to the same family.

#### 📌 Interface

**Use an interface when:**

- You want to define a contract (what needs to be done) without enforcing how.
- You need to support multiple inheritance (a class can implement many interfaces).
- You expect that classes implementing the interface may come from unrelated hierarchies.
- You are building for loose coupling and flexibility (e.g., plugins, strategies, services).

---

### ✅ Real-World Examples

#### 🔶 Abstract Class Example: BaseEntity in a Spring Boot App

```java
public abstract class BaseEntity {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void updateTimestamps() {
        updatedAt = LocalDateTime.now();
    }

    // Shared logic across entities
}
```

Used when multiple entities (e.g. User, Order, Product) share state and behavior.

#### 🔷 Interface Example: NotificationService

```java
public interface NotificationService {
    void send(String message);
}

public class EmailNotification implements NotificationService {
    public void send(String message) {
        // send email
    }
}

public class SmsNotification implements NotificationService {
    public void send(String message) {
        // send SMS
    }
}
```

Used when multiple unrelated classes need to fulfill the same contract (send()), possibly via dependency injection (Spring).

---

### ✅ Summary Table: Abstract Class vs Interface

| Feature                      | Abstract Class                          | Interface                                    |
|------------------------------|----------------------------------------|----------------------------------------------|
| Can have method bodies       | ✅ Yes (with/without abstract methods)  | ✅ Yes (default/static methods since Java 8) |
| Can have instance variables  | ✅ Yes                                  | ❌ No (only constants)                       |
| Multiple inheritance support | ❌ No (only one abstract class allowed) | ✅ Yes (can implement multiple interfaces)   |
| Constructor                  | ✅ Yes                                  | ❌ No                                        |
| Suitable for                 | Shared code, base classes               | Contracts, loose coupling                     |
| Spring Use Case              | BaseEntity, AbstractController          | @Service, @Repository, RestController         |

---

### 🧠 Interview-Ready Answer

> "I use an abstract class when I need to provide a common base with some shared code or fields — for example, a BaseEntity in a Spring Boot app that all entities extend. I use an interface when I want to define a contract that can be implemented by different and unrelated classes — for example, a NotificationService implemented by Email, SMS, or Push. Interfaces are also ideal in Spring for dependency injection and loose coupling."

---

## Why Make BaseEntity Abstract?

### ✳️ 1. Intentional Design

Declaring BaseEntity as abstract communicates intent clearly:

- "This class is not meant to be instantiated on its own."
- It's a base template, not a concrete domain entity.

```java
public abstract class BaseEntity {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Shared logic...
}
```

Even if technically it could be a concrete class, abstract makes the purpose explicit.

### ✳️ 2. Prevents Accidental Instantiation

If it's not abstract, someone could do:

```java
BaseEntity entity = new BaseEntity(); // This doesn't make sense logically!
```

But BaseEntity is usually meant to be extended by entities like User, Product, etc. Making it abstract avoids incorrect usage.

### ✳️ 3. Forcing Subclass Responsibility

You can define abstract methods in BaseEntity if needed:

```java
public abstract String getEntityType();
```

This ensures that all subclasses must implement specific behavior — helping enforce design consistency across the domain model.

### ✳️ 4. Improved Readability and Maintenance

Developers reading the code immediately understand:

- This is a base class
- It's not meant to be persisted or used directly
- It's used to enforce common behavior across entities

This improves codebase maintainability and avoids misuse.

---

### 🔁 What If We Don't Make It Abstract?

Yes, technically it works:

```java
public class BaseEntity {
    private Long id;
    private LocalDateTime createdAt;
}
```

But then:

- It looks like a normal instantiable class
- Someone might treat it as a full-fledged model (e.g., try to persist BaseEntity)
- It doesn't communicate its design intent clearly

---

### ✅ Summary Table: Abstract vs Concrete BaseEntity

| Point                           | abstract BaseEntity        | concrete BaseEntity                          |
|--------------------------------|----------------------------|----------------------------------------------|
| Instantiation                   | ❌ Not allowed             | ✅ Allowed (but often meaningless)           |
| Communicates base-only intent   | ✅ Yes, clearly            | ❌ No, ambiguous                             |
| Allows abstract methods         | ✅ Yes                     | ❌ No                                        |
| Prevents accidental persistence | ✅ Helps prevent it        | ❌ Could happen                              |
| Best for                        | Template/shared structure  | Utility class or shared model (rarely used) |

---

### 🧠 Interview Answer

> "Making BaseEntity abstract helps prevent accidental instantiation and clarifies its role as a base class. It improves readability and makes the design intent explicit. While technically it can be non-abstract, marking it abstract makes it clear that it's just a template for concrete entities like User, Order, or Product."

---

## 📌 Composition vs Aggregation

| Feature           | Composition                                    | Aggregation                                    |
|-------------------|------------------------------------------------|------------------------------------------------|
| Definition        | Strong "has-a" relationship (tight coupling)  | Weak "has-a" relationship (loose coupling)    |
| Ownership         | Parent owns child object                      | Parent uses child object                      |
| Example           | `House has-a Room` (room dies with house)    | `Team has-a Player` (player can join another team) |
| Java Implementation | Direct instantiation inside the class         | Passed via constructor or setter (reference only) |

---
