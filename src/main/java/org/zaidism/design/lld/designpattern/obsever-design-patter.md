# 📘 Observer Design Pattern – Theory

## 🔹 Definition

> Observer is a behavioral design pattern that defines a one-to-many relationship between objects so that when one object changes state, all its dependent objects are automatically notified and updated.

---

# 🧠 Core Idea

There are two main roles:

### 1️⃣ Subject (Observable)

* Holds state
* Maintains list of observers
* Notifies observers when state changes

### 2️⃣ Observer

* Registers with subject
* Receives updates when state changes

---

# 🚚 FedEx Shipping Domain Example

Imagine:

When shipment status changes:

* Tracking system must update
* Notification system must notify customer
* Billing system may log event

Shipment should NOT directly call:

```java
tracking.getUpdate();
notification.send();
billing.log();
```

That would tightly couple everything.

Instead:
Shipment just notifies observers.
Observers decide what to do.

That’s loose coupling.

---

# 📐 Pattern Structure

```
Shipment (Subject)
   ↓ notifies
TrackingSystem (Observer)
NotificationSystem (Observer)
```

---

# 🧩 Complete Working Code

## 1️⃣ ShipmentObserver

```java
package observer;

public interface ShipmentObserver {
    void getUpdate(String status);
}
```

---

## 2️⃣ ShipmentObservable

```java
package observer;

public interface ShipmentObservable {
    void addObserver(ShipmentObserver observer);
    void removeObserver(ShipmentObserver observer);
    void notifyObservers();
}
```

---

## 3️⃣ Shipment (Concrete Subject)

```java
package observer;

import java.util.ArrayList;
import java.util.List;

public class Shipment implements ShipmentObservable {

    private List<ShipmentObserver> observers = new ArrayList<>();
    private String status;

    @Override
    public void addObserver(ShipmentObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ShipmentObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ShipmentObserver observer : observers) {
            observer.getUpdate(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }
}
```

---

## 4️⃣ TrackingSystem (Concrete Observer)

```java
package observer;

public class TrackingSystem implements ShipmentObserver {

    @Override
    public void getUpdate(String status) {
        System.out.println("Tracking updated: " + status);
    }
}
```

---

## 5️⃣ NotificationSystem (Concrete Observer)

```java
package observer;

public class NotificationSystem implements ShipmentObserver {

    @Override
    public void getUpdate(String status) {
        System.out.println("Customer notified: " + status);
    }
}
```

---

## 6️⃣ Main

```java
package observer;

public class Main {

    public static void main(String[] args) {

        Shipment shipment = new Shipment();

        TrackingSystem tracking = new TrackingSystem();
        NotificationSystem notification = new NotificationSystem();

        shipment.addObserver(tracking);
        shipment.addObserver(notification);

        shipment.setStatus("Out for Delivery");

        shipment.removeObserver(notification);

        shipment.setStatus("Delivered");
    }
}
```

---

# ✅ Output

```
Tracking updated: Out for Delivery
Customer notified: Out for Delivery

Tracking updated: Delivered
```
---
