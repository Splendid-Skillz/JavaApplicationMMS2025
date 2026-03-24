public class Exercise6_2_7 {

    public static void main(String[] args) {

        int SIZE = 1000;
        boolean[] isPrime = new boolean[SIZE];

        // Step (a): initialize all entries as true
        for (int i = 0; i < SIZE; i++) {
            isPrime[i] = true;
        }

        // Ignore 0 and 1
        isPrime[0] = false;
        isPrime[1] = false;

        // Step (b): sieve process
        for (int i = 2; i < SIZE; i++) {

            if (isPrime[i]) {

                // mark multiples of i as false
                for (int j = i * 2; j < SIZE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Display prime numbers
        System.out.println("Prime numbers between 2 and 999:\n");

        for (int i = 2; i < SIZE; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}