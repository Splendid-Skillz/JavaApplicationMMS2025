// This program calculates the product of three integers.

import java.util.Scanner;

public class Exercise2_6 {

    public static void main(String[] args) {

        // Create Scanner to read input
        Scanner input = new Scanner(System.in);

        // Declare variables
        int x, y, z, result;

        // Prompt and read first integer
        System.out.print("Enter the first integer: ");
        x = input.nextInt();

        // Prompt and read second integer
        System.out.print("Enter the second integer: ");
        y = input.nextInt();

        // Prompt and read third integer
        System.out.print("Enter the third integer: ");
        z = input.nextInt();

        // Calculate product
        result = x * y * z;

        // Display result
        System.out.printf("Product is %d%n", result);

        input.close();
    }
}
