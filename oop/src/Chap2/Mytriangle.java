package Chap2;

public class Mytriangle {
    private Mypoint v1,v2,v3;
    public Mytriangle(int x1,int y1,int x2,int y2,int x3,int y3){
        v1=new Mypoint(x1,x2);
        v2=new Mypoint(x2,y2);
        v3=new Mypoint(x3,y3);
    }
    public Mytriangle(Mypoint v1,Mypoint v2,Mypoint v3){
        this.v1=v1;
        this.v2=v2;
        this.v3=v3;
    }
    @Override
    public String toString(){
        return "Mytriangle[v1="+v1.toString()+",v2="+v2.toString()+",v3="+v3.toString()+"]";
    }
    public double getPerimeter(double s1,double s2,double s3,double p){
         s1=v1.distance(v2);
         s2=v2.distance(v3);
         s3=v1.distance(v3);
         p=(s1+s2+s3)/2;
        return Math.sqrt(p*(p-s1)*(p-s2)*(p-s3));
    }
    public String getType(){
        return "Equilateral";
    }
}
