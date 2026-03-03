import java.util.Scanner;

public class Exercise3_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int largest = Integer.MIN_VALUE; // smallest possible integer
        int number;
        int counter;

        for (counter = 1; counter <= 10; counter++) {
            System.out.print("Enter integer #" + counter + ": ");
            number = input.nextInt();

            if (number > largest) {
                largest = number; // update largest if number is bigger
            }
        }

        System.out.println("The largest number entered is: " + largest);

        input.close();
    }
}