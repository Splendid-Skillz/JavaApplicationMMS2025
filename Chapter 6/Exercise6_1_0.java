import java.util.Scanner;

public class Exercise6_1_0 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] ranges = new int[9]; // 9 salary ranges
        double sales;

        System.out.println("Enter sales amount (-1 to end): ");
        sales = input.nextDouble();

        while (sales != -1) {
            int salary = (int) (200 + 0.09 * sales);

            int index = (salary - 200) / 100;

            if (index >= 8)
                ranges[8]++;
            else if (index >= 0)
                ranges[index]++;

            System.out.println("Enter sales amount (-1 to end): ");
            sales = input.nextDouble();
        }

        // Display results
        System.out.println("\nSalary Range\tNumber of Employees");

        System.out.println("$200-299\t" + ranges[0]);
        System.out.println("$300-399\t" + ranges[1]);
        System.out.println("$400-499\t" + ranges[2]);
        System.out.println("$500-599\t" + ranges[3]);
        System.out.println("$600-699\t" + ranges[4]);
        System.out.println("$700-799\t" + ranges[5]);
        System.out.println("$800-899\t" + ranges[6]);
        System.out.println("$900-999\t" + ranges[7]);
        System.out.println("$1000+\t\t" + ranges[8]);

        input.close();
    }
}