import java.util.Scanner;
import java.security.SecureRandom;

public class Exercise5_3_5 {

    static SecureRandom randomNumbers = new SecureRandom();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Start the first question
        askQuestion();
    }

    // Method to generate and ask a multiplication question
    public static void askQuestion() {
        int number1 = 1 + randomNumbers.nextInt(9); // 1–9
        int number2 = 1 + randomNumbers.nextInt(9); // 1–9
        int correctAnswer = number1 * number2;
        int studentAnswer;

        do {
            System.out.printf("How much is %d times %d? ", number1, number2);
            studentAnswer = input.nextInt();

            if (studentAnswer == correctAnswer) {
                System.out.println("Very good!");
            } else {
                System.out.println("No. Please try again.");
            }
        } while (studentAnswer != correctAnswer);

        // Ask the next question after correct answer
        askQuestion();
    }
}