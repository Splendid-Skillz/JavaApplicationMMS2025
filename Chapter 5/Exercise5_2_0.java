import java.util.Scanner;

public class Exercise5_2_0 {

     // Method to calculate the area of a circle
    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for the radius
        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();

        // Calculate the area
        double area = circleArea(radius);

        // Display the result
        System.out.printf("The area of the circle is: %.2f%n", area);
    }
}