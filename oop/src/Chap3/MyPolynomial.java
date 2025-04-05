package Chap3;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] == 0) {
                continue;
            }

            if (str.length() > 0) {
                str.append("+");
            }

            if (i == 0) {

                str.append(coeffs[i]);
            } else {
                str.append(coeffs[i]);
                str.append("x");
                if (i > 1) {
                    str.append("^").append(i);
                }
            }
        }
        return str.toString();
    }
    public double evaluated(double x){
        return coeffs[getDegree()]*x;
    }
}
