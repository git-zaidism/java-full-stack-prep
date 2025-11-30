package org.zaidism.corejava;

class Horse {
    String name;

    Horse(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name  = name;
    }

    public String getName() {
        return name;
    }
}

public class PassByValueDemo {

    public static void main(String[] args) {
        int number = 5;

        System.out.println("Before changePrimitive: number = " + number);
        changePrimitive(number);
        System.out.println("After changePrimitive: number = " + number);
        System.out.println("--------------------------");

        Horse horse = new Horse("Buddy");
        System.out.println("Before changeObjectName: horse.name = " + horse.getName());
        changeObjectName(horse);
        System.out.println("After changeObjectName: horse.name = " + horse.getName());

        System.out.println("--------------------------");

        System.out.println("Before reassignObject: horse.name = " + horse.getName());
        reassignObject(horse);
        System.out.println("After reassignObject: horse.name = " + horse.getName());
    }

    static void changePrimitive(int num) {
        num = 10; // Does not affect original 'number'
    }

    static void changeObjectName(Horse horse) {
        horse.setName("Charlie"); // Modifies the original object's field
    }

    static void reassignObject(Horse d) {
        d = new Horse("Rocky"); // Only changes local reference, does NOT affect original
        System.out.println(d.name);
    }
}
