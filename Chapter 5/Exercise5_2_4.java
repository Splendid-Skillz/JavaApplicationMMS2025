public class Exercise5_2_4 {

    // Method to determine if a number is perfect
    public static boolean isPerfect(long number) {
        long sum = 0;

        for (long i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Method to display factors
    public static void displayFactors(long number) {
        for (long i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Perfect numbers between 1 and 1000:");
        for (long number = 1; number <= 1000; number++) {
            if (isPerfect(number)) {
                System.out.println(number + " is a perfect number.");
                System.out.print("Factors: ");
                displayFactors(number);
            }
        }

        // Test larger numbers
        long[] largeNumbers = {8128L, 33550336L, 8589869056L, 137438691328L};
        System.out.println("\nTesting larger numbers:");
        for (long number : largeNumbers) {
            if (isPerfect(number)) {
                System.out.println(number + " is a perfect number.");
                System.out.print("Factors: ");
                displayFactors(number);
            } else {
                System.out.println(number + " is NOT a perfect number.");
            }
        }
    }
}