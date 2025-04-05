package Chap6;

public class Rectangle2 implements GeometricObject {

    private double width;

    private double length;

    public Rectangle2(double width, double length){
        this.width=width;
        this.length=length;
    }

    @Override
    public String toString(){
        return "Rectangle["+width+","+length+"]";
    }

    @Override
    public double getArea(){
        return width*length;
    }

    @Override
    public double getPerimeter(){
        return 2*width+2*length;
    }

}
