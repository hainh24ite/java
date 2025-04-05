package Chap1;

public class Circle {

    private double radius=1;

    private String color="red";

    public Circle(){

    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }


}
