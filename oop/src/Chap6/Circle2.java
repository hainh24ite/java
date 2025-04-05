package Chap6;

public class Circle2 implements GeometricObject{

    private double radius;

    public Circle2(double radius){
        this.radius=radius;
    }

    @Override
    public String toString(){
        return "Circle[radius=" + radius + "]";
    }

    public double getArea(){
        return 2*Math.PI*radius*radius;
    }

    public double getPerimeter(){
        return 2*Math.PI*radius;
    }


}
