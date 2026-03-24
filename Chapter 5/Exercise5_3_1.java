import java.util.Scanner;
import java.util.Random;

public class Exercise5_3_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        do {
            int number = random.nextInt(1000) + 1; // random number between 1 and 1000
            int guess = 0;
            int guessCount = 0;

            System.out.println("Guess a number between 1 and 1000.");

            while (guess != number) {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();
                guessCount++;

                if (guess > number)
                    System.out.println("Too high. Try again.");
                else if (guess < number)
                    System.out.println("Too low. Try again.");
                else
                    System.out.println("Congratulations. You guessed the number!");
            }

            // Evaluate the number of guesses
            if (guessCount < 10)
                System.out.println("Either you know the secret or you got lucky!");
            else if (guessCount == 10)
                System.out.println("Aha! You know the secret!");
            else
                System.out.println("You should be able to do better!");

            System.out.print("Would you like to play again (y/n)? ");
            playAgain = input.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing!");
    }
}