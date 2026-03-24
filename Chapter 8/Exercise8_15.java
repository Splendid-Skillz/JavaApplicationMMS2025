public class Exercise8_15 {

    public static void main(String[] args) {
        Rational r1 = new Rational(2, 4);   // reduced to 1/2
        Rational r2 = new Rational(3, 6);   // reduced to 1/2

        System.out.println("Rational 1: " + r1);
        System.out.println("Rational 2: " + r2);

        Rational sum = Rational.add(r1, r2);
        Rational diff = Rational.subtract(r1, r2);
        Rational prod = Rational.multiply(r1, r2);
        Rational quot = Rational.divide(r1, r2);

        System.out.println("\nResults:");
        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + diff);
        System.out.println("Multiplication: " + prod);
        System.out.println("Division: " + quot);

        // Floating-point output with precision
        System.out.println("\nFloating-point (3 d.p):");
        System.out.println("Sum: " + sum.toDouble(3));
        System.out.println("Difference: " + diff.toDouble(3));
        System.out.println("Product: " + prod.toDouble(3));
        System.out.println("Quotient: " + quot.toDouble(3));
    }
}

class Rational {
    private int numerator;
    private int denominator;

    // No-argument constructor
    public Rational() {
        this(0, 1);
    }

    // Constructor with parameters (stored in reduced form)
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        // Ensure denominator is positive
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;

        reduce();
    }

    // Reduce fraction
    private void reduce() {
        int gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Euclid's GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Addition
    public static Rational add(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator +
                  r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    // Subtraction
    public static Rational subtract(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator -
                  r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    // Multiplication
    public static Rational multiply(Rational r1, Rational r2) {
        int num = r1.numerator * r2.numerator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    // Division
    public static Rational divide(Rational r1, Rational r2) {
        if (r2.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        int num = r1.numerator * r2.denominator;
        int den = r1.denominator * r2.numerator;

        return new Rational(num, den);
    }

    // a/b format
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Floating-point with precision
    public String toDouble(int precision) {
        double value = (double) numerator / denominator;
        return String.format("%." + precision + "f", value);
    }
}