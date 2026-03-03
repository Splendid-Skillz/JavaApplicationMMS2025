import java.util.Scanner;

public class Exercise3_23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int largest, secondLargest;
        
        System.out.print("Enter number 1: ");
        largest = input.nextInt();
        secondLargest = Integer.MIN_VALUE; // very small value

        for (int i = 2; i <= 10; i++) {
            System.out.print("Enter number " + i + ": ");
            int number = input.nextInt();

            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }
        }

        System.out.println("Largest number: " + largest);
        System.out.println("Second largest number: " + secondLargest);
    }
}