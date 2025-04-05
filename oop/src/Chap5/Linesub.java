package Chap5;

public class Linesub extends Point {
    private Point end;
    public Linesub(int beginX, int beginY, int endX, int endY) {
        super(beginX,beginY);
        this.end=new Point(endX,endY);
    }

    public Linesub( Point begin, Point end){
        super(begin.getX(),begin.getY());
        this.end=end;
    }

    public String toString(){
        return "linesub[begin="+super.toString()+",end="+end.toString()+"]";
    }

    public Point getBegin(){
        return new Point(getX(),getY());
    }

    public Point getEnd(){
        return end;
    }

    public void setBegin(Point begin){ //ta kế thừa method từ lớp Point nên dùng setX() không cần thông qua đối tượng,tham số bên trong cần phải có nó sẽ tham chiếu  đến đối tượng của lớp Point và lấy method getX()
        setX(begin.getX());
        setY(begin.getY());
    }

    public void setEnd(Point end){
        this.end=end;
    }

    public int getBeginX(){
        return getX();
    }
}

