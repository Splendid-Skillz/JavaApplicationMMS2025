import java.util.Scanner;

public class Exercise5_1_5 {

    public static double hypotenuse(double side1, double side2) {
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter side1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side2: ");
        double side2 = input.nextDouble();

        double result = hypotenuse(side1, side2);

        System.out.printf("Hypotenuse: %.2f\n", result);

        input.close();
    }
}