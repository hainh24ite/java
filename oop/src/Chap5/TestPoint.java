package Chap5;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(5, 7);
        System.out.println("Point 1: " + p1);
        System.out.println("Point 2: " + p2);
        p1.setX(10);
        p1.setY(15);
        p2.setXY(20, 25);
        System.out.println("After changing Point 1: " + p1);
        System.out.println("After changing Point 2: " + p2);
        System.out.println("Point 1 X: " + p1.getX());
        System.out.println("Point 1 Y: " + p1.getY());
    }
}
