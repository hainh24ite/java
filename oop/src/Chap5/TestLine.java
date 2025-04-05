package Chap5;

public class TestLine {
    public static void main(String[] args) {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(4, 6);
        Line line = new Line(point1, point2);
        System.out.println("Begin Point: (" + line.getBeginX() + ", " + line.getBeginY() + ")");
        System.out.println("End Point: (" + line.getEndX() + ", " + line.getEndY() + ")");
        System.out.println("Length of the line: " + line.getLength());
        System.out.println("Gradient of the line: " + line.getGradient());
        line.setBeginXY(2, 3);
        line.setEndXY(5, 7);
        System.out.println("\nAfter changing points:");
        System.out.println("Begin Point: " + line.getBegin());
        System.out.println("End Point: " + line.getEnd());
        System.out.println("Length of the line: " + line.getLength());
        System.out.println("Gradient of the line: " + line.getGradient());
    }

}
