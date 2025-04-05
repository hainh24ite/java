package Chap7;
import java.util.*;

public class PolyLine {

    private List<Point> points;

    public PolyLine() {
        points=new ArrayList<>();
    }

    public PolyLine(List<Point> points) {
        this.points=points;
    }

    public void appendPoint(int x,int y){
        Point p=new Point(x,y);
        points.add(p);
    }

    public void appendPoint(Point point){
        points.add(point);
    }
//@Override
//    public String toString(){
//        StringBuilder str=new StringBuilder();
//        str.append("{");
//        for(int i=0;i<points.size();i++){
//            str.append(points.get(i).toString());
//            if(i!=points.size()-1){
//                str.append(",");
//            }
//        }
//        return str.append("}").toString();
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point aPoint : points) {
            sb.append(aPoint.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
