import java.util.Scanner;
import java.security.SecureRandom;

public class Exercise5_3_6 {

    static SecureRandom randomNumbers = new SecureRandom();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        askQuestion(); // start the first question
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
                printCorrectResponse();
            } else {
                printIncorrectResponse();
            }

        } while (studentAnswer != correctAnswer);

        // Ask the next question after correct answer
        askQuestion();
    }

    // Random correct response
    public static void printCorrectResponse() {
        int response = 1 + randomNumbers.nextInt(4);

        switch (response) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    // Random incorrect response
    public static void printIncorrectResponse() {
        int response = 1 + randomNumbers.nextInt(4);

        switch (response) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up! No.");
                break;
            case 4:
                System.out.println("Keep trying.");
                break;
        }
    }
}