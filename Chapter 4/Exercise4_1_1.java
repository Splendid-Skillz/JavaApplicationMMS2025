import java.util.Scanner;

public class Exercise4_1_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int count;
        int number;
        int smallest;

        System.out.print("Enter the number of integers: ");
        count = input.nextInt();

        System.out.print("Enter an integer: ");
        smallest = input.nextInt();

        for (int i = 2; i <= count; i++) {
            System.out.print("Enter an integer: ");
            number = input.nextInt();

            if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("The smallest number is: " + smallest);
    }
}