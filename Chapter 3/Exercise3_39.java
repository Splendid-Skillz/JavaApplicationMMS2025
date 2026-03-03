import java.util.Scanner;
import java.text.DecimalFormat;

public class Exercise3_39 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        // Assumptions
        double population;
        double growthRate;

        // Input current population and growth rate
        System.out.print("Enter current world population: ");
        population = input.nextDouble();

        System.out.print("Enter annual growth rate (as a percentage, e.g., 1 for 1%): ");
        growthRate = input.nextDouble() / 100.0;  // convert to decimal

        double initialPopulation = population;  // to track doubling
        int doublingYear = -1;

        System.out.printf("%-5s %-20s %-20s%n", "Year", "Population", "Increase");
        System.out.println("----------------------------------------------------");

        for (int year = 1; year <= 75; year++) {
            double increase = population * growthRate;
            population += increase;

            System.out.printf("%-5d %-20s %-20s%n", year, df.format((long)population), df.format((long)increase));

            if (doublingYear == -1 && population >= 2 * initialPopulation) {
                doublingYear = year;
            }
        }

        if (doublingYear != -1) {
            System.out.println("\nThe world population would double in year: " + doublingYear);
        } else {
            System.out.println("\nThe world population does not double within 75 years at this growth rate.");
        }
    }
}