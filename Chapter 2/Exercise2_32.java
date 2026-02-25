import java.util.Scanner;

public class Exercise2_32 {

    public static void main(String[] args) {

        // create Scanner to obtain input
        Scanner input = new Scanner(System.in);

        int number1, number2, number3, number4, number5;
        int positives = 0;
        int negatives = 0;
        int zeros = 0;

        // prompt for five numbers
        System.out.print("Enter first number: ");
        number1 = input.nextInt();

        System.out.print("Enter second number: ");
        number2 = input.nextInt();

        System.out.print("Enter third number: ");
        number3 = input.nextInt();

        System.out.print("Enter fourth number: ");
        number4 = input.nextInt();

        System.out.print("Enter fifth number: ");
        number5 = input.nextInt();

        // check first number
        if (number1 > 0)
            positives++;
        if (number1 < 0)
            negatives++;
        if (number1 == 0)
            zeros++;

        // check second number
        if (number2 > 0)
            positives++;
        if (number2 < 0)
            negatives++;
        if (number2 == 0)
            zeros++;

        // check third number
        if (number3 > 0)
            positives++;
        if (number3 < 0)
            negatives++;
        if (number3 == 0)
            zeros++;

        // check fourth number
        if (number4 > 0)
            positives++;
        if (number4 < 0)
            negatives++;
        if (number4 == 0)
            zeros++;

        // check fifth number
        if (number5 > 0)
            positives++;
        if (number5 < 0)
            negatives++;
        if (number5 == 0)
            zeros++;

        // display results
        System.out.println("Positive numbers: " + positives);
        System.out.println("Negative numbers: " + negatives);
        System.out.println("Zeros: " + zeros);
		
		
    }
}