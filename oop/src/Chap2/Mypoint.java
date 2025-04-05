package Chap2;

public class Mypoint {

    private int x;

    private int y;

    public Mypoint(){
        this.x=0;
        this.y=0;
    }
    public Mypoint(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public int [] getXY(){
        return new int [] {x,y};
    }
    public void setXY(int x,int y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public double distance(int x,int y){
        return Math.sqrt(Math.pow(x-this.x,2)+Math.pow(y-this.y,2));
    }
    public double distance(Mypoint another){
        return Math.sqrt(Math.pow(this.x-another.getX(),2)+Math.pow(this.y-another.getY(),2));
    }
    public double distance(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
}