import java.util.Scanner;

public class Exercise2_24 {
	public static void main(String[] args){

    // create Scanner to obtain input
        Scanner input = new Scanner(System.in);

        int number1;
        int number2;
        int number3;
        int number4;
        int number5;

        int largest;
        int smallest;

    // prompt user for five integers
        System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        System.out.print("Enter third integer: ");
        number3 = input.nextInt();

        System.out.print("Enter fourth integer: ");
        number4 = input.nextInt();

        System.out.print("Enter fifth integer: ");
        number5 = input.nextInt();

    // assume first number is largest and smallest
        largest = number1;
        smallest = number1;

    // compare second number
        if (number2 > largest)
            largest = number2;

        if (number2 < smallest)
            smallest = number2;

    // compare third number
        if (number3 > largest)
            largest = number3;

        if (number3 < smallest)
            smallest = number3;

    // compare fourth number
        if (number4 > largest)
            largest = number4;

        if (number4 < smallest)
            smallest = number4;

    // compare fifth number
        if (number5 > largest)
            largest = number5;

        if (number5 < smallest)
            smallest = number5;

    // display results
        System.out.println("Largest is " + largest);
        System.out.println("Smallest is " + smallest);
    
	}
}
