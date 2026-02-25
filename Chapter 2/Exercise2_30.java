import java.util.Scanner;

public class Exercise2_30 {
    public static void main(String[] args) {

        // create Scanner to obtain input
        Scanner input = new Scanner(System.in);

        int number; // five-digit number

        // prompt user
        System.out.print("Enter a five-digit integer: ");
        number = input.nextInt();

        // separate digits
        int digit1 = number / 10000;
        int digit2 = (number % 10000) / 1000;
        int digit3 = (number % 1000) / 100;
        int digit4 = (number % 100) / 10;
        int digit5 = number % 10;

        // display digits separated by three spaces
        System.out.println(digit1 + "   " + digit2 + "   " + digit3
                + "   " + digit4 + "   " + digit5);
				
				
    }
}