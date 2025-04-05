package Chap2;

public class Mycomplex2 {
        private double real;
        private double imag;
        public Mycomplex2(){
            real=0.0;
            imag=0.0;
        }
        public Mycomplex2(double real, double imag){
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
        public boolean equals(Mycomplex2 another){
            return this.real==another.getReal()&&this.getImag()==another.imag;
        }
        public double magnitude(){
            return Math.sqrt(real*real+imag*imag);
        }
        public double argument(){
            return Math.atan2(imag,real);
        }
        public Mycomplex2 add(Mycomplex right){
            real=real+right.getReal();
            imag=imag+right.getImag();
            return this;
        }
        public Mycomplex2 addNew(Mycomplex2 right){
            return new Mycomplex2(real+right.getReal(),imag+right.getImag());
        }
        public Mycomplex2 subtract(Mycomplex2 right){
            real=real-right.getReal();
            imag=imag-right.getImag();
            return this;
        }
        public Mycomplex2 subtractNew(Mycomplex2 right){
            return new Mycomplex2(real-right.getReal(),imag-right.getImag());
        }
        public Mycomplex2 multiply(Mycomplex2 right){
            real=right.getReal()*real-right.getImag()*imag;
            imag=real*right.getImag()+right.getReal()*imag;
            return this;
        }
        public Mycomplex2 divide(Mycomplex2 right){
            real=(right.getReal()*real+right.getImag()*imag)/(Math.pow(right.getReal(),2)+Math.pow(right.getImag(),2));
            imag=(right.getReal()*imag-real*right.getImag())/(Math.pow(right.getReal(),2)+Math.pow(right.getImag(),2));
            return this;
        }
        public Mycomplex2 conjugate(){
            return new Mycomplex2(real,-imag);
        }
}
