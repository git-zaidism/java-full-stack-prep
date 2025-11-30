package org.zaidism.oops;

class Engine1 {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car1 {
    private final Engine1 engine; // Aggregation: Engine passed in

    public Car1(Engine1 engine) {
        this.engine = engine; // Engine is not owned, just used
    }

    public void startCar() {
        engine.start();
        System.out.println("Car started.");
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Engine1 sharedEngine = new Engine1(); // Created externally
        Car1 car1 = new Car1(sharedEngine);
        Car1 car2 = new Car1(sharedEngine); // Same engine reused (possible in aggregation)

        car1.startCar();
        car2.startCar();
    }
}
