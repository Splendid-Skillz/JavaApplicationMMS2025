import java.util.Scanner;

public class Exercise8_4 {

    private double length = 1.0;
    private double width = 1.0;

    // Constructor
    public Exercise8_4() {}

    public Exercise8_4(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    // Setters with validation
    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        } else {
            System.out.println("Invalid length (must be > 0.0 and < 20.0).");
        }
    }

    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0) {
            this.width = width;
        } else {
            System.out.println("Invalid width (must be > 0.0 and < 20.0).");
        }
    }

    // Getters
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Perimeter
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Area
    public double getArea() {
        return length * width;
    }

    // Main method (test program)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Exercise8_4 rect = new Exercise8_4();

        System.out.print("Enter length (0.0 - 20.0): ");
        double length = input.nextDouble();
        rect.setLength(length);

        System.out.print("Enter width (0.0 - 20.0): ");
        double width = input.nextDouble();
        rect.setWidth(width);

        System.out.println("\n--- Rectangle Details ---");
        System.out.println("Length: " + rect.getLength());
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());

        input.close();
    }
}