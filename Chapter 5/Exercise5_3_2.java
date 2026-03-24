import java.util.Scanner;

public class Exercise5_3_2 {

    // Method to calculate distance between two points
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double x1, y1, x2, y2;

        System.out.print("Enter x1: ");
        x1 = input.nextDouble();

        System.out.print("Enter y1: ");
        y1 = input.nextDouble();

        System.out.print("Enter x2: ");
        x2 = input.nextDouble();

        System.out.print("Enter y2: ");
        y2 = input.nextDouble();

        double result = distance(x1, y1, x2, y2);

        System.out.println("Distance between the points: " + result);
    }
}