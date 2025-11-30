package org.zaidism.corejava.staticcode;

//A static nested class doesn’t require an instance of the outer class.
public class StaticNestedClass { // ❌ Compilation error: modifier 'static' not allowed here


    static void display() {
        System.out.println("Inside display");
    }

    void displayv2() {
        System.out.println("Inside displayv2");
    }

    static class StaticNested {
        void display() {
            System.out.println("Inside static nested class");
        }
    }

    public static void main(String[] args) {
        StaticNestedClass.StaticNested obj = new StaticNestedClass.StaticNested();
        obj.display();

        StaticNestedClass staticNestedClass = new StaticNestedClass();
        staticNestedClass.displayv2();
        StaticNestedClass.display();
    }
}
