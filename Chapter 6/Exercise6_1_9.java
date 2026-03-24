import java.util.Scanner;

public class Exercise6_1_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 5 products (rows) × 4 salespeople (columns)
        double[][] sales = new double[5][4];

        int salesperson;
        int product;
        double amount;

        System.out.println("Enter sales data (enter -1 to stop):");

        while (true) {
            System.out.print("Enter salesperson number (1-4) or -1 to finish: ");
            salesperson = input.nextInt();
            if (salesperson == -1) break;

            System.out.print("Enter product number (1-5): ");
            product = input.nextInt();

            System.out.print("Enter sales amount: ");
            amount = input.nextDouble();

            // Store data in array
            sales[product - 1][salesperson - 1] += amount;
        }

        // Print table header
        System.out.println("\nSales Summary Table:");
        System.out.print("Product\t");

        for (int i = 1; i <= 4; i++) {
            System.out.print("Salesperson " + i + "\t");
        }
        System.out.println("Total");

        // Variables for column totals
        double[] salespersonTotals = new double[4];

        // Display table with row totals
        for (int i = 0; i < 5; i++) {
            double rowTotal = 0.0;
            System.out.print("Product " + (i + 1) + "\t");

            for (int j = 0; j < 4; j++) {
                System.out.printf("%.2f\t\t", sales[i][j]);
                rowTotal += sales[i][j];
                salespersonTotals[j] += sales[i][j];
            }

            System.out.printf("%.2f\n", rowTotal);
        }

        // Print column totals
        System.out.print("Total\t\t");
        double grandTotal = 0.0;

        for (int j = 0; j < 4; j++) {
            System.out.printf("%.2f\t\t", salespersonTotals[j]);
            grandTotal += salespersonTotals[j];
        }

        System.out.printf("%.2f\n", grandTotal);

        input.close();
    }
}