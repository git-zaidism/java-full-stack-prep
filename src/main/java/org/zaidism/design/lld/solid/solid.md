# The SOLID Principles

The broad goal of the SOLID principles is to reduce dependencies so that engineers can change one area of software without impacting others. Additionally, they're intended to make designs easier to understand, maintain, and extend. Ultimately, using these design principles makes it easier for software engineers to avoid issues and to build adaptive, effective, and agile software. They lead to better code for readability, maintainability, design patterns, and testability.

---

## 🔑 What is SOLID?

A set of 5 design principles to write:

* maintainable code
* scalable systems
* loosely coupled architecture

---

# 🅢 Single Responsibility Principle (SRP)

### 💡 Definition

> A class should have only **one reason to change**

---

### ❌ Violation

```java
class OrderManager {
    void processOrder() {}
    void saveToDB() {}
    void sendEmail() {}
}
```

👉 Too many responsibilities

---

### ✅ Correct

```java
class OrderProcessor {
    void processOrder() {}
}

class OrderRepository {
    void save() {}
}

class EmailService {
    void sendEmail() {}
}
```

---

### 🎯 Key Idea

> One class = one job

---

# 🅞 Open/Closed Principle (OCP)

### 💡 Definition

> Open for extension, closed for modification

---

### ❌ Violation

```java
class DiscountCalculator {
    double calculate(String type, double amount) {
        if (type.equals("CARD")) return amount * 0.10;
        if (type.equals("UPI")) return amount * 0.05;
        return 0;
    }
}
```

---

### ✅ Correct (Strategy Pattern)

```java
interface DiscountStrategy {
    double calculate(double amount);
}

class CardDiscount implements DiscountStrategy {
    public double calculate(double amount) {
        return amount * 0.10;
    }
}

class UPIDiscount implements DiscountStrategy {
    public double calculate(double amount) {
        return amount * 0.05;
    }
}
```

---

### 🎯 Key Idea

> Avoid if-else → use polymorphism

---

# 🅛 Liskov Substitution Principle (LSP)

### 💡 Definition

> Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.



---

### ❌ Violation (Your Notification Example)

```java
abstract class Notification {
    abstract void send(String msg, String email);
}

class WhatsAppNotification extends Notification {
    void send(String msg, String email) {
        throw new UnsupportedOperationException();
    }
}
```

👉 WhatsApp doesn’t support email → breaks contract ❌

---

### ✅ Correct

```java
abstract class Notification {
    abstract void send(String msg);
}

class EmailNotification extends Notification {
    public void send(String msg) {
        System.out.println("Email: " + msg);
    }
}

class WhatsAppNotification extends Notification {
    private String phone;

    WhatsAppNotification(String phone) {
        this.phone = phone;
    }

    public void send(String msg) {
        System.out.println("WhatsApp: " + msg + " to " + phone);
    }
}
```

---

### 🎯 Key Idea

> If subclass throws “not supported” → LSP violation

---

# 🅘 Interface Segregation Principle (ISP)

### 💡 Definition

> Clients should not be forced to depend on interfaces they do not use.

---

### ❌ Violation

```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        System.out.println("Robot working");
    }

    public void eat() {
        throw new UnsupportedOperationException();
    }
}
```

👉 Robot doesn’t eat → forced implementation ❌

---

### ✅ Correct

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }
}

class Robot implements Workable {
    public void work() {
        System.out.println("Robot working");
    }
}
```

---

### 🎯 Key Idea

> Split interfaces → avoid unnecessary methods

---

# 🅓 Dependency Inversion Principle (DIP)

### 💡 Definition

> Depend on abstractions, not concrete classes (High-level modules should not depend on low-level modules. Both should depend on abstractions)

---

### ❌ Violation

```java
class EmailService {
    void send(String msg) {}
}

class OrderService {
    private EmailService email = new EmailService();

    void placeOrder() {
        email.send("Order placed");
    }
}
```

👉 Tight coupling ❌

---

### ✅ Correct

```java
interface NotificationService {
    void send(String msg);
}

class EmailService implements NotificationService {
    public void send(String msg) {}
}

class OrderService {
    private final NotificationService notification;

    OrderService(NotificationService notification) {
        this.notification = notification;
    }

    void placeOrder() {
        notification.send("Order placed");
    }
}
```

---

### 🎯 Key Idea

> Inject dependency, don’t create it

---

# 🧠 Quick Revision (1 min)

* **S** → One class = one responsibility
* **O** → Extend, don’t modify
* **L** → Subclass must behave correctly
* **I** → Small, specific interfaces
* **D** → Depend on interfaces

---

# 💬 Golden Interview Line

> “SOLID principles help build loosely coupled, scalable, and maintainable systems by enforcing separation of concerns and abstraction-driven design.”

---
