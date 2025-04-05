package Chap2;

public class MainMypoint {
    public static void main(String[] args) {
        Mypoint m1=new Mypoint();
        Mypoint m2=new Mypoint(1,2);
        m1.setX(2);
        m1.setY(4);
        System.out.println(m1.distance(m2));
        System.out.println(m1.distance(1,5));
        System.out.println(m1.distance());
    }
}
