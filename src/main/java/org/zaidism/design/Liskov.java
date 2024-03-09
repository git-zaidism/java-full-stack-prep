package org.zaidism.design;

abstract class Shape {

    Shape() {
        System.out.println("hey");
    }

    public abstract int calculateArea();
}

class Rectangle extends Shape {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }
}

class Square extends Shape {
    protected int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int calculateArea() {
        return side * side;
    }
}

public class Liskov {
    public static void main(String[] args) {
        // Using Rectangle
        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());

        // Using Square
        Shape square = new Square(5);
        System.out.println("Area of Square: " + square.calculateArea());
    }
}
