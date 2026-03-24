import java.util.Scanner;

public class Exercise5_2_6 {

      // Method to reverse the digits of an integer
    public static int reverseDigits(int number) {
        int reversed = 0;
        int n = Math.abs(number); // handle negative numbers

        while (n > 0) {
            int lastDigit = n % 10;       // get last digit
            reversed = reversed * 10 + lastDigit; // append to reversed number
            n /= 10;                      // remove last digit
        }

        // Preserve the sign of the original number
        return number < 0 ? -reversed : reversed;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer to reverse: ");
        int number = input.nextInt();

        int reversed = reverseDigits(number);

        System.out.println("Reversed number: " + reversed);
    }
}