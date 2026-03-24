import java.util.Scanner;
import java.security.SecureRandom;

public class Exercise5_3_7 {

    static SecureRandom randomNumbers = new SecureRandom();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) { // continuous for multiple students
            runStudentSession();
        }
    }

    // Run one student session (10 questions)
    public static void runStudentSession() {
        int correctCount = 0;
        int incorrectCount = 0;

        for (int i = 0; i < 10; i++) {
            boolean correct = askQuestion(); // returns true if answered correctly
            if (correct)
                correctCount++;
            else
                incorrectCount++;
        }

        double percentage = (correctCount / 10.0) * 100;

        System.out.printf("You got %d correct out of 10. (%.1f%%)%n", correctCount, percentage);

        if (percentage < 75.0) {
            System.out.println("Please ask your teacher for extra help.");
        } else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }

        System.out.println("\n--- Next student can try ---\n");
    }

    // Ask a single multiplication question; returns true if correct
    public static boolean askQuestion() {
        int number1 = 1 + randomNumbers.nextInt(9);
        int number2 = 1 + randomNumbers.nextInt(9);
        int correctAnswer = number1 * number2;
        int studentAnswer;

        do {
            System.out.printf("How much is %d times %d? ", number1, number2);
            studentAnswer = input.nextInt();

            if (studentAnswer == correctAnswer) {
                printCorrectResponse();
                return true; // correct answer
            } else {
                printIncorrectResponse();
                return false; // incorrect answer (counted once per try)
            }

        } while (studentAnswer != correctAnswer); // student can try again
    }

    // Random correct response
    public static void printCorrectResponse() {
        int response = 1 + randomNumbers.nextInt(4);

        switch (response) {
            case 1 -> System.out.println("Very good!");
            case 2 -> System.out.println("Excellent!");
            case 3 -> System.out.println("Nice work!");
            case 4 -> System.out.println("Keep up the good work!");
        }
    }

    // Random incorrect response
    public static void printIncorrectResponse() {
        int response = 1 + randomNumbers.nextInt(4);

        switch (response) {
            case 1 -> System.out.println("No. Please try again.");
            case 2 -> System.out.println("Wrong. Try once more.");
            case 3 -> System.out.println("Don't give up! No.");
            case 4 -> System.out.println("Keep trying.");
        }
    }
}