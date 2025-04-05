package Chap2;

public class Mycircle {
    private int radius;
    private Mypoint center;
    public Mycircle(){
        this.radius=1;
        this.center=new Mypoint(0,0);
    }
    public Mycircle(int x,int y,int radius){
        this.center=new Mypoint(x,y);
        this.radius=radius;
    }
    public Mycircle(Mypoint center, int radius ){
        this.center=center;
        this.radius=radius;
    }

    public Mypoint getCenter() {
        return center;
    }

    public void setCenter(Mypoint center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getCenterX(){
        return center.getX();
    }
    public void setCenterX(int x){
        center.setX(x);
    }
    public int getCenterY(){
        return center.getY();
    }
    public void setCenterY(int y){
        center.setY(y);
    }
    public int[] getCenterXY(){
        return new int []{center.getX(),center.getY()};
    }
    public void setCenterXY(int x,int y){
        center.setX(x);
        center.setY(y);
    }
@Override
    public String toString(){
        return "Mycircle[radius="+radius+",center="+center.toString()+"]";
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getCircumference(){
        return 2*Math.PI*radius;
    }
    public double distance(Mycircle another){
        return center.distance(another.getCenter());
    }
}
