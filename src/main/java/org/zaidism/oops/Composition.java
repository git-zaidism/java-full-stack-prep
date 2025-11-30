package org.zaidism.oops;

class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    private final Engine engine; // Composition: Car has-an Engine

    public Car() {
        this.engine = new Engine(); // Engine is part of Car
    }

    public void startCar() {
        engine.start(); // Delegating behavior to composed object
        System.out.println("Car started.");
    }
}

public class Composition {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.startCar();
    }
}
