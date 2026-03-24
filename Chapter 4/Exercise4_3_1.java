import java.util.Scanner;

public class Exercise4_3_1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double housing, food, clothing, transportation, education, healthcare, vacations;
        double totalExpenses, fairTax;

        System.out.print("Enter yearly housing expenses: ");
        housing = input.nextDouble();

        System.out.print("Enter yearly food expenses: ");
        food = input.nextDouble();

        System.out.print("Enter yearly clothing expenses: ");
        clothing = input.nextDouble();

        System.out.print("Enter yearly transportation expenses: ");
        transportation = input.nextDouble();

        System.out.print("Enter yearly education expenses: ");
        education = input.nextDouble();

        System.out.print("Enter yearly healthcare expenses: ");
        healthcare = input.nextDouble();

        System.out.print("Enter yearly vacation expenses: ");
        vacations = input.nextDouble();

        totalExpenses = housing + food + clothing + transportation + education + healthcare + vacations;

        fairTax = totalExpenses * 0.23;

        System.out.println("\nTotal yearly expenses: $" + totalExpenses);
        System.out.println("Estimated FairTax (23%): $" + fairTax);
    }
}