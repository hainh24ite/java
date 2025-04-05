package Chap6;

public class Square extends Rectangle {
    public Square() {

    }

    public Square(double side){
        super(side,side);
    }

    public Square(double side,String color,boolean filled){
        super(side,side,color,filled);
    }

    public double getSide(){
        return width;
    }

    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }

    public void setWidth(double side){
        width = side;
        setLength(side);
    }

    public void setLength(double side){
        length=side;
        setWidth(side);
    }

    @Override
    public String toString(){
        return "Square["+super.toString()+ "]";
    }
}
