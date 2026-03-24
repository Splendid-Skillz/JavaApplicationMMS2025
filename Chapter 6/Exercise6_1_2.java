import java.util.Scanner;

public class Exercise6_1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] unique = new int[5];
        int count = 0; // number of unique values stored

        int number;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number between 10 and 100: ");
            number = input.nextInt();

            // validate range
            if (number < 10 || number > 100) {
                System.out.println("Invalid input. Try again.");
                i--; // repeat this iteration
                continue;
            }

            boolean isDuplicate = false;

            // check for duplicate
            for (int j = 0; j < count; j++) {
                if (unique[j] == number) {
                    isDuplicate = true;
                    break;
                }
            }

            // store if not duplicate
            if (!isDuplicate) {
                unique[count] = number;
                count++;
            }

            // display current unique values
            System.out.print("Unique values: ");
            for (int j = 0; j < count; j++) {
                System.out.print(unique[j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}