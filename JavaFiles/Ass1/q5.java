package Ass1;

public class q5 {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 2);
        Complex c2 = new Complex(4, -2);

        System.out.println("Sum of " + c1 + " and " + c2 + " is: " + Complex.add(c1, c2));
        System.out.println("Product of " + c1 + " and " + c2 + " is: " + Complex.multiply(c1, c2));
    }
}

class Complex {
    Complex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    Complex(double real) {
        this.real = real;
        this.imag = 0.0;
    }

    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    static Complex add(Complex c1, Complex c2) {
        double real = c1.real + c2.real;
        double imag = c1.imag + c2.imag;
        Complex result = new Complex(real, imag);
        return result;
    }

    static Complex multiply(Complex c1, Complex c2) {
        double real = c1.real * c2.real - c1.imag * c2.imag;
        double imag = c1.real * c2.imag + c1.imag * c2.real;
        Complex result = new Complex(real, imag);
        return result;
    }

    @Override
    public String toString() {
        if (imag == 0.0)
            return String.valueOf(real);

        String sign;
        if (imag < 0)
            sign = "-";
        else
            sign = "+";

        if (imag == 1.0)
            return real + " " + sign + " i";
        return real + " " + sign + " " + Math.abs(imag) + "i";
    }

    double real;
    double imag;
}