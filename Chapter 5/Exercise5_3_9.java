import java.util.Scanner;
import java.security.SecureRandom;

public class Exercise5_3_9 {

    static SecureRandom randomNumbers = new SecureRandom();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) { // allow multiple students
            System.out.print("Enter difficulty level (1 = 1-digit, 2 = 2-digit, 3 = 3-digit, etc.): ");
            int difficulty = input.nextInt();

            System.out.println("Choose problem type: ");
            System.out.println("1 = Addition, 2 = Subtraction, 3 = Multiplication, 4 = Division, 5 = Random mixture");
            int problemType = input.nextInt();

            runStudentSession(difficulty, problemType);
        }
    }

    // Run a session of 10 questions
    public static void runStudentSession(int difficulty, int problemType) {
        int correctCount = 0;
        int totalQuestions = 10;

        for (int i = 0; i < totalQuestions; i++) {
            boolean correct = askQuestion(difficulty, problemType);
            if (correct) correctCount++;
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

    // Ask a single arithmetic question; returns true if correct
    public static boolean askQuestion(int difficulty, int problemType) {
        int maxNumber = (int) Math.pow(10, difficulty) - 1;
        int minNumber = (int) Math.pow(10, difficulty - 1);
        if (difficulty == 1) minNumber = 1;

        int number1 = minNumber + randomNumbers.nextInt(maxNumber - minNumber + 1);
        int number2 = minNumber + randomNumbers.nextInt(maxNumber - minNumber + 1);

        // Determine problem type
        int type = problemType;
        if (problemType == 5) // random mixture
            type = 1 + randomNumbers.nextInt(4);

        double correctAnswer = 0;
        String operator = "?";

        switch (type) {
            case 1 -> { correctAnswer = number1 + number2; operator = "+"; }
            case 2 -> { correctAnswer = number1 - number2; operator = "-"; }
            case 3 -> { correctAnswer = number1 * number2; operator = "*"; }
            case 4 -> { 
                // Ensure number2 != 0 and use integer division for simplicity
                number2 = number2 == 0 ? 1 : number2; 
                correctAnswer = (double) number1 / number2; 
                operator = "/"; 
            }
        }

        double studentAnswer;
        do {
            System.out.printf("How much is %d %s %d? ", number1, operator, number2);
            studentAnswer = input.nextDouble();

            if (Math.abs(studentAnswer - correctAnswer) < 0.01) { // allow small tolerance for division
                printCorrectResponse();
                return true;
            } else {
                printIncorrectResponse();
                return false;
            }
        } while (Math.abs(studentAnswer - correctAnswer) >= 0.01);
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