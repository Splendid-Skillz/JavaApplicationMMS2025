import java.util.Scanner;

public class Exercise5_1_4 {

    public static int integerPower(int base, int exponent) {
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter base: ");
        int base = input.nextInt();

        System.out.print("Enter exponent: ");
        int exponent = input.nextInt();

        int power = integerPower(base, exponent);

        System.out.println("Result: " + power);

        input.close();
    }
}