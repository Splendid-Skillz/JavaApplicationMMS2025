import java.util.Scanner;

public class Exercise5_1_6 {

    public static boolean isMultiple(int first, int second) {
        return second % first == 0;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num1, num2;

        System.out.print("Enter first integer (0 to stop): ");
        num1 = input.nextInt();

        while (num1 != 0) {

            System.out.print("Enter second integer: ");
            num2 = input.nextInt();

            if (isMultiple(num1, num2))
                System.out.println(num2 + " is a multiple of " + num1);
            else
                System.out.println(num2 + " is NOT a multiple of " + num1);

            System.out.println();

            System.out.print("Enter first integer (0 to stop): ");
            num1 = input.nextInt();
        }

        input.close();
    }
}