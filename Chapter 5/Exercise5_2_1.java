import java.util.Scanner;

public class Exercise5_2_1 {

    // a) Calculate integer quotient
    public static int quotient(int a, int b) {
        return a / b;
    }

    // b) Calculate integer remainder
    public static int remainder(int a, int b) {
        return a % b;
    }

    // c) Display digits separated by two spaces
    public static void displayDigits(int number) {
        if (number < 1 || number > 99999) {
            System.out.println("Number must be between 1 and 99999.");
            return;
        }

        int divisor = 10000; // start with the largest possible digit place
        boolean leadingZero = true;

        while (divisor > 0) {
            int digit = quotient(number, divisor);
            number = remainder(number, divisor);

            if (digit != 0 || !leadingZero || divisor == 1) {
                System.out.print(digit + "  ");
                leadingZero = false;
            }

            divisor /= 10;
        }

        System.out.println(); // move to next line
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read integer from user
        System.out.print("Enter an integer (1-99999): ");
        int number = input.nextInt();

        // Display the digits separated by two spaces
        displayDigits(number);
    }
} 