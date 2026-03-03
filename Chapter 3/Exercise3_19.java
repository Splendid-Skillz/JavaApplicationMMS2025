import java.util.Scanner;

public class Exercise3_19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Fixed item prices
        double[] itemPrices = {239.99, 129.75, 99.95, 350.89};
        int[] quantities = new int[4]; // to store quantity sold for each item
        double totalSales = 0.0;
        final double BASE_PAY = 200.0;
        final double COMMISSION_RATE = 0.09;

        System.out.println("Enter the number of items sold for each product:");

        for (int i = 0; i < itemPrices.length; i++) {
            System.out.print("Item " + (i + 1) + " ($" + itemPrices[i] + "): ");
            quantities[i] = input.nextInt();

            if (quantities[i] < 0) {
                System.out.println("Invalid quantity. Setting it to 0.");
                quantities[i] = 0;
            }

            totalSales += itemPrices[i] * quantities[i];
        }

        // Calculate earnings
        double earnings = BASE_PAY + (COMMISSION_RATE * totalSales);

        System.out.printf("%nTotal sales: $%.2f%n", totalSales);
        System.out.printf("Earnings for the week: $%.2f%n", earnings);

        input.close();
    }
}