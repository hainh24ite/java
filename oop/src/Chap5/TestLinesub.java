package Chap5;

public class TestLinesub {
    public static void main(String[] args) {
        Linesub line1 = new Linesub(1, 2, 3, 4);
        System.out.println("line1: " + line1);
        Point begin = new Point(5, 6);
        Point end = new Point(7, 8);
        Linesub line2 = new Linesub(begin, end);
        System.out.println("line2: " + line2);
        Point beginPoint = line2.getBegin();
        System.out.println("Begin point of line2:"+beginPoint);
    }
}