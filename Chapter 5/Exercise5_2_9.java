import java.util.Scanner;
import java.util.Random;

public class Exercise5_2_9 {

    // Enum representing the two sides of a coin
    enum Coin {
        HEADS, TAILS
    }

    static Random random = new Random();

    // Method that simulates flipping a coin
    public static Coin flip() {
        int result = random.nextInt(2); // 0 or 1
        if (result == 0)
            return Coin.HEADS;
        else
            return Coin.TAILS;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int headsCount = 0;
        int tailsCount = 0;
        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Toss Coin");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            if (choice == 1) {
                Coin result = flip();

                if (result == Coin.HEADS) {
                    headsCount++;
                    System.out.println("Result: HEADS");
                } else {
                    tailsCount++;
                    System.out.println("Result: TAILS");
                }

                System.out.println("Heads so far: " + headsCount);
                System.out.println("Tails so far: " + tailsCount);
            }

        } while (choice != 2);

        System.out.println("\nFinal Results:");
        System.out.println("Heads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
    }
}