package Chap1;

public class Rectangle {
    private float length=1f;
    private float width=1f;
    public Rectangle(){
    }
    public Rectangle(float length, float width){
        this.length=length;
        this.width=width;
    }
    public float getLength(){
        return length;
    }
    public void setLength(float length){
        this.length=length;
    }
    public float getWidth(){
        return width;
    }
    public void setWidth(float width){
        this.width=width;
    }
    public float getArea(){
        return length*width;
    }
    public float getPerimeter(){
        return  (length+width)*2;
    }
    @Override
    public String toString(){
        return "Rectangle[length="+length+"," +
                "width="+width+"]";
    }

}
