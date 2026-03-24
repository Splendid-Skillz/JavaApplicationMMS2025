import java.util.Scanner;

public class Exercise5_8 {

    public static double calculateCharges(double hours) {
        double charge;

        if (hours <= 3) {
            charge = 2.00;
        } else {
            charge = 2.00 + Math.ceil(hours - 3) * 0.50;
        }

        if (charge > 10.00) {
            charge = 10.00;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double hours;
        double charge;
        double totalReceipts = 0;

        System.out.print("Enter hours parked (negative number to stop): ");
        hours = input.nextDouble();

        while (hours >= 0) {
            charge = calculateCharges(hours);
            totalReceipts += charge;

            System.out.printf("Charge for this customer: $%.2f\n", charge);
            System.out.printf("Running total receipts: $%.2f\n\n", totalReceipts);

            System.out.print("Enter hours parked (negative number to stop): ");
            hours = input.nextDouble();
        }

        System.out.printf("\nTotal receipts for yesterday: $%.2f\n", totalReceipts);

        input.close();
    }
}