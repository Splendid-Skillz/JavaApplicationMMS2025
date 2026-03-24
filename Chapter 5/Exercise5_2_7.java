import java.util.Scanner;

public class Exercise5_2_7 {

    // Method to find the GCD using Euclid's Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;   // remainder
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int num1 = input.nextInt();

        System.out.print("Enter second integer: ");
        int num2 = input.nextInt();

        int result = gcd(num1, num2);

        System.out.println("Greatest Common Divisor is: " + result);
    }
}