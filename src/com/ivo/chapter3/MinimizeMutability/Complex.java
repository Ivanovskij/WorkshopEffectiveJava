package com.ivo.chapter3.MinimizeMutability;

/**
 * Неизменяемый класс — это просто такой класс, экземпляры ко­
    торого нельзя поменять. Вся информация, которая содержится в лю­
    бом его экземпляре, записывается в момент его создания и остается
    неизменной в течение всего времени существования этого объекта.
    
* В библиотеках для платформы Java имеется целый ряд неизменяе­
    мых классов, в том числе String, простые классы-оболочки, Biglnte-
    ger и BigDecimal . Для этого есть много веских причин: по сравнению
    с изменяемыми классами их проще проектировать, разрабатывать
    и использовать. Они менее подвержены ошибкам и более надежны.
 * @author IOAdmin
 */
public final class Complex {

    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
    
    public static Complex valueOfPolar(double r, double theta) {
        return new Complex(r * Math.cos(theta), 
                r * Math.sin(theta));
    }
    
    // Доступ к поляем без их изменения
    public double realPart() {
        return re;
    }
    
    public double imaginaryPart() {
        return im;
    }
    
    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }
    
    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }
    
    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }
    
    public Complex divide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re
                        * c.im)
                        / tmp);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) obj;
        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(re);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
	
    
    public static void main(String[] args) {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        
        Complex answer = c1.add(c2);
        System.out.println(answer);
    }
}
