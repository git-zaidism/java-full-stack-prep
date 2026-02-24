# 🚚 What Is Factory Pattern (In Simple Terms)

> The Factory Design Pattern is a creational pattern that defines an interface for object creation while delegating instantiation to a factory method or class, 
thereby decoupling client code from concrete implementations.

Factory pattern means:

> Don’t create objects directly using `new`.
> Let a factory decide which object to create.

So instead of:

```java
Shipment shipment = new AirShipment();
```

You do:

```java
Shipment shipment = ShipmentFactory.createShipment("AIR");
```

Now the caller doesn’t care which concrete class is created.

That’s the power.

---

# 📦 Shipping Domain Example (FedEx Style)

Let’s say we support:

* Air Shipment
* Ground Shipment
* Freight Shipment

Each shipment calculates cost differently.

---

# 1️⃣ Step 1: Create a Common Interface

```java
public interface Shipment {
    void createLabel();
    double calculateCost(double weight);
}
```

All shipment types must follow this contract.

---

# 2️⃣ Step 2: Concrete Implementations

### ✈ Air Shipment

```java
public class AirShipment implements Shipment {

    @Override
    public void createLabel() {
        System.out.println("Creating Air Shipment Label");
    }

    @Override
    public double calculateCost(double weight) {
        return weight * 15.0;  // higher rate
    }
}
```

---

### 🚛 Ground Shipment

```java
public class GroundShipment implements Shipment {

    @Override
    public void createLabel() {
        System.out.println("Creating Ground Shipment Label");
    }

    @Override
    public double calculateCost(double weight) {
        return weight * 8.0;
    }
}
```

---

### 🚢 Freight Shipment

```java
public class FreightShipment implements Shipment {

    @Override
    public void createLabel() {
        System.out.println("Creating Freight Shipment Label");
    }

    @Override
    public double calculateCost(double weight) {
        return weight * 25.0;
    }
}
```

---

# 3️⃣ Step 3: Create the Factory

Here’s the important part.

```java
public class ShipmentFactory {

    public static Shipment createShipment(String type) {

        switch (type.toUpperCase()) {
            case "AIR":
                return new AirShipment();

            case "GROUND":
                return new GroundShipment();

            case "FREIGHT":
                return new FreightShipment();

            default:
                throw new IllegalArgumentException("Invalid shipment type");
        }
    }
}
```

---

# 4️⃣ Step 4: Client Code (FedEx App Example)

Imagine your service layer:

```java
public class ShippingService {

    public void processShipment(String type, double weight) {

        Shipment shipment = ShipmentFactory.createShipment(type);

        shipment.createLabel();
        double cost = shipment.calculateCost(weight);

        System.out.println("Shipping Cost: $" + cost);
    }
}
```

Usage:

```java
public class Main {
    public static void main(String[] args) {

        ShippingService service = new ShippingService();
        service.processShipment("AIR", 10);
    }
}
```

---

# 🎯 Why This Is Useful in Shipping Systems

In real FedEx-like systems:

* Different service types
* Different pricing engines
* Different label formats
* Different tracking rules

Instead of:

```java
if (type.equals("AIR")) { ... }
else if (type.equals("GROUND")) { ... }
```

You centralize creation logic inside the factory.

Now if tomorrow you add:

* SameDayShipment
* InternationalShipment
* DroneDeliveryShipment 😄

You just update the factory.

Client code does not change.

---

# 💡 Real Production Upgrade (Better Version)

In real enterprise apps, you avoid `switch`.

You use:

* Spring `@Component`
* Or Map-based registry
* Or Factory Method pattern (polymorphic factory)

Example cleaner approach:

```java
public class ShipmentFactory {

    private static final Map<String, Shipment> shipmentMap = Map.of(
        "AIR", new AirShipment(),
        "GROUND", new GroundShipment(),
        "FREIGHT", new FreightShipment()
    );

    public static Shipment createShipment(String type) {
        return shipmentMap.get(type.toUpperCase());
    }
}
```

Even better: inject via Spring.

---

# 🧠 Interview Answer (You Can Say This)

> Factory pattern provides a way to create objects without exposing instantiation logic to the client. In a shipping domain, based on shipment type like AIR or GROUND, a ShipmentFactory can return the appropriate implementation. This helps in loose coupling, scalability, and adherence to Open-Closed Principle.

---

# 🔥 When To Use Factory Pattern

Use it when:

* Object creation logic is complex
* You have multiple subclasses
* You want to follow Open/Closed principle
* You want to reduce `if-else` or `switch` chains
* You want better testability

---
