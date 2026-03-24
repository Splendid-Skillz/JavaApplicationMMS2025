public class Exercise6_2_9_b {

    public static void main(String[] args) {

        int prev = 0;
        int curr = 1;
        int count = 1;

        while (true) {
            int next = prev + curr;

            // overflow check
            if (next < 0) break;

            prev = curr;
            curr = next;
            count++;
        }

        System.out.println("Largest Fibonacci (int): " + curr);
        System.out.println("Position n: " + count);
    }
}