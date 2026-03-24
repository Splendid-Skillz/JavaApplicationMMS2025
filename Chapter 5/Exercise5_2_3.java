import java.util.Scanner;

public class Exercise5_2_3 {

    // Method that returns the smallest of three floating-point numbers
    public static double minimum3(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read three floating-point numbers from the user
        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        System.out.print("Enter the third number: ");
        double num3 = input.nextDouble();

        // Determine the smallest number
        double min = minimum3(num1, num2, num3);

        // Display the result
        System.out.println("The smallest number is: " + min);
    }
} 