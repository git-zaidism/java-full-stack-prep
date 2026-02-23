# 1️⃣ Big Picture Difference

## Interface

* A **contract**
* Used for **pure abstraction**
* Contains **method signatures only** (traditionally no implementation)
* Focuses on **what should be done**
* A class **implements** an interface

## Abstract Class

* A **half-defined parent class**
* Can have:

  * Abstract methods (no body)
  * Concrete methods (with body)
  * Fields
* Focuses on **shared behavior**
* A class **extends** (inherits) an abstract class

---

# 2️⃣ Java Example – Abstract Class

### Scenario: Shop Customers

All customers:

* Have a name
* Can enquire
* But discount calculation differs

### Abstract Class

```java
abstract class Customer {
    String name;

    public void enquire() {
        System.out.println("Customer is enquiring");
    }

    public abstract double calculateDiscount();
}
```

Here:

* `enquire()` has logic
* `calculateDiscount()` is abstract

### Concrete Classes

```java
class PlatinumCustomer extends Customer {

    @Override
    public double calculateDiscount() {
        return 0.20; // 20% discount
    }
}

class WalkInCustomer extends Customer {

    @Override
    public double calculateDiscount() {
        return 0.10; // 10% discount
    }
}
```

✔ Shared logic in parent
✔ Different logic in child
✔ This is the correct use of abstract class

---

# 3️⃣ Java Example – Interface

Now suppose we define the contract first.

```java
interface ICustomer {
    String getName();
    void enquire();
    double calculateDiscount();
}
```

Here:

* No implementation
* Only method signatures
* All methods are implicitly public

### Implementation

```java
class PlatinumCustomer implements ICustomer {

    public String getName() {
        return "Platinum";
    }

    public void enquire() {
        System.out.println("Enquiring...");
    }

    public double calculateDiscount() {
        return 0.20;
    }
}
```

✔ Interface forces all methods to be implemented
✔ It enforces a contract

---

# 4️⃣ Planning vs Execution Concept (Important Interview Insight)

He explains this nicely:

* **Interface = Planning phase**

  * Identify what the object must expose
  * Focus on abstraction
  * Don’t think about logic yet

* **Abstract class = Execution phase**

  * Implement shared logic
  * Leave some parts for child classes

Ideal sequence in design:

1. Create Interface (define abstraction)
2. Create Abstract Class (add common logic)
3. Create Concrete Classes (full implementation)

---

# 5️⃣ Key Interview Line (Very Important)

Say this clearly:

> Interfaces are implemented.
> Abstract classes are inherited (extended).

Interviewers love that clarity.

---

# 6️⃣ The “Pure Abstract Class” Trap

If you make an abstract class like this:

```java
abstract class Customer {
    abstract String getName();
    abstract void enquire();
    abstract double calculateDiscount();
}
```

Now it looks exactly like an interface.

Technically similar, but:

❌ It’s bad design
❌ Abstract class is meant to share behavior
❌ You’re misusing it as an interface

---

# 7️⃣ Real Problem: Multiple Inheritance

This is the biggest technical difference.

### In Java:

* A class can extend only one class
* But can implement multiple interfaces

---

## Example Problem

You have:

* A Lead (just enquires, never buys)
* A Customer (enquires and buys)

If you design poorly with abstract classes, you might get stuck.

You cannot do:

```java
class WalkInCustomer extends EnquiryCustomer, BuyingCustomer // ❌ Not allowed
```

Java does not allow multiple class inheritance.

---

## But with Interfaces

```java
interface IEnquiry {
    void enquire();
}

interface ICustomer {
    double calculateDiscount();
}
```

Now:

```java
class WalkInCustomer implements IEnquiry, ICustomer {
    public void enquire() {
        System.out.println("Enquiring...");
    }

    public double calculateDiscount() {
        return 0.10;
    }
}
```

✔ Multiple inheritance allowed with interfaces
✔ Plug and play behavior
✔ More flexible design

---

# 8️⃣ When to Use What

## Use Interface When:

* You want a contract
* You need multiple inheritance
* You are designing abstraction
* You want loose coupling

## Use Abstract Class When:

* Classes share common code
* You want default behavior
* You want to avoid code duplication
* There is clear parent-child relationship

---

# 9️⃣ Final Interview Summary (You Can Literally Say This)

* An interface defines a contract and helps identify abstraction.
* Abstract class is a half-defined parent class used to share common logic.
* Interfaces are implemented.
* Abstract classes are extended.
* Interfaces support multiple inheritance.
* Abstract classes do not.
* Making an abstract class fully abstract makes it look like an interface, but it’s bad design.

---
