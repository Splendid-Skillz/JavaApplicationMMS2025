import java.util.Scanner;
import java.security.SecureRandom;

public class Exercise5_3_8 {

    static SecureRandom randomNumbers = new SecureRandom();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) { // multiple students
            System.out.print("Enter difficulty level (1 = 1-digit, 2 = 2-digit, 3 = 3-digit, etc.): ");
            int difficulty = input.nextInt();
            runStudentSession(difficulty);
        }
    }

    // Run a session for one student
    public static void runStudentSession(int difficulty) {
        int correctCount = 0;
        int totalQuestions = 10;

        for (int i = 0; i < totalQuestions; i++) {
            boolean correct = askQuestion(difficulty);
            if (correct)
                correctCount++;
        }

        double percentage = (correctCount / (double) totalQuestions) * 100;

        System.out.printf("You got %d correct out of %d. (%.1f%%)%n",
                correctCount, totalQuestions, percentage);

        if (percentage < 75.0)
            System.out.println("Please ask your teacher for extra help.");
        else
            System.out.println("Congratulations, you are ready to go to the next level!");

        System.out.println("\n--- Next student can try ---\n");
    }

    // Ask a multiplication question; returns true if answered correctly
    public static boolean askQuestion(int difficulty) {
        int maxNumber = (int) Math.pow(10, difficulty) - 1; // max value based on difficulty
        int minNumber = (int) Math.pow(10, difficulty - 1); // min value for level >=2
        if (difficulty == 1) minNumber = 1;

        int number1 = minNumber + randomNumbers.nextInt(maxNumber - minNumber + 1);
        int number2 = minNumber + randomNumbers.nextInt(maxNumber - minNumber + 1);
        int correctAnswer = number1 * number2;
        int studentAnswer;

        do {
            System.out.printf("How much is %d times %d? ", number1, number2);
            studentAnswer = input.nextInt();

            if (studentAnswer == correctAnswer) {
                printCorrectResponse();
                return true;
            } else {
                printIncorrectResponse();
                return false;
            }
        } while (studentAnswer != correctAnswer);
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