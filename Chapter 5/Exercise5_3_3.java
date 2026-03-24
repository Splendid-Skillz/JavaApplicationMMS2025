import java.util.Scanner;
import java.util.Random;

public class Exercise5_3_3 {

    static Random randomNumbers = new Random();

    enum Status { CONTINUE, WON, LOST }

    // Roll two dice
    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;

        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
        return sum;
    }

    // Random chatter messages
    public static void chatter() {
        int message = randomNumbers.nextInt(3);

        switch (message) {
            case 0:
                System.out.println("Oh, you're going for broke, huh?");
                break;
            case 1:
                System.out.println("Aw c'mon, take a chance!");
                break;
            case 2:
                System.out.println("You're up big. Now's the time to cash in your chips!");
                break;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int bankBalance = 1000;

        while (bankBalance > 0) {

            System.out.println("Your bank balance is: $" + bankBalance);

            int wager;

            // Validate wager
            do {
                System.out.print("Enter your wager: ");
                wager = input.nextInt();

                if (wager > bankBalance)
                    System.out.println("Wager must be less than or equal to bank balance.");
            } while (wager > bankBalance);

            chatter();

            int myPoint = 0;
            Status gameStatus;

            int sumOfDice = rollDice();

            switch (sumOfDice) {
                case 7:
                case 11:
                    gameStatus = Status.WON;
                    break;

                case 2:
                case 3:
                case 12:
                    gameStatus = Status.LOST;
                    break;

                default:
                    gameStatus = Status.CONTINUE;
                    myPoint = sumOfDice;
                    System.out.println("Point is " + myPoint);
                    break;
            }

            while (gameStatus == Status.CONTINUE) {
                sumOfDice = rollDice();

                if (sumOfDice == myPoint)
                    gameStatus = Status.WON;
                else if (sumOfDice == 7)
                    gameStatus = Status.LOST;
            }

            if (gameStatus == Status.WON) {
                System.out.println("Player wins!");
                bankBalance += wager;
            } else {
                System.out.println("Player loses!");
                bankBalance -= wager;
            }

            System.out.println("New bank balance: $" + bankBalance);

            if (bankBalance == 0)
                System.out.println("Sorry. You busted!");
        }
    }
}