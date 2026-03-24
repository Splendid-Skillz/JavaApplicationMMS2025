public class Exercise8_11 {

    // Complex class
    static class Complex {
        private double realPart;
        private double imaginaryPart;

        // No-argument constructor (default 0,0)
        public Complex() {
            this(0.0, 0.0);
        }

        // Constructor with parameters
        public Complex(double realPart, double imaginaryPart) {
            this.realPart = realPart;
            this.imaginaryPart = imaginaryPart;
        }

        // Addition
        public Complex add(Complex other) {
            return new Complex(
                    this.realPart + other.realPart,
                    this.imaginaryPart + other.imaginaryPart
            );
        }

        // Subtraction
        public Complex subtract(Complex other) {
            return new Complex(
                    this.realPart - other.realPart,
                    this.imaginaryPart - other.imaginaryPart
            );
        }

        // Display in (real, imaginary) format
        public String toString() {
            return String.format("(%.2f, %.2f)", realPart, imaginaryPart);
        }
    }

    // Test program
    public static void main(String[] args) {

        Complex c1 = new Complex(3.5, 2.5);
        Complex c2 = new Complex(1.5, 4.0);

        System.out.println("Complex Numbers:");
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        Complex sum = c1.add(c2);
        Complex difference = c1.subtract(c2);

        System.out.println("\nAddition:");
        System.out.println("c1 + c2 = " + sum);

        System.out.println("\nSubtraction:");
        System.out.println("c1 - c2 = " + difference);
    }
}