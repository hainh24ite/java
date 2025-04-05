package Chap6;

public class ResizableCircle extends Circle5 implements Resizable {

    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public String toString() {
        return " Resizable[Circle [radius=" + radius + "]]";
    }

    @Override
    public void resize(int percent){
        this.radius*=percent/100;
    }
}
