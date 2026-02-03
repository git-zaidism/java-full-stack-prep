# Object-Oriented Programming (OOP) in Java

**Clear theory + examples that interviewers actually accept**

---

## 1. Encapsulation

### What interviewers actually mean

Encapsulation is **not** “private variables with getters/setters”.

Encapsulation means:

> An object **owns its data** and **controls all state changes** so the object is always valid.

If state can be changed freely from outside, encapsulation is broken.

---

### Bad (common but wrong mindset)

```java
public class Order {
    public int quantity;   // ❌ anyone can change it
    public double price;
}
```

This is **not encapsulation**.

---

### Good encapsulation example

```java
public class Order {

    private int quantity;
    private double pricePerItem;

    public Order(int quantity, double pricePerItem) {
        if (quantity <= 0 || pricePerItem <= 0) {
            throw new IllegalArgumentException("Invalid order");
        }
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double getTotalPrice() {
        return quantity * pricePerItem;
    }

    public void addItems(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be positive");
        }
        quantity += count;
    }
}
```

### Why this is strong

* No external class can corrupt `quantity`
* All rules are enforced in **one place**
* Object is always valid

**One-line interview answer:**
Encapsulation protects object invariants by restricting direct access to state.

---

## 2. Inheritance

### What it really is

Inheritance models a **true is-a relationship**, not “code reuse”.

> If the sentence “X is a Y” sounds forced, inheritance is wrong.

---

### Correct example

```java
public abstract class Employee {

    protected double baseSalary;

    public Employee(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
}
```

```java
public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(double baseSalary) {
        super(baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
```

```java
public class ContractEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public ContractEmployee(int hoursWorked, double hourlyRate) {
        super(0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
```

### Why interviewers like this

* Clear hierarchy
* Shared abstraction
* Proper overriding

**One-line interview answer:**
Inheritance represents an is-a relationship and enables polymorphic behavior.

---

## 3. Abstraction

### The correct mental model

Abstraction is about **what operations are available**, not how they are implemented.

It answers:

> “What can this object do?”
> not
> “How does it do it?”

---

### Clean abstraction example

```java
public interface ReportGenerator {
    String generate();
}
```

```java
public class PdfReportGenerator implements ReportGenerator {
    @Override
    public String generate() {
        return "PDF report generated";
    }
}
```

```java
public class ExcelReportGenerator implements ReportGenerator {
    @Override
    public String generate() {
        return "Excel report generated";
    }
}
```

```java
public class ReportService {

    private final ReportGenerator generator;

    public ReportService(ReportGenerator generator) {
        this.generator = generator;
    }

    public void createReport() {
        System.out.println(generator.generate());
    }
}
```

### Key abstraction point

`ReportService`:

* Does not know
* Does not care
* Should not care

about report format.

**One-line interview answer:**
Abstraction exposes behavior while hiding implementation details.

---

## 4. Polymorphism

### What it is (very precisely)

Polymorphism means:

> The same method call results in different behavior based on the runtime object.

Not overloading.
Not if-else.
**Runtime dispatch.**

---

### Strong, minimal example

```java
public interface Discount {
    double apply(double amount);
}
```

```java
public class FestivalDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.8;
    }
}
```

```java
public class LoyaltyDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.9;
    }
}
```

```java
public class BillingService {

    public double finalAmount(double amount, Discount discount) {
        return discount.apply(amount); // polymorphism
    }
}
```

```java
BillingService billing = new BillingService();
billing.finalAmount(1000, new FestivalDiscount());
billing.finalAmount(1000, new LoyaltyDiscount());
```

Same call
Different behavior
Chosen at runtime

That’s polymorphism.

**One-line interview answer:**
Polymorphism allows the same interface to have different runtime behavior.

---

## One Table You Can Memorize

| Concept       | Core Idea        | Interview Keyword |
| ------------- | ---------------- | ----------------- |
| Encapsulation | Control state    | Invariants        |
| Inheritance   | Hierarchy        | Is-a              |
| Abstraction   | Hide details     | What vs How       |
| Polymorphism  | Dynamic behavior | Runtime dispatch  |

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
