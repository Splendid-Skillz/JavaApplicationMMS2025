import java.util.Scanner;
import java.util.Random;

public class Exercise5_3_0 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        do {
            int number = random.nextInt(1000) + 1; // random number between 1 and 1000
            int guess = 0;

            System.out.println("Guess a number between 1 and 1000.");

            while (guess != number) {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();

                if (guess > number)
                    System.out.println("Too high. Try again.");
                else if (guess < number)
                    System.out.println("Too low. Try again.");
                else
                    System.out.println("Congratulations. You guessed the number!");
            }

            System.out.print("Would you like to play again (y/n)? ");
            playAgain = input.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing!");
    }
}