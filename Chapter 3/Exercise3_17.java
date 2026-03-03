import java.util.Scanner;

public class Exercise3_17 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int miles;          // miles driven for a trip
        int gallons;        // gallons used for a trip
        int totalMiles = 0; 
        int totalGallons = 0;

        System.out.print("Enter miles driven (-1 to quit): ");
        miles = input.nextInt();

        // sentinel-controlled loop
        while (miles != -1) {
            
            System.out.print("Enter gallons used: ");
            gallons = input.nextInt();

            // calculate miles per gallon for this trip
            double mpg = (double) miles / gallons;
            System.out.printf("Miles per gallon for this trip: %.2f%n", mpg);

            // update totals
            totalMiles += miles;
            totalGallons += gallons;

            // calculate combined miles per gallon
            double combinedMpg = (double) totalMiles / totalGallons;
            System.out.printf("Combined miles per gallon: %.2f%n%n", combinedMpg);

            System.out.print("Enter miles driven (-1 to quit): ");
            miles = input.nextInt();
        }

        if (totalGallons != 0) {
            double finalMpg = (double) totalMiles / totalGallons;
            System.out.printf("%nOverall miles per gallon: %.2f%n", finalMpg);
        } else {
            System.out.println("No trips were entered.");
        }

        input.close();
    }
}