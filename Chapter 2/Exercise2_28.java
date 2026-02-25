import java.util.Scanner;

public class Exercise2_28 {

    public static void main(String[] args) {

        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        int radius; // radius of circle

        // prompt for and read radius
        System.out.print("Enter the radius as an integer: ");
        radius = input.nextInt();

        // display diameter, circumference and area
        System.out.printf("Diameter is %d%n", 2 * radius);
        System.out.printf("Circumference is %f%n", 2 * 3.14159 * radius);
        System.out.printf("Area is %f%n", 3.14159 * radius * radius);
		
		
    }
}