import java.util.Scanner;

public class Exercise6_2_9_a {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = input.nextInt();

        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    public static int fibonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0, curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}