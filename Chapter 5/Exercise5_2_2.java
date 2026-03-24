import java.util.Scanner;

public class Exercise5_2_2 {

   // a) Convert Fahrenheit to Celsius
    public static int celsius(int fahrenheit) {
        return (int) Math.round(5.0 / 9.0 * (fahrenheit - 32));
    }

    // b) Convert Celsius to Fahrenheit
    public static int fahrenheit(int celsius) {
        return (int) Math.round(9.0 / 5.0 * celsius + 32);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Temperature Conversion Program");
        System.out.println("1: Fahrenheit to Celsius");
        System.out.println("2: Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter temperature in Fahrenheit: ");
                int f = input.nextInt();
                int c = celsius(f);
                System.out.println(f + "°F is " + c + "°C");
            }
            case 2 -> {
                System.out.print("Enter temperature in Celsius: ");
                int c = input.nextInt();
                int f = fahrenheit(c);
                System.out.println(c + "°C is " + f + "°F");
            }
            default -> System.out.println("Invalid option. Please choose 1 or 2.");
        }
    }
}