import java.security.SecureRandom;

public class Exercise6_1_7 {
    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();

        int[] frequency = new int[13]; // index 2–12 will be used

        // roll dice 36,000,000 times
        for (int i = 0; i < 36_000_000; i++) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;

            int sum = die1 + die2;

            frequency[sum]++;
        }

        // display results
        System.out.printf("%-10s%-10s%n", "Sum", "Frequency");

        for (int i = 2; i <= 12; i++) {
            System.out.printf("%-10d%-10d%n", i, frequency[i]);
        }
    }
}