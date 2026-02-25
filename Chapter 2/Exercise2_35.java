import java.util.Scanner;

public class Exercise2_35 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double milesPerDay;
        double costPerGallon;
        double milesPerGallon;
        double parkingFees;
        double tolls;

        // input values
        System.out.print("Enter total miles driven per day: ");
        milesPerDay = input.nextDouble();

        System.out.print("Enter cost per gallon of gasoline: ");
        costPerGallon = input.nextDouble();

        System.out.print("Enter average miles per gallon: ");
        milesPerGallon = input.nextDouble();

        System.out.print("Enter parking fees per day: ");
        parkingFees = input.nextDouble();

        System.out.print("Enter tolls per day: ");
        tolls = input.nextDouble();

        // calculations
        double gallonsUsed = milesPerDay / milesPerGallon;
        double fuelCost = gallonsUsed * costPerGallon;
        double totalCost = fuelCost + parkingFees + tolls;

        // display result
        System.out.printf("Your daily driving cost is: $%.2f%n", totalCost);
		
		
    }
}