import java.util.Scanner;

public class Exercise3_38 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 4-digit integer to encrypt: ");
        int number = input.nextInt();

        int[] digits = new int[4];

        // Extract digits
        digits[0] = number / 1000;             // first digit
        digits[1] = (number / 100) % 10;       // second digit
        digits[2] = (number / 10) % 10;        // third digit
        digits[3] = number % 10;               // fourth digit

        // Encrypt each digit
        for (int i = 0; i < 4; i++) {
            digits[i] = (digits[i] + 7) % 10;
        }

        // Swap first with third, second with fourth
        int temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;

        // Print encrypted number
        System.out.println("Encrypted number: " +
                           digits[0] + digits[1] + digits[2] + digits[3]);
    }
}