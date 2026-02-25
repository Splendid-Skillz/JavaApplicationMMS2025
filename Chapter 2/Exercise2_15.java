import java.util.Scanner;

public class Exercise2_15 {
    public static void main(String[] args) {

      // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        int number1;      // first integer
        int number2;      // second integer
        int sum;          // sum of numbers
        int product;      // product of numbers
        int difference;   // difference of numbers
        int quotient;     // quotient of numbers

      // prompt user for first integer
        System.out.print("Enter first integer: ");
        number1 = input.nextInt();

      // prompt user for second integer
        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

      // calculate results
        sum = number1 + number2;
        product = number1 * number2;
        difference = number1 - number2;

      // display results
        System.out.println("Sum is " + sum);
        System.out.println("Product is " + product);
        System.out.println("Difference is " + difference);

      // avoid division by zero
        if (number2 != 0) {
            quotient = number1 / number2;
            System.out.println("Quotient is " + quotient);
        }

        if (number2 == 0)
            System.out.println("Division by zero is not allowed.");
    }
}