import java.util.Scanner;

public class Exercise5_9 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double x;
        double y;

        System.out.print("Enter a number (negative number to stop): ");
        x = input.nextDouble();

        while (x >= 0) {

            y = Math.floor(x + 0.5);

            System.out.printf("Original number: %.2f\n", x);
            System.out.printf("Rounded number: %.0f\n\n", y);

            System.out.print("Enter a number (negative number to stop): ");
            x = input.nextDouble();
        }

        input.close();
    }
}