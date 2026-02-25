import java.util.Scanner;

public class Exercise2_17 {
    public static void main(String[] args) {

        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        int number1; // first integer
        int number2; // second integer
        int number3; // third integer

        int sum;      // sum of numbers
        int average;  // average of numbers
        int product;  // product of numbers
        int smallest; // smallest number
        int largest;  // largest number

        // prompt user for integers
        
		System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        System.out.print("Enter third integer: ");
        number3 = input.nextInt();

        // calculate sum and product
        
		sum = number1 + number2 + number3;
        product = number1 * number2 * number3;

        // calculate average (integer division)
        
		average = sum / 3;

        // determine smallest number
        
		smallest = number1;

        if (number2 < smallest)
            smallest = number2;

        if (number3 < smallest)
            smallest = number3;

        // determine largest number
        
		largest = number1;

        if (number2 > largest)
            largest = number2;

        if (number3 > largest)
            largest = number3;

        // display results
        
		System.out.println("Sum is " + sum);
        System.out.println("Average is " + average);
        System.out.println("Product is " + product);
        System.out.println("Smallest is " + smallest);
        System.out.println("Largest is " + largest);
    }
}
