package Chap2;

public class MyLine {
    private Mypoint begin;
    private Mypoint end;
    public MyLine(int x1,int y1,int x2,int y2){
        this.begin=new Mypoint(x1,y1);
        this.end = new Mypoint(x2,y2);
    }
    public MyLine(Mypoint begin,Mypoint end){
        this.begin=begin;
        this.end=end;
    }
    public Mypoint getBegin(){
        return begin;
    }
    public void setBegin(Mypoint begin){
        this.begin=begin;
    }
    public Mypoint getEnd(){
        return end;
    }
    public void setEnd(Mypoint end){
        this.end=end;
    }
    public int getBeginX(){
        return begin.getX();
    }
    public void setBeginX(int x){
        this.begin.setX(x);
    }
    public int getBeginY(){
        return begin.getY();
    }
    public void setBeginY(int y){
        this.begin.setY(y);
    }
    public int getEndX(){
        return end.getX();
    }
    public void setEndX(int x){
        this.end.setX(x);
    }
    public int getEndY(){
        return end.getY();
    }
    public void setEndY(int y){
        this.end.setY(y);
    }
    public int[] getBeginXY(){
        return new int[]{begin.getX(),begin.getY()};
    }

    public void setBeginXY(int x,int y){
        this.begin.setX(x);
        this.begin.setY(y);
    }
    public int[] getEndXY(){
        return new int[]{end.getX(),end.getY()};
    }
    public void setEndXY(int x,int y){
        this.end.setX(x);
        this.end.setY(y);
    }
    public double getLength(){
        return begin.distance(end);
    }
    public double getGradient(){
        return Math.atan2(end.getY()-begin.getY(),end.getX()-begin.getY());
    }
    public String toString(){
        return "Myline[begin=("+begin.getX()+","+begin.getY()+"), end=("+end.getX()+","+end.getY()+")]";
    }
}
