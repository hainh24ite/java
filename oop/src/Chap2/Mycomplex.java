package Chap2;

public class Mycomplex {
    private double real;
    private double imag;
    public Mycomplex(){
        real=0.0;
        imag=0.0;
    }
    public Mycomplex(double real, double imag){
        this.real=real;
        this.imag=imag;
    }
    public double getReal(){
        return real;
    }
    public void setReal(double real){
        this.real=real;
    }
    public double getImag(){
        return imag;
    }
    public void setImag(double imag){
        this.imag=imag;
    }
    public void setValue(double real,double imag){
        this.real=real;
        this.imag=imag;
    }
    @Override
    public String toString(){
        return "("+real+"+"+imag+"i)";
    }
    public boolean isReal(){
        return imag==0.0;
    }
    public boolean isImaginary(){
        return real==0.0;
    }
    public boolean equals(double real,double imag){
        return this.real==real&&this.imag==imag;
    }
    public boolean equals(Mycomplex another){
        return this.real==another.getReal()&&this.getImag()==another.imag;
    }
    public double magnitude(){
        return Math.sqrt(real*real+imag*imag);
    }
    public Mycomplex addInto(Mycomplex right){
        real=real+right.real;
        imag=imag+right.imag;
        return this;
    }
    public Mycomplex addNew(Mycomplex right){
        return new Mycomplex(this.real+right.real,this.imag+right.imag);
    }

}
