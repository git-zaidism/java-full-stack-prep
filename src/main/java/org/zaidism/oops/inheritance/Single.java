package org.zaidism.oops.inheritance;

class Parent {
    public void display() {
        System.out.println("Single class method called");
    }
    public void displayParent() {
        System.out.println("Single class method called");
    }
}

class Child extends Parent {
    @Override // Method overriding
    public void display() {
        displayParent();
        System.out.println("Child class method called");
    }

}

class TestSingleInheritance {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
        child.displayParent();
    }
}
