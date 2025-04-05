package Chap1;

public class Ball {
    private float x,y,xDelta,yDelta;
    private int radius;
    public Ball(float x, float y, int radius, float xDelta, float yDelta) {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.xDelta=xDelta;
        this.yDelta=yDelta;
    }
     float getX(){
        return x;
    }
    float getY(){
        return y;
    }
    float getXDelta(){
        return xDelta;
    }
    float getYDelta(){
        return yDelta;
    }
    int getRadius(){
        return radius;
    }
    void setX(float x){
        this.x=x;
    }
    void setY(float y){
        this.y=y;
    }
    void setXDelta(float xDelta){
        this.xDelta=xDelta;
    }
    void setYDelta(float yDelta){
        this.yDelta=yDelta;
    }
    void setRadius(int radius){
        this.radius=radius;
    }
    void move(){
        x+=xDelta;
        y+=yDelta;
    }
    void reflectHorizontal(){
        xDelta=-xDelta;
    }
    void reflectVertical(){
        yDelta=-yDelta;
    }
    public String toString(){
        return "Ball[("+x+","+y+"),speed=("+xDelta+","+yDelta+")]";
    }
}
