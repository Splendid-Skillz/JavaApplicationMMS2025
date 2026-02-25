import java.util.Scanner;

public class Exercise2_34 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double population;   // current population
        double growthRate;   // annual growth rate (as decimal)

        // prompt user
        System.out.print("Enter current world population: ");
        population = input.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.009 for 0.9%): ");
        growthRate = input.nextDouble();

        // calculate future populations
        double year1 = population * (1 + growthRate);
        double year2 = year1 * (1 + growthRate);
        double year3 = year2 * (1 + growthRate);
        double year4 = year3 * (1 + growthRate);
        double year5 = year4 * (1 + growthRate);

        // display results
        System.out.printf("After 1 year: %.0f%n", year1);
        System.out.printf("After 2 years: %.0f%n", year2);
        System.out.printf("After 3 years: %.0f%n", year3);
        System.out.printf("After 4 years: %.0f%n", year4);
        System.out.printf("After 5 years: %.0f%n", year5);
		
		
    }
}