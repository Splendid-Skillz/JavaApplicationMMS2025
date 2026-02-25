import java.util.Scanner;

public class Exercise2_26 {
    public static void main(String[] args) {

        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        int number1; // first integer
        int number2; // second integer

        // prompt user for integers
        System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        // determine whether first is a multiple of second
        if (number2 != 0 && number1 % number2 == 0)
            System.out.println(number1 + " is a multiple of " + number2);

        if (number2 != 0 && number1 % number2 != 0)
            System.out.println(number1 + " is not a multiple of " + number2);

        if (number2 == 0)
            System.out.println("Division by zero is not allowed.");
			
			
    }
}