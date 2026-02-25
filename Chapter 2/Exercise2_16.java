import java.util.Scanner;

public class Exercise2_16 {
    public static void main(String[] args) {

        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        int number1; // first integer
        int number2; // second integer

        // prompt user for first integer
        
		System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        // prompt user for second integer
        
		System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        // compare numbers and display result
        
		if (number1 > number2)
            System.out.println(number1 + " is larger");

        if (number2 > number1)
            System.out.println(number2 + " is larger");

        if (number1 == number2)
            System.out.println("These numbers are equal");
    }
} 
