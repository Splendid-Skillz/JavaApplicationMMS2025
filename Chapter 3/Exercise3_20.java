import java.util.Scanner;

public class Exercise3_20 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int NUM_EMPLOYEES = 3;

        // Arrays to store employee data
        String[] employeeNames = new String[NUM_EMPLOYEES];
        double[] hoursWorked = new double[NUM_EMPLOYEES];
        double[] hourlyRates = new double[NUM_EMPLOYEES];
        double[] grossPay = new double[NUM_EMPLOYEES];

        // Input employee details
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            System.out.println("Enter name of employee " + (i + 1) + ": ");
            employeeNames[i] = input.nextLine();

            System.out.println("Enter hours worked by " + employeeNames[i] + ": ");
            hoursWorked[i] = input.nextDouble();

            System.out.println("Enter hourly rate of " + employeeNames[i] + ": ");
            hourlyRates[i] = input.nextDouble();
            input.nextLine(); // consume the leftover newline

            // Calculate gross pay
            if (hoursWorked[i] <= 40) {
                grossPay[i] = hoursWorked[i] * hourlyRates[i];
            } else {
                double overtimeHours = hoursWorked[i] - 40;
                grossPay[i] = (40 * hourlyRates[i]) + (overtimeHours * hourlyRates[i] * 1.5);
            }

            System.out.println(); // blank line for readability
        }

        // Display results
        System.out.println("Employee Gross Pay:");
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            System.out.printf("%s: $%.2f%n", employeeNames[i], grossPay[i]);
        }

        input.close();
    }
}