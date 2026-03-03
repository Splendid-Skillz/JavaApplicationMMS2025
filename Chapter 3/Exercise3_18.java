import java.util.Scanner;

public class Exercise3_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int accountNumber;
        int beginningBalance;
        int charges;
        int credits;
        int creditLimit;

        System.out.print("Enter account number (-1 to quit): ");
        accountNumber = input.nextInt();

        // Sentinel-controlled loop
        while (accountNumber != -1) {

            // Input customer data
            System.out.print("Enter beginning balance: ");
            beginningBalance = input.nextInt();

            System.out.print("Enter total charges for the month: ");
            charges = input.nextInt();

            System.out.print("Enter total credits for the month: ");
            credits = input.nextInt();

            System.out.print("Enter allowed credit limit: ");
            creditLimit = input.nextInt();

            // Calculate new balance
            int newBalance = beginningBalance + charges - credits;
            System.out.println("New balance for account " + accountNumber + ": " + newBalance);

            // Check if credit limit exceeded
            if (newBalance > creditLimit) {
                System.out.println("Credit limit exceeded");
            }

            System.out.println(); // blank line for readability

            // Ask for next account
            System.out.print("Enter account number (-1 to quit): ");
            accountNumber = input.nextInt();
        }

        System.out.println("Program ended.");
        input.close();
    }
}