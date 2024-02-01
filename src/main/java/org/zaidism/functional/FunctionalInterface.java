package org.zaidism.functional;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    double calculateInterest(int amt, float roi);

    static void staticMethod() {
        System.out.println("Inside staticMethod");
    }

    default void defaultMethod() {
        System.out.println("Inside defaultMethod");
    }
}

class DefaultMethodTest implements FunctionalInterface {

    @Override
    public double calculateInterest(int amt, float roi) {
        return 0;
    }

    // Can override default methods if needed
    // @Override
    // public void defaultMethod() {
    //     System.out.println("Overridden defaultMethod");
    // }

    public static void main(String[] args) {
        // Default methods can't be called through the interface name.
        // FunctionalInterface.defaultMethod();

        // Default methods can be called this way.
        DefaultMethodTest defaultMethodTest = new DefaultMethodTest();
        defaultMethodTest.defaultMethod();

        // FunctionalInterface reference can also call default method.
        FunctionalInterface functionalInterface = new DefaultMethodTest();
        functionalInterface.defaultMethod();
    }
}

class StaticMethodTest {
    public static void main(String[] args) {
        // Static methods can only be called by the interface name.
        FunctionalInterface.staticMethod();
    }
}
