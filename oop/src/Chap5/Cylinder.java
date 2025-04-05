package Chap5;

public class Cylinder {

    private Circle base;

    private double height;

    public Cylinder() {
        base=new Circle();
        this.height=1;
    }
    public Cylinder(double radius){
        base=new Circle(radius);
        this.height=1;
    }
    public Cylinder(double radius,double height){
        base=new Circle(radius);
        this.height=height;
    }
    public Cylinder(double radius,double height,String color){
        base=new Circle(radius,color);
        this.height=height;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return base.getArea() * height;
    }



}
