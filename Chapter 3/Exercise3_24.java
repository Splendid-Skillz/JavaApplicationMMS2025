import java.util.Scanner;

public class Exercise3_24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        // Keep asking until the user enters 1 or 2
        do {
            System.out.print("Enter 1 or 2: ");
            choice = input.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid input! Please enter 1 or 2.");
            }
        } while (choice != 1 && choice != 2);

        System.out.println("You entered a valid choice: " + choice);
    }
}