public class Exercise5_2_5 {

    // a) Check if number is prime (dividing up to n/2)
    public static boolean isPrimeHalf(int n) {
        if (n <= 1) return false; // 1 and below not prime
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // c) Check if number is prime (dividing up to sqrt(n))
    public static boolean isPrimeSqrt(int n) {
        if (n <= 1) return false; // 1 and below not prime
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int limit = 10000;

        System.out.println("Primes less than " + limit + " using n/2 method:");
        int countHalf = 0;
        for (int n = 2; n < limit; n++) {
            if (isPrimeHalf(n)) {
                System.out.print(n + " ");
                countHalf++;
            }
        }
        System.out.println("\nTotal primes found: " + countHalf);

        System.out.println("\nPrimes less than " + limit + " using sqrt(n) method:");
        int countSqrt = 0;
        for (int n = 2; n < limit; n++) {
            if (isPrimeSqrt(n)) {
                System.out.print(n + " ");
                countSqrt++;
            }
        }
        System.out.println("\nTotal primes found: " + countSqrt);

        System.out.println("\nObservation: Both methods find the same primes, but sqrt(n) method is much faster.");
    }
}