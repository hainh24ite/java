package Chap2;

public class MainMyline {
    public static void main(String[] args) {
        // Tạo đối tượng MyPoint cho điểm bắt đầu và điểm kết thúc
        Mypoint b1 = new Mypoint(1, 2);
        Mypoint e1 = new Mypoint(4, 6);

        // Tạo đối tượng MyLine bằng hai điểm MyPoint
        MyLine l1 = new MyLine(b1, e1);

        // In ra thông tin của l1
        System.out.println(l1.toString());
        System.out.println("Length of line1: " + l1.getLength());
        System.out.println("Gradient of line1: " + l1.getGradient());

        // Tạo đối tượng MyLine bằng tọa độ x, y
        MyLine l2 = new MyLine(1, 2, 4, 6);

        // In ra thông tin của line2
        System.out.println(l2.toString());
        System.out.println("Length of line2: " + l2.getLength());
        System.out.println("Gradient of line2: " + l2.getGradient());
    }
}
