import java.util.Scanner;

public class Exercise2_25 {
	public static void main(String[] args){
	
	// create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        int number; // integer entered by user

    // prompt user for integer
        System.out.print("Enter an integer: ");
        number = input.nextInt();

    // determine whether number is even or odd
        if (number % 2 == 0)
            System.out.println(number + " is even");

        if (number % 2 != 0)
            System.out.println(number + " is odd");
		
		
    }
}